package com.yjjk.erp.service;

import com.yjjk.erp.entity.bo.AddRateBO;
import com.yjjk.erp.entity.vo.MyRateVO;
import com.yjjk.erp.entity.vo.RatesInfoVO;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 备案进度
 * @author: CentreS
 * @create: 2019-11-25 19:45:31
 **/
public interface RateService {

    /**
     * 获取进度记录列表
     * @param hospitalId
     * @return
     */
    List<RatesInfoVO> getRateInfoList(Integer hospitalId, Integer companyId);

    /**
     * 新增进度
     * @param addRateBO
     * @return
     */
    int addRate(AddRateBO addRateBO);

    /**
     * 公司名下医院进度详情
     * @param companyId
     * @return
     */
    List<MyRateVO> getMyRate(Integer companyId);
}
