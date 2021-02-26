package com.doe.afs.helper;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

/**
 * @ClassName: WebAppHelper
 * @Description: 项目帮助类
 * @author Coder
 * @version V1.0
 */
public class WebAppHelper {
	/**
	 * 获取新的eventid
	 * @return
	 */
	public static String newEventId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 	获取用户ip
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {  
		String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        } 
        if(!StringUtils.isEmpty(ip)) {
			return ip.split(",")[0];
		}
        return ip;  
    }  
}