package com.doe.afs.controller.house;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doe.afs.controller.core.BaseController;
import com.doe.afs.controller.core.DataGridInfo;
import com.doe.afs.controller.core.ResponseMsg;
import com.doe.afs.service.house.HouseService;
import com.doe.afs.vo.house.House;
import com.doe.afs.vo.house.MonthRent;

/**
 * 房屋信息接口
 * @author Coder
 */
@Validated
@RestController
@RequestMapping("/house")
public class HouseController extends BaseController{
	
	@Autowired
    private HouseService houseService;
	
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<House> add(@RequestBody House h,  HttpServletRequest request) {
        try{
            return responseSucc("新增成功", houseService.add(h));
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("新增失败",null);
        }
    }
	
	@RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<House> update(@RequestBody House h,  HttpServletRequest request) {
        try{
            return responseSucc("更新成功", houseService.update(h));
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("更新失败",null);
        }
    }
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<Integer> delete(String uid,  HttpServletRequest request) {
        try{
            return responseSucc("删除成功", houseService.delete(uid));
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("删除失败",0);
        }
    }
	
	@RequestMapping(value="/pagelist", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<DataGridInfo<House>> pagelist(String pageIndex, String pageSize,String houseName,  HttpServletRequest request) {
        try{
            int curPage = getCurPage(pageIndex);
            int pageSizes = getPageSize(pageSize);
            return responseSucc("查询房屋信息列表成功", houseService.queryList(curPage, pageSizes,houseName));
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("查询失败",null);
        }
    }
	
	@RequestMapping(value="/monthrent/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<List<MonthRent>> queryMonthRent(String houseId, HttpServletRequest request) {
        try{
            return responseSucc("查询房租信息列表成功", houseService.queryMonthRent(houseId));
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("失败",null);
        }
    }
	
}
