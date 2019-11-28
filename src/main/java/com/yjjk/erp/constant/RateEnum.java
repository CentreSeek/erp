package com.yjjk.erp.constant;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: YjjkErp
 * @description: 备案进度
 * @author: CentreS
 * @create: 2019-11-25 20:56:45
 **/
public enum RateEnum {
    RATE_TYPE_SUCCESS(0, "备案成功"),
    RATE_TYPE_COMMIT(1, "方案提交"),
    RATE_TYPE_DESIGN(2, "勘察设计"),
    RATE_TYPE_SURE(3, "方案确定"),
    RATE_TYPE_EXAMINE(4, "院方审批"),
    RATE_TYPE_SIGN(5, "合同签订"),
    RATE_TYPE_PAYMENT(6, "付款成功"),
    ;

    private Integer rateType;

    private String typeName;

    RateEnum(Integer rateType, String typeName) {
        this.rateType = rateType;
        this.typeName = typeName;
    }

    public Integer getRateType() {
        return this.rateType;
    }

    public static String getTypeName(Integer rateType) {
        for (RateEnum r : RateEnum.values()) {
            if (rateType.equals(r.getRateType())) {
                return r.typeName;
            }
        }
        return null;
    }

    public static String getJson() {
        Map<Object, Object> map = new HashMap<>();
        for (RateEnum r : RateEnum.values()) {
            map.put(r.rateType, r.typeName);
        }
        String s = JSON.toJSONString(map);
        return s;
    }

    public static List getList() {
        List<Map<Integer, String>> list = new ArrayList<>();
        for (RateEnum r : RateEnum.values()) {
            Map<Integer, String> map = new HashMap<>();
            map.put(r.rateType, r.typeName);
            list.add(map);
        }
        return list;
    }

    @Override
    public String toString() {
        return "{" +
                "rateType=" + rateType +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(getList());
    }
}
