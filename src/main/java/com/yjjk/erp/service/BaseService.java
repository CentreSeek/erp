/**
 * Copyright (C), 2019, 义金(杭州)健康科技有限公司
 * FileName: BaseService
 * Author:   CentreS
 * Date:     2019-06-20 16:34
 * Description: base service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yjjk.erp.service;


import com.github.pagehelper.PageInfo;
import com.yjjk.erp.entity.vo.PagedGridResult;
import com.yjjk.erp.mapper.ErpCompanyInfoMapper;
import com.yjjk.erp.mapper.ErpContractInfoMapper;
import com.yjjk.erp.mapper.ErpFranchiserInfoMapper;
import com.yjjk.erp.mapper.ErpHospitalInfoMapper;
import com.yjjk.erp.mapper.ErpManagerInfoMapper;
import com.yjjk.erp.mapper.ErpRateInfoMapper;
import com.yjjk.erp.mapper.ErpRecordInfoMapper;
import com.yjjk.erp.mapper.ErpRelationCompanyHospitalMapper;
import com.yjjk.erp.mapper.ErpRelationFranchiserCompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author CentreS
 * @Description: base service
 * @create 2019-06-20
 */
public class BaseService {
    protected static Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected ErpCompanyInfoMapper erpCompanyInfoMapper;
    @Autowired
    protected ErpContractInfoMapper erpContractInfoMapper;
    @Autowired
    protected  ErpFranchiserInfoMapper erpFranchiserInfoMapper;
    @Autowired
    protected ErpHospitalInfoMapper erpHospitalInfoMapper;
    @Autowired
    protected  ErpManagerInfoMapper erpManagerInfoMapper;
    @Autowired
    protected  ErpRateInfoMapper erpRateInfoMapper;
    @Autowired
    protected  ErpRecordInfoMapper erpRecordInfoMapper;
    @Autowired
    protected  ErpRelationCompanyHospitalMapper erpRelationCompanyHospitalMapper;
    @Autowired
    protected  ErpRelationFranchiserCompanyMapper erpRelationFranchiserCompanyMapper;

    protected PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
