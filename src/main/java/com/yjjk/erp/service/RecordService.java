package com.yjjk.erp.service;

import com.yjjk.erp.constant.RecordEnum;
import com.yjjk.erp.entity.bo.PageBO;
import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.vo.PagedGridResult;

import java.util.Map;

/**
 * @program: YjjkErp
 * @description: 备案
 * @author: CentreS
 * @create: 2019-11-25 19:45:53
 **/
public interface RecordService {


    /**
     * 获取备案信息列表
     * @param pageBO
     * @return
     */
    PagedGridResult getRecordsInfo(PageBO pageBO);

    /**
     * 查询审核信息
     *
     * @param recordId
     * @return
     */
    ErpRecordInfo getRecordInfo(Integer recordId);

    /**
     * 修改record状态
     *
     * @param recordId
     * @param checkStatus
     * @return
     */
    int checkRecord(Integer recordId, RecordEnum checkStatus);

    /**
     * 审核时间延期
     *
     * @param recordInfo
     * @param calendarConstant
     * @param times
     * @return
     */
    int postpone(ErpRecordInfo recordInfo, int calendarConstant, int times);

    /**
     * 新增备案
     *
     * @param hospitalId
     * @param companyId
     * @return
     */
    int addRecord(Integer hospitalId, Integer companyId, Integer franchiserId);

    /**
     * 获取已备案医院数量
     * @param map
     * @return
     */
    int getRecordCount(Map<String,Object> map);
}
