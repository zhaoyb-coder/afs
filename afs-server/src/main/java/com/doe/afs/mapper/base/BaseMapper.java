package com.doe.afs.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
	//插入数据
	int insert(T t);
	//更新数据
	int update(T t);
	//维护列表
	List<T> queryList(Object param);
	//查询单数据
	T queryOne(Object param);
	//删除数据
	int delete(Object param);
}
