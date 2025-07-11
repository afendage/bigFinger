package com.finger.demo;

/**
 * 牌盒使用状态
 *
 * @author Nicolas
 */
public enum CardBoxStatusEnum {

    /**
     * 1、空盒，
     */
    EMPTY(1, "空盒"),
    /**
     * 2、待使用，
     */
    READY(2, "待使用"),
    /**
     * 3.使用中，
     */
    USEING(3, "使用中"),
    /**
     * 4.使用完结
     */
    USED(4, "使用完结"),
    /**
     * 5、Studio洗牌，
     */
    SHUFFER(5, "Studio洗牌"),
    /**
     * 6、预洗牌，
     */
    PREPARE(6, "预洗牌"),
    /**
     * 7、组长绑定确认，
     */
    CONFIRM(7, "组长绑定确认"),
    /**
     * 8.即将洗牌，
     */
    SOONSHUFFER(8, "即将洗牌");

    private Integer id;
    private String desc;

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    CardBoxStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static CardBoxStatusEnum getById(Integer id) {
        for (CardBoxStatusEnum statusEnum : CardBoxStatusEnum.values()) {
            if (statusEnum.id.equals(id)) {
                return statusEnum;
            }
        }
        return null;
    }

    public static CardBoxStatusEnum getByDesc(String desc) {
        for (CardBoxStatusEnum statusEnum : CardBoxStatusEnum.values()) {
            if (statusEnum.desc.equals(desc)) {
                return statusEnum;
            }
        }
        return null;
    }
}
