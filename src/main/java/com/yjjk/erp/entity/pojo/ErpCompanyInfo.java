package com.yjjk.erp.entity.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "erp_company_info")
@Accessors(chain = true)
public class ErpCompanyInfo {
    /**
     * 主键
     */
    @Column(name = "company_id")
    @Id
    private Integer companyId;

    private String name;

    /**
     * 合作状态 0：合作中 1：未合作
     */
    @Column(name = "contract_status")
    private Integer contractStatus;

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
     * 获取主键
     *
     * @return company_id - 主键
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置主键
     *
     * @param companyId 主键
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取合作状态 0：合作中 1：未合作
     *
     * @return contract_status - 合作状态 0：合作中 1：未合作
     */
    public Integer getContractStatus() {
        return contractStatus;
    }

    /**
     * 设置合作状态 0：合作中 1：未合作
     *
     * @param contractStatus 合作状态 0：合作中 1：未合作
     */
    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
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
}