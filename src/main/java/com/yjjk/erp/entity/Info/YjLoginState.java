package com.yjjk.erp.entity.Info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YjLoginState {

	/**
	 * Token
	 */
	private String token;

	/**
	 * 访问ip
	 */
	private String ip;

	/**
	 * 管理员id
	 */
	private Integer managerId;

	/**
	 * 登出时间
	 */
	private String loginOutTime;

	/**
	 * 0：登入 1：登出
	 */
	private Integer status;

	private Integer userType;

}
