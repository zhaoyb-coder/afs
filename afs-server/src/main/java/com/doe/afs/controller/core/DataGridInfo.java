package com.doe.afs.controller.core;

import java.io.Serializable;
import java.util.List;

/**
 * 
* @ClassName: DataGridInfo
* @Description: vue前端需要的表格数据格式
* @author Coder 
* @version V1.0
 */
public class DataGridInfo<T> implements Serializable{
	private static final long serialVersionUID = -4835734824766177585L;
	private long total;
	private int pageIndex;
	private List<T> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public DataGridInfo() {}
	
	public DataGridInfo(long total, int pageIndex, List<T> rows) {
		this.total = total;
		this.pageIndex = pageIndex;
		this.rows = rows;
	}
	
}

