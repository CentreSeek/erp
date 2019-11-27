package com.yjjk.erp.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.ManangerUserModel;
import com.yjjk.erp.entity.Info.YjLoginState;

@Component
public interface ManagerDao {

	/**
	 * 获取管理员列表
	 * 
	 * @param userModel
	 * @return
	 */
	List<ManangerUserModel> managerList(@Param(value = "userModel") CurrencyModel userModel);

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	List<ManangerUserModel> RoleList();
	
	/**
	 * 新增管理员
	 * 
	 * @param userModel
	 * @return
	 */
	void addManager(@Param(value = "userModel") ManangerUserModel userModel);
	
	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	void deleteManager(@Param(value = "id")Integer id);
	
	/**
	 * 编辑管理员
	 * 
	 * @param userModel
	 * @return
	 */
	void updateManager(@Param(value = "userModel") ManangerUserModel userModel);

	/**
	 * 获取管理员信息
	 * @param managerId
	 * @return
	 */
	ManangerUserModel getManagerData(@Param(value = "id") Integer managerId);

	/**
	 * 修改管理员密码
	 * @param userModel
	 */
	void ChangeManagerPassWord(@Param(value = "userModel") ManangerUserModel userModel);
	
	/**
	 * 获取管理员密码
	 * @param managerId
	 * @return
	 */
	Integer getManagerPassWord(@Param(value = "phone") String phone);
	
	/**
	 * 确认Token是否存在
	 * 
	 * @param account
	 * @return
	 */
	String checkToken(@Param(value = "token") String token,@Param(value = "ip") String remoteAddr);

	/**
	 * 获取token信息
	 * 
	 * @param account
	 * @return
	 */
	YjLoginState getTokeInfo(@Param(value = "managerId") Integer managerId);

	/**
	 * 更新token信息
	 * 
	 * @param account
	 * @return
	 */
	void updateTokenInfo(@Param(value = "yj") YjLoginState yj);

	/**
	 * 新增token信息
	 * 
	 * @param account
	 * @return
	 */
	void addTokenInfo(@Param(value = "yj") YjLoginState loginState);
	
	/**
	 * 获取管理总数
	 * 
	 * @return
	 */
	Integer getmanagerNum();

}
