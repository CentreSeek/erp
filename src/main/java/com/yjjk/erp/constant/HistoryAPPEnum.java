package com.yjjk.erp.constant;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: YjjkErp
 * @description: 医院状态
 * @author: CentreS
 * @create: 2019-11-25 20:56:45
 **/
public enum HistoryAPPEnum {
    RATE_TYPE_NON_RECORD(0, "未备案"),
    RATE_TYPE_RECORD(1, "已备案"),
    RATE_TYPE_COLLABORATE(2, "已合作"),
    RATE_TYPE_STOP(3, "未备案"),
    RATE_TYPE_PAST(4, "未备案"),
    ;

    private Integer rateType;

    private String typeName;

    HistoryAPPEnum(Integer rateType, String typeName) {
        this.rateType = rateType;
        this.typeName = typeName;
    }

    public Integer getRateType() {
        return this.rateType;
    }

    public static String getTypeName(Integer rateType) {
        for (HistoryAPPEnum r : HistoryAPPEnum.values()) {
            if (rateType.equals(r.getRateType())) {
                return r.typeName;
            }
        }
        return null;
    }
    public static String getJson() {
        Map<Object,Object> map = new HashMap<>();
        for (HistoryAPPEnum r : HistoryAPPEnum.values()) {
            map.put(r.rateType,r.typeName);
        }
        String s = JSON.toJSONString(map);
        return s;
    }

    @Override
    public String toString() {
        return "{" +
                "rateType=" + rateType +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
