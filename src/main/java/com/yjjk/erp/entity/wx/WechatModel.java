package com.yjjk.erp.entity.wx;

public class WechatModel {

	// 用户唯一标识
	public String openid;

	// 会话密钥
	public String session_key;

	// 用户在开放平台的唯一标识符
	public String unionid;

	// 错误编号
	public String errcode;

	// 错误内容
	public String errmsg;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
