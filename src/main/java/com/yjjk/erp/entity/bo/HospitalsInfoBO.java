package com.yjjk.erp.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: YjjkErp
 * @description: 医院信息
 * @author: CentreS
 * @create: 2019-11-26 14:56:24
 **/
@Data
@Accessors(chain = true)
@ApiModel("医院信息")
public class HospitalsInfoBO {

    @ApiModelProperty(required = true)
    private Integer page;
    @ApiModelProperty(required = true)
    private Integer pageSize;
}
