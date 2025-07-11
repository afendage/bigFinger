package com.finger.demo;

import java.util.Arrays;
import java.util.Optional;

/**
 * 牌盒设备类型枚举
 */
public enum CardDeviceTypeEnum {

    CARD_8(1, "8副牌", 8),
    CARD_2(4, "2副牌", 2),
    CARD_6(5, "6副牌", 6);

    public Integer type;
    public String desc;
    public Integer card;

    CardDeviceTypeEnum(Integer type, String desc, Integer card){
        this.type = type;
        this.desc = desc;
        this.card = card;
    }

    public static CardDeviceTypeEnum getByType(Integer type){
        Optional<CardDeviceTypeEnum> first = Arrays.stream(CardDeviceTypeEnum.values()).filter(cd -> cd.type.equals(type)).findFirst();
        return first.isPresent() ? first.get() : null;
    }
}
