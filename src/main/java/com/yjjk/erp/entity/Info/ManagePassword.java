package com.yjjk.erp.entity.Info;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ManagePassword {
	/**
	 * 被修改管理员的id
	 */
	@NotNull
	@ApiParam(value = "被修改人员的id",required = true)
	private Integer userId;
	
	/**
	 * 密码
	 */
	@NotNull
	@ApiParam(value = "密码",required = true)
	private String passWord;
	
	/**
	 * 新密码
	 */
	@NotNull
	@ApiParam(value = "新密码",required = true)
	private String newPassWord;
	

}
