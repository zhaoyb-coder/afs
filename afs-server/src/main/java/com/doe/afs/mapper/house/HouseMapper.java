package com.doe.afs.mapper.house;

import java.util.List;

import com.doe.afs.mapper.base.BaseMapper;
import com.doe.afs.vo.house.House;
import com.doe.afs.vo.house.MonthRent;

public interface HouseMapper extends BaseMapper<House> {
	
	/**
	 * 查询月租信息
	 * @param param
	 * @return
	 */
	public List<MonthRent> queryMonthRent(Object param);
}


