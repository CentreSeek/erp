package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpCompanyInfo;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpCompanyInfoMapper extends MyMapper<ErpCompanyInfo> {

    /**
     * 新增医院备案公司列表
     * @return
     */
    List<ListVO> getList(Integer franchiserId);
}