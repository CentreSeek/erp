package com.yjjk.erp.entity.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "erp_manager_info")
@Accessors(chain = true)
public class ErpManagerInfo {
    /**
     * 主键
     */
    @Id
    @Column(name = "manager_id")
    private Integer managerId;

    /**
     * phone
     */
    private String phone;

    /**
     * password
     */
    private String password;

    private String name;

    private Integer gender;

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
     * @return manager_id - 主键
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * 设置主键
     *
     * @param managerId 主键
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取phone
     *
     * @return phone - phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取password
     *
     * @return password - password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
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