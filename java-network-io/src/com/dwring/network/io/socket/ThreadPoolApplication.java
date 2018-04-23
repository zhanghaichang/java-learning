package com.dwring.network.io.socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dwring.network.io.socket.SocketHttpClient;

/**   
* @Title: ThreadPoolApplication.java 
* @Package com.qf.interview 
* @Description: TODO
* @author haichangzhang   
* @date 2018年4月23日 下午2:13:53 
* @version V1.0   
*/
public class ThreadPoolApplication {

	
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (final String host: HttpConstant.HOSTS) {

            Thread t = new Thread(new Runnable() {
                public void run() {
                    new SocketHttpClient().start(host, HttpConstant.PORT);
                }
            });

            executorService.submit(t);
            new SocketHttpClient().start(host, HttpConstant.PORT);

        }

    }
}
