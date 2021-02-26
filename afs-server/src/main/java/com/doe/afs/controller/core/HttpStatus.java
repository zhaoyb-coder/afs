package com.doe.afs.controller.core;

/**
* @ClassName: HttpStatus
* @Description: 返回http请求状态信息
* @author Coder 
* @version V1.0
 */
public enum HttpStatus {
	//200
	OK(200, "请求成功"),
	//400
	BADREQUEST(400, "请求无效"),
	UNAUTHORIZED(401, "未经授权访问"),
	NOTFOUND(404, "服务请求未找到"),
	
	NODATA_FOUND(404404, "数据未找到"),
	//500
	ERROR(500, "系统错误"),
	
	//
	UNIQUE_ERROR(500100, "数据唯一性错误,存在重复的数据"),
	VALIDATE_ERROR(500101, "参数校验错误"),
	TOKEN_ERROR(500102, "token错误"),
	NO_LOGIN_ERROR(500104, "用户未登陆"),
	LOGIN_ERROR(500105, "用户登陆失败"),
	NO_AUTH_ERROR(500106, "无权限访问"),
	LOGIN_USER_ERROR(500107, "用户名错误"),
	LOGIN_PWD_ERROR(500108, "用户密码错误"),
	USER_LOCK_ERROR(500109, "用户被锁定"),
	UKEY_ERROR(500110, "ukey错误"),
	PWD_NONSTANDARD(500111, "用户密码不合规范"),
	ACCOUNT_TYPE_ERROR(500112, "用户账号类型不匹配"),
	EMAIL_NONSTANDARD(500113, "邮箱格式错误！"),
	PHONE_NONSTANDARD(500114, "电话格式错误！"),
	DATA_NO_AUTH_ERROR(500115, "数据不在查询范围内"),
	//
	WORK_FLOW_SUBMIT_ERROR(500200, "流程提交错误"),
	WORK_FLOW_APPROVAL_ERROR(500201, "流程审核错误"),
	WORK_FLOW_REJECT_ERROR(500202, "流程退回错误"),
	WORK_FLOW_CANCEL_ERROR(500203, "流程取消错误"),
	WORK_FLOW_NO_EXIST(500204, "不存在流程历史记录"),
	//
	EMAIL_CONFIG_ERROR(500300, "邮箱未配置"),
	JST_CONFIG_ERROR(500301, "即时通未配置"),
	JST_ACCOUNT_ERROR(500302, "即时账号错误"),
	//
	DB_DEL_NODATA_ERROR(500401, "删除0条数据");
	private int value;
	private String msg;
	
	public int getValue() {
        return value;
    }
	public String getMsg() {
		return msg;
	}

	private HttpStatus(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}
	
}
