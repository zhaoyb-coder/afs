package com.doe.afs.service.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.doe.afs.controller.core.DataGridInfo;

import java.util.List;

/**
 * @author Coder
 */
public class BaseService {

    public Log log = LogFactory.getLog(getClass());
    /**
     * 前端vue需要的数据格式
     * @param total
     * @param pageIndex
     * @param list
     * @return
     */
    public <T> DataGridInfo<T> getDataGridInfo(long total, int pageIndex, List<T> list) {
        return new DataGridInfo<T>(total, pageIndex, list);
    }
}
