package com.yjjk.erp.entity.Info;

import java.util.List;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManangerUserModel {
	
	/**
	 * 管理员id
	 */
	@ApiParam(value = "管理员id")
	private Integer managerId;
	
	/**
	 * 管理员手机
	 */
	@NotNull
	@ApiParam(value = "管理员手机",required = true)
	private String phone;
	
	/**
	 * 密码
	 */
	@ApiParam(value = "密码")
	private String passWord;
	
	/**
	 * 姓名
	 */
	@NotNull
	@ApiParam(value = "姓名",required = true)
	private String name;
	
	/**
	 * 性别
	 */
	@NotNull
	@ApiParam(value = "性别",required = true)
	private Integer sex;
	
	/**
	 * 等级
	 */
	@NotNull
	@ApiParam(value = "等级",required = true)
	private Integer gender;
	
	/**
	 * 等级名称
	 */
	@ApiParam(value = "等级名称")
	private String genderName;
	
	/**
	 * 创建时间
	 */
	@NotNull
	@ApiParam(value = "创建时间")
	private String createTime;
	
	/**
	 * 修改时间
	 */
	@NotNull
	@ApiParam(value = "修改时间")
	private String updateTime;
	
	/**
	 * token
	 */
	@ApiParam(value = "token")
	private String token;
	
}
