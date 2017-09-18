package com.dwring.springboot.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(NetworkUtils.class);

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		logger.info("============= x-forwarded-for ip:{}", ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			logger.info("=============Proxy-Client-IP ip:{}", ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			logger.info("============= WL-Proxy-Client-IP ip:{}", ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-real-ip");
			logger.info("=============x-real-ip ip:{}", ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			logger.info("============= unknown ip:{}", ip);
		}

		return ip;
	}

	/*
	 * getHeaderNames():返回一个枚举这个请求包含所有的头名。
	 */
	public static void getHeaderNames(HttpServletRequest request,
			HttpServletResponse response) {
		Enumeration<String> enums = request.getHeaderNames();
		String str = null;
		while (enums.hasMoreElements()) {
			str = enums.nextElement().toString();
			logger.info(str + ":");
			logger.info(request.getHeader(str));
			if (str != null) {
				response.setHeader(str, request.getHeader(str));
			}
			Enumeration<String> a = request.getHeaders(str);
			while (a.hasMoreElements()) {
				logger.info("******head=" + a.nextElement() + "************");
			}
		}
	}

}
