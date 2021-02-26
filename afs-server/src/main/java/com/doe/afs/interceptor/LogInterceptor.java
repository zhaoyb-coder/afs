package com.doe.afs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.doe.afs.helper.WebAppHelper;

/**
 * 
* @ClassName: LogInterceptor
* @Description: 日志拦截器，记录每个方法请求的日志
* @author Coder
* @version V1.0
 */
@Component("logInterceptor")
public class LogInterceptor implements HandlerInterceptor {
	private static final Log log = LogFactory.getLog(LogInterceptor.class);
	private static final ThreadLocal<Long> threadLocalTime = new NamedThreadLocal<Long>("ThreadLocalTime");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long beginTime = System.currentTimeMillis();
		threadLocalTime.set(beginTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long beginTime = threadLocalTime.get();
		long endTime = System.currentTimeMillis();
		log.info(new BaseLogInfo(beginTime, (endTime - beginTime), request).getLogInfo());
	}

	class BaseLogInfo {
		private String user;
		private String ip; // 访问者ip
		private String url; // 访问的服务
//		private String params; //访问参数
//		private long visitTime; //访问时间
		private long processTime; // 系统处理时间

		public BaseLogInfo(long visitTime, long processTime, HttpServletRequest request) {
			this.url = request.getRequestURI();
			this.ip = WebAppHelper.getIpAddress(request);
			this.processTime = processTime;
			this.user = "admin";
		}

		public String getLogInfo() {
			return "ip为：" + ip + " 用户为：" + user + " 请求服务：" + url + " 耗费时间：" + format(processTime);
		}

		private String format(long time) {
			if (time / 1000 >= 1) {
				return (time / 1000) + " 秒";
			}
			return time + " 毫秒";
		}

	}
}
