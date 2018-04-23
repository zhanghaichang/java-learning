package com.dwring.network.io.netty;

import java.net.InetSocketAddress;
import com.dwring.network.io.socket.HttpUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Title: HttpClientHandler.java
 * @Package com.dwring.network.io.netty
 * @Description: TODO
 * @author haichangzhang
 * @date 2018年4月23日 下午4:12:20
 * @version V1.0
 */
public class HttpClientHandler extends SimpleChannelInboundHandler<Object> {

	private StringBuilder sb = new StringBuilder();

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
		ByteBuf in = (ByteBuf) o;
		while (in.isReadable()) {
			sb.append((char) in.readByte());
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		InetSocketAddress remote = (InetSocketAddress) ctx.channel().remoteAddress();
		String request = HttpUtil.compositeRequest(remote.getHostName());
		System.out.println(request);
		ctx.writeAndFlush(Unpooled.copiedBuffer(request, CharsetUtil.UTF_8));
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println(sb.toString());
		ctx.channel().close();
		ctx.close();
	}

}
