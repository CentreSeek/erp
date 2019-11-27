package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.constant.RateEnum;
import com.yjjk.erp.constant.RecordEnum;
import com.yjjk.erp.entity.bo.AddRateBO;
import com.yjjk.erp.entity.bo.HospitalsInfoBO;
import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.vo.MyHospitalsVO;
import com.yjjk.erp.entity.vo.RecordsInfoVO;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

/**
 * @program: YjjkErp
 * @description: 备案管理模块
 * @author: CentreS
 * @create: 2019-11-25 19:21:54
 **/
@RestController
@Api(tags = "备案管理模块")
@RequestMapping("record")
public class RecordController extends BaseController {

    @ApiOperation("查询备案信息列表")
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public CommonResult<List<RecordsInfoVO>> gerRecordsInfo(HospitalsInfoBO hospitalsInfoBO) {
        try {
            List<RecordsInfoVO> recordsInfo = super.recordService.getRecordsInfo();
            return ResultUtil.returnSuccess(recordsInfo);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @ApiOperation("通过审核")
    @RequestMapping(value = "/passRecord", method = RequestMethod.PUT)
    public CommonResult passRecord(@RequestParam(value = "recordId") Integer recordId) {
        try {
            ErpRecordInfo recordInfo = super.recordService.getRecordInfo(recordId);
            if (recordInfo == null) {
                return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
            }
            int j = super.rateService.addRate(new AddRateBO().setHospitalId(recordInfo.getHospitalId()));
            int i = super.recordService.checkRecord(recordId, RecordEnum.CHECK_STATUS_PASS);
            return ResultUtil.returnSuccess(i);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("不通过审核")
    @RequestMapping(value = "/noPassRecord", method = RequestMethod.PUT)
    public CommonResult noPassRecord(@RequestParam(value = "recordId") Integer recordId) {
        try {
            ErpRecordInfo recordInfo = super.recordService.getRecordInfo(recordId);
            if (recordInfo == null) {
                return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
            }
            int i = super.recordService.checkRecord(recordId, RecordEnum.CHECK_STATUS_NO_PASS);
            return ResultUtil.returnSuccess(i);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("延期30天")
    @RequestMapping(value = "/postpone", method = RequestMethod.PUT)
    public CommonResult postpone(@RequestParam(value = "recordId") Integer recordId) {
        try {
            ErpRecordInfo recordInfo = super.recordService.getRecordInfo(recordId);
            if (recordInfo == null) {
                return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
            }
            int i = super.recordService.postpone(recordInfo, Calendar.MONTH, 1);
            return ResultUtil.returnSuccess(null);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("新增备案")
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public CommonResult addRecord(@RequestParam(value = "hospitalIds") List<Integer> hospitalIds,
                                  @RequestParam(value = "companyId") Integer companyId) {
        try {
            int count = 0;
            for (Integer hospitalId : hospitalIds) {
//                int relation = super.companyService.getRelation(companyId, hospitalId);
//                if (relation == 0){
//                    return ResultUtil.returnError(ErrorCodeEnum.NON_COLLABORATE);
//                }
                count += super.recordService.addRecord(hospitalId, companyId);
            }
            return ResultUtil.returnSuccess(count);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("获取医院信息")
    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public CommonResult<List<MyHospitalsVO>> getMyHospitals(@RequestParam(value = "companyId") Integer companyId) {
        try {
            List<MyHospitalsVO> myHospital = super.hospitalService.getMyHospital(companyId);
            return ResultUtil.returnSuccess(myHospital);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("返回进度枚举")
    @RequestMapping(value = "/rateType", method = RequestMethod.GET)
    public CommonResult getRateType() {
        try {
            return ResultUtil.returnSuccess(RateEnum.getJson());
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

}
