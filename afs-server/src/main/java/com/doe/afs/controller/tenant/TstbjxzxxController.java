package com.doe.afs.controller.tenant;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.doe.afs.controller.core.BaseController;
import com.doe.afs.controller.core.DataGridInfo;
import com.doe.afs.controller.core.ResponseMsg;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Coder
 * @create 2021-01-05 14:47
 */
@Validated
@RestController
@RequestMapping("/tenant")
public class TstbjxzxxController extends BaseController{

 
    @RequestMapping(value="/pagelist", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<String> pagelist(String pageIndex, String pageSize,  HttpServletRequest request) {
        try{
//            int curPage = getCurPage(pageIndex);
//            int pageSizes = getPageSize(pageSize);
            return responseSucc("查询套损套变井现状信息取消审核列表成功", null);
        }catch(Exception e){
            e.printStackTrace();
            return responseFailer("失败",null);
        }
    }
    
    @RequestMapping(value="/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String pagelist(String test,  HttpServletRequest request) {
        try{
            return "success---"+test;
        }catch(Exception e){
        	return "error";
        }
    }
   
}
