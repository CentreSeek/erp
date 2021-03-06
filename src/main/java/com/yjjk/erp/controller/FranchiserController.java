package com.yjjk.erp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.Info.CompanyRelation;
import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.FranAccountModel;
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.Info.ListData;
import com.yjjk.erp.entity.Info.ManagePassword;
import com.yjjk.erp.entity.wx.WechatModel;
import com.yjjk.erp.utility.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @program: YjjkErp
 * @description: 经销商模块
 * @author: CentreS
 * @create: 2019-11-25 19:19:11
 **/
@Api(tags = "经销商模块")
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
	public CommonResult getOpenID(@ApiParam(value = "微信code") @RequestParam(value = "code") String code) {
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
	public CommonResult FranBindingCom(@Valid CompanyRelation userModel) {
		try {
			franchiserService.FranBindingCom(userModel);

			return ResultUtil.returnSuccess("");

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
	public CommonResult XCXLogin(@Valid FranAccountModel franAccountModel) {
		try {
			return franchiserService.XCXLogin(franAccountModel);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 检查该用户是否登陆过登录
	 * 
	 * @return
	 */
	@ApiOperation("检查该用户是否登陆过登录")
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public CommonResult checkLogin(@ApiParam(value = "微信openid") @RequestParam(value = "openId") String openId) {
		try {
			return franchiserService.checkLogin(openId);

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
	@RequestMapping(value = "/getfranchiserInfo", method = RequestMethod.POST)
	public CommonResult getfranchiserInfo(@ApiParam(value = "经销商id") @RequestParam(value = "id") Integer id) {
		try {
			return franchiserService.getfranchiserInfo(id);

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
	public CommonResult getFranList(@Valid CurrencyModel userModel) {
		try {
			ListData listData = franchiserService.getFranList(userModel);
			return ResultUtil.returnSuccess(listData);
		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 经销商停用
	 * 
	 * @return
	 */
	@ApiOperation("经销商停用")
	@RequestMapping(value = "/updateFran", method = RequestMethod.GET)
	public CommonResult updateFran(@ApiParam(value = "经销商id") @RequestParam(value = "id") Integer id) {
		try {
			franchiserService.updateFran(id);
			return ResultUtil.returnSuccess("");
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
	public CommonResult XCXLoginOut(@ApiParam(value = "微信openid") @RequestParam(value = "openId") String openId) {
		try {
			boolean isTrue = franchiserService.XCXLoginOut(openId);
			if (isTrue) {
				return ResultUtil.returnSuccess("", "退出成功");
			} else {
				return ResultUtil.returnError("300", "退出失败");
			}
		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 获取与经销商无关的公司列表
	 * 
	 * @return
	 */
	@ApiOperation("获取与经销商无关的公司列表")
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.POST)
	public CommonResult getCompanyList(@RequestParam(value = "id") Integer id) {
		try {
			List<ContractInfo> companys = franchiserService.getCompanyList(id);
			return ResultUtil.returnSuccess(companys);
		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 确认手机号是否存在
	 * 
	 * @return
	 */
	@ApiOperation("确认手机号是否存在")
	@RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
	public CommonResult checkPhone(@RequestParam(value = "phone") String phone) {
		try {
			boolean istrue = franchiserService.checkPhone(phone);
			if (istrue) {
				return ResultUtil.returnSuccess("");
			} else {
				return ResultUtil.returnError("300", "已存在");
			}

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 小程序修改密码
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("小程序修改密码")
	@RequestMapping(value = "/ChangeFranPassWord", method = RequestMethod.POST)
	public CommonResult ChangeFranPassWord(@Valid ManagePassword managePassword) {
		try {
			return franchiserService.ChangeFranPassWord(managePassword);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
}
