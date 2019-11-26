package com.yjjk.erp.entity.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "erp_hospital_info")
@Accessors(chain = true)
public class ErpHospitalInfo {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 医院名称
     */
    private String name;

    /**
     * 状态 0：未备案 1：已备案 2：已合作 3：已失效
     */
    @Column(name = "rate_type")
    private Integer rateType;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

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
     * 获取医院名称
     *
     * @return name - 医院名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置医院名称
     *
     * @param name 医院名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态 0：未备案 1：已备案 2：已合作 3：已失效
     *
     * @return rate_type - 状态 0：未备案 1：已备案 2：已合作 3：已失效
     */
    public Integer getRateType() {
        return rateType;
    }

    /**
     * 设置状态 0：未备案 1：已备案 2：已合作 3：已失效
     *
     * @param rateType 状态 0：未备案 1：已备案 2：已合作 3：已失效
     */
    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区县
     *
     * @return area - 区县
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区县
     *
     * @param area 区县
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取详细地址
     *
     * @return adress - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param adress 详细地址
     */
    public void setAddress(String adress) {
        this.address = adress;
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