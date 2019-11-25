package com.yjjk.erp.entity.Info;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManangerUserModel {
	
	/**
	 * 管理员id
	 */
	private Integer managerId;
	
	/**
	 * 管理员手机
	 */
	private String phone;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 等级
	 */
	private Integer gender;
	
}
