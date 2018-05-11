package com.rpc.net;

import com.rpc.protect.Url;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClient {

    private Bootstrap bootstrap;
    
    public void createClient(Url url) {
        bootstrap = new Bootstrap();
        NioEventLoopGroup worker = new NioEventLoopGroup(Integer.valueOf(url.getParamValue("IO_THREADS")));
        bootstrap.group(worker)
        .channel(NioServerSocketChannel.class)
        .handler(new ChannelInitializer<Channel>() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new StringEncoder());
                pipeline.addLast(new StringDecoder());
            }
        });
    }
}
