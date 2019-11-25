package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: YjjkErp
 * @description: 备案管理模块
 * @author: CentreS
 * @create: 2019-11-25 19:21:54
 **/
@Controller
public class RecordController extends BaseController {

    @ApiOperation("查询医院信息")
    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public CommonResult changeBed() {
        try {


        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
