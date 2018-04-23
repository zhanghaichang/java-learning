package com.dwring.network.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

import com.dwring.network.io.socket.HttpConstant;
import com.dwring.network.io.socket.HttpUtil;

/**
 * @Title: NioBlockingHttpClient.java
 * @Package com.dwring.network.io.nio
 * @Description: Nio
 * @author haichangzhang
 * @date 2018年4月23日 下午2:57:32
 * @version V1.0
 */
public class NioBlockingHttpClient {

	private SocketChannel socketChannel;

	private String host;

	public static void main(String[] args) throws IOException {
		for (String host : HttpConstant.HOSTS) {
			NioBlockingHttpClient client = new NioBlockingHttpClient(host, HttpConstant.PORT);
			client.request();
		}
	}

	public NioBlockingHttpClient(String host, int port) throws IOException {
		this.host = host;
		socketChannel = SocketChannel.open();
		socketChannel.socket().setSoTimeout(5000);
		SocketAddress remote = new InetSocketAddress(this.host, port);
		socketChannel.configureBlocking(true);
		this.socketChannel.connect(remote);
	}

	public void request() throws IOException {
		PrintWriter pw = getWriter(socketChannel.socket());
		BufferedReader br = getReader(socketChannel.socket());
		pw.write(HttpUtil.compositeRequest(host));
		pw.flush();
		String msg;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}

	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream out = socket.getOutputStream();
		return new PrintWriter(out);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream in = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(in));
	}

}
