package com.doe.afs.interceptor;

import javax.servlet.http.HttpServletRequest;

/**
* @Description
* @author zhaoyubo
* @date 2020-07-29 11:04:44 
*/
public class AuthPage {
	//无需验证登录的页面
	private static String[] excludePath = new String[] {
			 "/login"
	};
	
	/**
	 * 无需验证登录
	 * @return
	 */
	public static boolean noNeedAuth(HttpServletRequest request) {
		String uri = request.getRequestURI().toLowerCase();
		for(String page : excludePath) {
			if(uri.contains(page.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
