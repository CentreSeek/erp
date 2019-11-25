package com.yjjk.erp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.utils.StringUtils;
import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.wx.WechatModel;
import com.yjjk.erp.utility.ResultUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @program: YjjkErp
 * @description: 经销商模块
 * @author: CentreS
 * @create: 2019-11-25 19:19:11
 **/
@RestController
@RequestMapping("/Franchiser")
public class FranchiserController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FranchiserController.class);

	/**
	 * 获取微信唯一code
	 * 
	 * @param code
	 * @return
	 */
	@ApiOperation("获取微信唯一code")
	@RequestMapping(value = "/getopenid", method = RequestMethod.GET)
	public CommonResult getOpenID(@RequestParam(value = "code") String code) {
		try {
			WechatModel wechatModel = franchiserService.getOpenID(code);
			if (wechatModel.getErrcode() != null) {
				return ResultUtil.returnError("300", wechatModel.getErrmsg());
			} else {
				return ResultUtil.returnSuccess(wechatModel.getOpenid());
			}

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
		}

	}

	/**
	 * 经销商账户绑定公司
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("经销商账户绑定公司")
	@RequestMapping(value = "/FranBindingCom", method = RequestMethod.POST)
	public CommonResult FranBindingCom(@Valid FranchiserUserModel userModel) {
		try {
			String phone = franchiserService.FranBindingCom(userModel);

			return ResultUtil.returnSuccess(phone);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 小程序登录
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("小程序登录")
	@RequestMapping(value = "/XCXLogin", method = RequestMethod.POST)
	public CommonResult XCXLogin(@Valid FranchiserUserModel userModel) {
		try {
			return franchiserService.XCXLogin(userModel);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 获取经销商个人信息
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("获取经销商个人信息")
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
	public CommonResult getUserInfo(@Valid FranchiserUserModel userModel) {
		try {
			return franchiserService.getUserInfo(userModel.getFranchiserId());

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 新增经销商
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("新增经销商")
	@RequestMapping(value = "/addFran", method = RequestMethod.POST)
	public CommonResult addFran(@Valid FranchiserUserModel userModel) {
		try {
			return franchiserService.addFran(userModel);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 获取经销商列表
	 * 
	 * @return
	 */
	@ApiOperation("获取经销商列表")
	@RequestMapping(value = "/getFranList", method = RequestMethod.GET)
	public CommonResult getFranList() {
		try {
			List<FranchiserUserModel> userList = franchiserService.getFranList();
			return ResultUtil.returnSuccess(userList);
		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 小程序退出登录
	 * 
	 * @return
	 */
	@ApiOperation("小程序退出登录")
	@RequestMapping(value = "/XCXLoginOut", method = RequestMethod.POST)
	public CommonResult XCXLoginOut(@Valid FranchiserUserModel userModel) {
		try {
			boolean isTrue = franchiserService.XCXLoginOut(userModel);
			return ResultUtil.returnSuccess("", "退出成功");
		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

}
