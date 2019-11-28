package com.yjjk.erp.entity.vo;

import com.yjjk.erp.constant.RecordEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: YjjkErp
 * @description: 备案管理信息列表
 * @author: CentreS
 * @create: 2019-11-26 15:53:55
 **/
@Data
@Accessors(chain = true)
@ApiModel("备案管理信息列表")
public class RecordsInfoVO {

    private Integer id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 公司id
     */
    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("经销商信息")
    private String franchiserInfo;

    /**
     * 医院id
     */
    @ApiModelProperty("医院名称")
    private String hospitalName;

    /**
     * 审核状态 0：待审核 1：通过 2：不通过 3：备案过期
     */
    @ApiModelProperty("审核状态")
    private String checkStatus;
    @ApiModelProperty("审核状态type")
    private Integer checkStatusInt;

    public void setCheckStatusInt(Integer checkStatusInt) {
        this.checkStatusInt = checkStatusInt;
        this.checkStatus = RecordEnum.getTypeName(checkStatusInt);
    }

    @ApiModelProperty("备案有效期")
    private String recordValidityDate;

}
