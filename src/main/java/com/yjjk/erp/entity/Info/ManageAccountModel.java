package com.yjjk.erp.entity.Info;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ManageAccountModel {
	
	/**
	 * 手机号
	 */
	@NotNull
	@ApiParam(value = "手机号",required = true)
	private String phone;
	
	/**
	 * 密码
	 */
	@NotNull
	@ApiParam(value = "密码",required = true)
	private String password;
	
	

}
