package com.yjjk.erp.entity.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "erp_rate_info")
@Accessors(chain = true)
public class ErpRateInfo {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0：正常1：删除
     */
    private Integer status;

    /**
     * 商务代表
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 联系方式
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 医院id
     */
    @Column(name = "hospital_id")
    private Integer hospitalId;

    /**
     * 科室
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 进度类型 0：备案成功 1：方案提交 2：勘察设计 3：方案确定 4：院方审批 5：合同签订 6：付款成功
     */
    @Column(name = "rate_type")
    private Integer rateType;

    /**
     * 具体内容
     */
    private String content;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0：正常1：删除
     *
     * @return status - 0：正常1：删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：正常1：删除
     *
     * @param status 0：正常1：删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取商务代表
     *
     * @return user_name - 商务代表
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置商务代表
     *
     * @param userName 商务代表
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取联系方式
     *
     * @return user_phone - 联系方式
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置联系方式
     *
     * @param userPhone 联系方式
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取医院id
     *
     * @return hospital_id - 医院id
     */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /**
     * 设置医院id
     *
     * @param hospitalId 医院id
     */
    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * 获取科室
     *
     * @return department_name - 科室
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置科室
     *
     * @param departmentName 科室
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取进度类型 0：备案成功 1：方案提交 2：勘察设计 3：方案确定 4：院方审批 5：合同签订 6：付款成功
     *
     * @return rate_type - 进度类型 0：备案成功 1：方案提交 2：勘察设计 3：方案确定 4：院方审批 5：合同签订 6：付款成功
     */
    public Integer getRateType() {
        return rateType;
    }

    /**
     * 设置进度类型 0：备案成功 1：方案提交 2：勘察设计 3：方案确定 4：院方审批 5：合同签订 6：付款成功
     *
     * @param rateType 进度类型 0：备案成功 1：方案提交 2：勘察设计 3：方案确定 4：院方审批 5：合同签订 6：付款成功
     */
    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    /**
     * 获取具体内容
     *
     * @return content - 具体内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置具体内容
     *
     * @param content 具体内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}