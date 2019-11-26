package com.yjjk.erp.entity.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "erp_contract_info")
@Accessors(chain = true)
public class ErpContractInfo {
    /**
     * 主键
     */
    @Id
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
     * 协议编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 签约姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 合作范围 0：备案 1：区域 2：省级 3：市级
     */
    @Column(name = "cooperation_scope")
    private String cooperationScope;

    @Column(name = "manager_id")
    private Integer managerId;

    /**
     * 协议状态 0：有效 1：已终止 2：已失效
     */
    @Column(name = "contract_type")
    private Integer contractType;

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
     * 获取协议编号
     *
     * @return order_num - 协议编号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置协议编号
     *
     * @param orderNum 协议编号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取签约姓名
     *
     * @return user_name - 签约姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置签约姓名
     *
     * @param userName 签约姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取开始日期
     *
     * @return start_date - 开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始日期
     *
     * @param startDate 开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束日期
     *
     * @return end_date - 结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期
     *
     * @param endDate 结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取合作范围 0：备案 1：区域 2：省级 3：市级
     *
     * @return cooperation_scope - 合作范围 0：备案 1：区域 2：省级 3：市级
     */
    public String getCooperationScope() {
        return cooperationScope;
    }

    /**
     * 设置合作范围 0：备案 1：区域 2：省级 3：市级
     *
     * @param cooperationScope 合作范围 0：备案 1：区域 2：省级 3：市级
     */
    public void setCooperationScope(String cooperationScope) {
        this.cooperationScope = cooperationScope;
    }

    /**
     * @return manager_id
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取协议状态 0：有效 1：已终止 2：已失效
     *
     * @return contract_type - 协议状态 0：有效 1：已终止 2：已失效
     */
    public Integer getContractType() {
        return contractType;
    }

    /**
     * 设置协议状态 0：有效 1：已终止 2：已失效
     *
     * @param contractType 协议状态 0：有效 1：已终止 2：已失效
     */
    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }
}