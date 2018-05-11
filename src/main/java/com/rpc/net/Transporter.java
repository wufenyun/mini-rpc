/**
 * Package: com.rpc.net
 * Description: 
 */
package com.rpc.net;

import com.rpc.protect.Url;

import io.netty.channel.ChannelHandler;

/**
 * Description:  
 * Date: 2018年5月11日 下午2:57:43
 * @author wufenyun 
 */
public class Transporter {

    public static NettyServer bind(Url url,ChannelHandler adapthandler) {
        NettyServer server = new NettyServer();
        server.open(url,adapthandler);
        return server;
    }

    public static void connect(Url url) {
        NettyClient client = new NettyClient();
        client.createClient(url);
    }
}
