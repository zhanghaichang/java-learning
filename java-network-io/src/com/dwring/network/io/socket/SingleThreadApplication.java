package com.dwring.network.io.socket;

import com.dwring.network.io.socket.SocketHttpClient;

/**   
* @Title: SingleThreadApplication.java 
* @Package com.qf.interview 
* @Description: TODO
* @author haichangzhang   
* @date 2018年4月23日 下午2:14:23 
* @version V1.0   
*/
public class SingleThreadApplication {
	
    public static void main(String[] args) {

		// HttpConstant.HOSTS 为 站点集合
        for (String host: HttpConstant.HOSTS) {

            new SocketHttpClient().start(host, HttpConstant.PORT);

        }

    }
}
