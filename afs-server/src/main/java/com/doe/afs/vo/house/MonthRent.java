package com.doe.afs.vo.house;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 月租信息
 * @author Coder
 *
 */
public class MonthRent implements Serializable{
	private static final long serialVersionUID = -4835734824766177585L;
	
	private String uid;
	private String houseId;
	private String month;
	private String isPay;
	private int houseRent;
	private int waterRent;
	private int electricity;
	private int network;
	private int garbage;
	private int other;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public int getHouseRent() {
		return houseRent;
	}
	public void setHouseRent(int houseRent) {
		this.houseRent = houseRent;
	}
	public int getWaterRent() {
		return waterRent;
	}
	public void setWaterRent(int waterRent) {
		this.waterRent = waterRent;
	}
	public int getElectricity() {
		return electricity;
	}
	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	public int getNetwork() {
		return network;
	}
	public void setNetwork(int network) {
		this.network = network;
	}
	public int getGarbage() {
		return garbage;
	}
	public void setGarbage(int garbage) {
		this.garbage = garbage;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
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
	
}
