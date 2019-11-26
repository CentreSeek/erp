package com.yjjk.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.FranchiserUserModel;

@Component
public interface FranchiserDao {
	
	/**
	 * 经销商账户绑定公司
	 * 
	 * @return
	 */
	void addRelation(@Param(value = "comId") Integer companyId,@Param(value = "franId") Integer franchiserId);
	
	/**
	 * 新增经销商
     * 
     * @param userModel
     * @return
	 */
	void addFran(@Param(value = "fran") FranchiserUserModel userModel);

	/**
	 * 获取经销商列表
	 * 
	 * @return
	 */
	List<FranchiserUserModel> getFranList(@Param(value = "userModel") CurrencyModel userModel);
	
	/**
	 * 经销商停用
	 * 
	 * @return
	 */
	void updateFran(@Param(value = "id") Integer id);

	/**
	 * 获取经销商密码
	 * 
	 * @return
	 */
	FranchiserUserModel checkUser(@Param(value = "phone") String phone);

	/**
	 * 获取登录记录里的id
	 * 
	 * @return
	 */
	Integer checkisLogin(@Param(value = "openId") String openId);

	/**
	 * 新增微信与经销商绑定关系
	 * 
	 * @return
	 */
	void addNewUserToOpenId(@Param(value = "fran") FranchiserUserModel userModel);

	/**
	 * 更新微信与经销商绑定关系
	 * 
	 * @return
	 */
	void updateUserToOpenId(@Param(value = "fran") FranchiserUserModel fran);

	/**
	 * 获取经销商个人信息
	 * 
	 * @return
	 */
	FranchiserUserModel getfranchiserInfo(@Param(value = "id")Integer franchiserId);

}
