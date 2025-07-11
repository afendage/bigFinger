package com.finger.demo;


import java.util.List;
import java.util.Map;

public class CardBoxArea {

	/**
	 * 区域
	 */
	private String area;

	/**
	 * 牌盒类型
	 */
//	@ApiModelProperty(value = "牌盒类型(分8副牌和2副牌)")
//	private Integer cardBoxType;

	/**
	 * 牌盒列表
	 */
	private List<CardBox> cardBoxs;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<CardBox> getCardBoxs() {
		return cardBoxs;
	}

	public void setCardBoxs(List<CardBox> cardBoxs) {
		this.cardBoxs = cardBoxs;
	}
}
