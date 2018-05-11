package com.rpc.protect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rpc.net.NettyServer;
import com.rpc.net.Transporter;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class SimpleProtocol implements Protocol {
    
    private Map<String,NettyServer> serverMap = new ConcurrentHashMap<>();
    private Map<Url,Exporter> exporters = new ConcurrentHashMap<>(); 
    
    private ChannelHandler adapthandler = new SimpleChannelInboundHandler(){
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("接收到消息");
            received(ctx.channel(),(RpcInvocation) msg);
        }

    };
    
    private void openserver(Url url) {
        serverMap.put("", Transporter.bind(url,adapthandler));
    }

    private void received(Channel channel,RpcInvocation invocation) {
        Exporter exporter = exporters.get(getServiceKey(invocation));
        exporter.getInvoker().invoke(invocation);
    }
    
    private String getServiceKey(RpcInvocation invocation) {
        return invocation.method() + invocation.version();
    }
    
    
    @Override
    public Exporter export(Invoker invoker) {
        openserver(invoker.getUrl());
        return new Exporter() {

            @Override
            public Invoker getInvoker() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public Invoker refrence(Url url) {
        Transporter.connect(url);
        return null;
    }

}
