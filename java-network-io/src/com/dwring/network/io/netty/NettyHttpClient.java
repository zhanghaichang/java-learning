package com.dwring.network.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Title: NettyHttpClient.java
 * @Package com.dwring.network.io.netty
 * @Description: TODO
 * @author haichangzhang
 * @date 2018年4月23日 下午4:12:31
 * @version V1.0
 */
public class NettyHttpClient {

	 public static void main(String[] args) throws InterruptedException {
	        NettyHttpClient client = new NettyHttpClient();

	        for (;;) {
	            long startTime = System.currentTimeMillis();
	            for (int i = 0; i < 1; i++) {
	                client.execute();
	            }
	            long endTime = System.currentTimeMillis();
	            long diffTime = endTime - startTime;
	            if (diffTime < 10000){
	                Thread.sleep(100000-diffTime);
	            }
	        }

	    }

	    Bootstrap client;

	    public NettyHttpClient() {
	        NioEventLoopGroup group = new NioEventLoopGroup(100);
	        this.client = new Bootstrap()
	                .group(group)
	                .option(ChannelOption.TCP_NODELAY, true)
	                .option(ChannelOption.SO_LINGER, 0) //避免TIME_WAIT状态
//	                .option(ChannelOption.SO_REUSEADDR, true)
//	                .option(ChannelOption.SO_BACKLOG, 0)
	                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
	                .handler(new HttpClientChannelInitializer())
	                .channel(NioSocketChannel.class);
	    }

	    public void execute() throws InterruptedException {
	        ChannelFuture cf = client.connect("www.sina.com", 80);
	        cf.addListener(new ChannelFutureListener() {
	            public void operationComplete(ChannelFuture channelFuture) throws Exception {
	                if (channelFuture.isSuccess()){
	                    System.out.println("complete");
	                    channelFuture.channel().close();
	                } else {
	                    channelFuture.cause().printStackTrace();
	                    channelFuture.channel().close();
	                }
	            }
	        });

	    }

}
