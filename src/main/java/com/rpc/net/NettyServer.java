/**
 * Package: com.rpc.net
 * Description: 
 */
package com.rpc.net;

import com.rpc.protect.Url;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Description:  
 * Date: 2018年5月11日 下午3:09:58
 * @author wufenyun 
 */
public class NettyServer {
    
    private ServerBootstrap bootstrap;
    
    public void open(Url url,final ChannelHandler adapthandler) {
        bootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(Integer.valueOf(url.getParamValue("IO_THREADS")));
        bootstrap.group(boss,worker)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<Channel>() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new StringEncoder());
                pipeline.addLast(new StringDecoder());
                pipeline.addLast(adapthandler);
            }
        });
        
        try {
            bootstrap.bind(url.getPort()).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
