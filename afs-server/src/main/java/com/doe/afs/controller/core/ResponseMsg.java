package com.doe.afs.controller.core;

/**
 * @ClassName: ResponseMsg
 * @Description: 返回前端的消息类
 * @author Coder 
 * @version V1.0
 */
public class ResponseMsg<T> {
	private int code;  //状态,200,400,500
	private boolean success; //success,failer
	private String message;  //返回前端提示信息
	private T result;  //前端结果数据
	private long timestamp;  //数据返回的时间戳
	
	
	
	/**
	 * 返回前端信息
	 * @param code,code码
	 * @param success,true,false
	 * @param msg,返回前端提示信息
	 * @param result,前端结果数据
	 */
	public ResponseMsg(HttpStatus code, boolean success, String msg, T result) {
		this(code.getValue(), success, msg, result, System.currentTimeMillis());  //BaseStaticData.YMDHMS_FORMAT.format(new Date())
	}
	
	/**
	 *      返回前端信息
	 * @param code,code码
	 * @param success,true,false
	 * @param result,前端结果数据
	 */
	public ResponseMsg(HttpStatus code, boolean success, T result) {
		this(code.getValue(), success, code.getMsg(), result, System.currentTimeMillis());
	}

	/**
	 *      返回前端信息
	 * @param code,code码
	 * @param status,success,failer
	 * @param msg,返回前端提示信息
	 * @param result,前端结果数据
	 * @param time,时间戳
	 */
	public ResponseMsg(int code, boolean success, String msg, T result, long time) {
		this.code = code;
		this.success = success;
		this.message = msg;
		this.result = result;
		this.timestamp = time;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
