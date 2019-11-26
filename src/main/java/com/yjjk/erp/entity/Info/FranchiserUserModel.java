package com.yjjk.erp.entity.Info;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiserUserModel {
	
	/**
	 * 经销商id
	 */
	private Integer franchiserId;
	
	/**
	 * 
	 */
	private List<Integer> comList;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 微信用户openid
	 */
	private String openId;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 修改时间
	 */
	private String updateTime;

}
