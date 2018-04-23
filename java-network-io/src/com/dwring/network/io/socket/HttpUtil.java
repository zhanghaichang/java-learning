package com.dwring.network.io.socket;

/**   
* @Title: HttpUtil.java 
* @Package com.qf.interview 
* @Description: TODO
* @author haichangzhang   
* @date 2018年4月23日 下午2:12:23 
* @version V1.0   
*/
public class HttpUtil {
    public static String compositeRequest(String host){

        return "GET / HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "User-Agent: curl/7.43.0\r\n" +
                "Accept: */*\r\n\r\n";
    }
    
}
