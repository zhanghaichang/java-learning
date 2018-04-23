package com.dwring.network.io.socket;

import com.dwring.network.io.socket.SocketHttpClient;

/**
 * @Title: MultiThreadApplication.java
 * @Package com.qf.interview
 * @Description: TODO
 * @author haichangzhang
 * @date 2018年4月23日 下午2:14:02
 * @version V1.0
 */
public class MultiThreadApplication {

	public static void main(String[] args) {

		for (final String host : HttpConstant.HOSTS) {

			Thread t = new Thread(new Runnable() {
				public void run() {
					new SocketHttpClient().start(host, HttpConstant.PORT);
				}
			});

			t.start();

		}
	}

}
