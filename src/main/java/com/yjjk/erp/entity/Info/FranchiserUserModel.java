package com.yjjk.erp.entity.Info;

import java.util.List;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiserUserModel {
	
	/**
	 * 经销商id
	 */
	@ApiParam(value = "经销商id")
	private Integer franchiserId;
	
	/**
	 * 
	 */
	@NotNull
	@ApiParam(value = "公司id列表")
	private List<Integer> comList;
	
	/**
	 * 姓名
	 */
	@NotNull
	@ApiParam(value = "姓名",required = true)
	private String name;
	
	/**
	 * 密码
	 */
	@NotNull
	@ApiParam(value = "密码",required = true)
	private String password;
	
	/**
	 * 手机号
	 */
	@NotNull
	@ApiParam(value = "手机号",required = true)
	private String phone;
	
	/**
	 * 微信用户openid
	 */
	@ApiParam(value = "微信用户openid")
	private String openId;
	
	/**
	 * 创建时间
	 */
	@ApiParam(value = "创建时间")
	private String createTime;
	
	/**
	 * 修改时间
	 */
	@ApiParam(value = "修改时间")
	private String updateTime;

}
