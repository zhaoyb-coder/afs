package com.doe.afs.controller.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
	
	public Log log = LogFactory.getLog(getClass());
	
	/**
	 * 获取当前页
	 * @return
	 */
	public int getCurPage(String page){
		return Integer.parseInt((page == null || "0".equals(page)) ? "1":page);//当前页 
	}
	/**
	 * 获取每页大小
	 * @return
	 */
	public int getPageSize(String rows){
		return Integer.parseInt((rows == null || "0".equals(rows)) ? "30":rows);//每页显示条数  
	}
	
	/**
	 * 返回成功的标识
	 * @param flag
	 * @return
	 */
	public <T> ResponseMsg<T> responseSucc(String msg, T result) {
		return new ResponseMsg<T>(HttpStatus.OK, true, msg, result);
	}
	/**
	 * 返回成功的标识
	 * @param flag
	 * @return
	 */
	public <T> ResponseMsg<T> responseSucc(T result) {
		return new ResponseMsg<T>(HttpStatus.OK, true, result);
	}
	
	/**
	 * 	返回系统错误的标识
	 * @param flag
	 * @return
	 */
	public <T> ResponseMsg<T> responseFailer(String msg, T result) {
		return new ResponseMsg<T>(HttpStatus.ERROR, false, msg, result);
	}
	
	/**
	 * 	返回系统错误的标识
	 * @param flag
	 * @return
	 */
	public <T> ResponseMsg<T> responseFailer(T result) {
		return new ResponseMsg<T>(HttpStatus.ERROR, false, result);
	}
	 
}
