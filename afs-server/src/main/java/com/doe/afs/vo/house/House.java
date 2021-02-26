package com.doe.afs.vo.house;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋信息
 * @author Coder
 */
public class House implements Serializable{
	private static final long serialVersionUID = -4835734824766177585L;
	
	private String uid;
	private String houseName;
	private int houseNum;
	private String houseStat;
	private Date createTime;
	private Date updateTime;
	private String isPay;
	private String dataState;
	
	public String getDataState() {
		return dataState;
	}
	public void setDataState(String dataState) {
		this.dataState = dataState;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public String getHouseStat() {
		return houseStat;
	}
	public void setHouseStat(String houseStat) {
		this.houseStat = houseStat;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
}
