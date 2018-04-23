package com.dwring.network.io.socket;

import com.dwring.network.io.socket.SocketHttpClient;

/**
 * @Title: Application.java
 * @Package com.qf.interview
 * @Description: TODO
 * @author haichangzhang
 * @date 2018年4月23日 下午2:13:25
 * @version V1.0
 */
public class Application {

	public static void main(String[] args) {

		new SocketHttpClient().start("www.baidu.com", 80);

	}
}
