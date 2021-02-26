package com.doe.afs.service.house;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doe.afs.controller.core.DataGridInfo;
import com.doe.afs.helper.WebAppHelper;
import com.doe.afs.mapper.house.HouseMapper;
import com.doe.afs.service.base.BaseService;
import com.doe.afs.vo.house.House;
import com.doe.afs.vo.house.MonthRent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Coder
 */
@Service("houseService")
public class HouseService extends BaseService{
	
	@Autowired
    private HouseMapper houseMapper;
	
	/**
	 * 新增
	 * @param h
	 * @return
	 */
	public House add(House h) {
		h.setUid(WebAppHelper.newEventId());
		h.setCreateTime(new Date());
		h.setHouseStat("空置");
		h.setHouseNum(0);
		h.setDataState("1");
		houseMapper.insert(h);
		return h;
	}
	
	/**
	 * 更新
	 * @param h
	 * @return
	 */
	public House update(House h) {
		h.setUpdateTime(new Date());
		houseMapper.update(h);
		return h;
	}
	
	/**
	 * 删除
	 * @param h
	 * @return
	 */
	public int delete(String uids) {
		String[] _uid = uids.split(",");
		for(String uid : _uid) {
			houseMapper.delete(uid);
		}
		return 1;
	}
	
	/**
	 * 查询房屋列表信息
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public DataGridInfo<House> queryList(int curPage,int pageSize, String houseName){
		Map<String, Object> sqlParam = new HashMap<String,Object>();
        sqlParam.put("houseName", "%"+houseName+"%");
		// 开始查询、分页
        PageInfo<House> pageInfo = PageHelper.startPage(curPage, pageSize)
                .doSelectPageInfo(()-> houseMapper.queryList(sqlParam));
        List<House> list = pageInfo.getList();
        return getDataGridInfo(pageInfo.getTotal(),curPage,list);
	}
	/**
	 * 查询月租缴费信息
	 * @param houseId
	 * @return
	 */
	public List<MonthRent> queryMonthRent(String houseId) {
		return houseMapper.queryMonthRent(houseId);
	}

}
