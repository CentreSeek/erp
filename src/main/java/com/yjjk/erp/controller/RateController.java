package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.vo.RatesInfoVO;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 备案进度管理模块
 * @author: CentreS
 * @create: 2019-11-25 19:24:41
 **/
@RestController
@Api(tags = "备案进度管理模块")
@RequestMapping("rate")
public class RateController extends BaseController {

    @ApiOperation("备案详情记录")
    @RequestMapping(value = "/rates", method = RequestMethod.GET)
    public CommonResult<List<RatesInfoVO>> getHospitalInfo(@ApiParam(value = "医院id") @RequestParam("hospitalId") Integer hospitalId) {
        try {
            List<RatesInfoVO> rateInfoList = super.rateService.getRateInfoList(hospitalId);
            return ResultUtil.returnSuccess(rateInfoList);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
