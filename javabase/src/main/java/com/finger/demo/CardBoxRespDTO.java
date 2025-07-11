package com.finger.demo;

import java.time.LocalDateTime;

public class CardBoxRespDTO {
	
	private Long id;

    private Long hallId;
	
	private int deviceType;
	
	private String shuffleType;
	
	private Long tableId;
	
	private String tableNo;
	
    private String cardBoxNo;

    private Integer status;
    
    private String bootNo;

    private String dealers;
    
    private int usedCount;
    
    private String createdBy;
    
    private LocalDateTime updatedAt;
    
    private String updatedBy;

    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getShuffleType() {
        return shuffleType;
    }

    public void setShuffleType(String shuffleType) {
        this.shuffleType = shuffleType;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getCardBoxNo() {
        return cardBoxNo;
    }

    public void setCardBoxNo(String cardBoxNo) {
        this.cardBoxNo = cardBoxNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBootNo() {
        return bootNo;
    }

    public void setBootNo(String bootNo) {
        this.bootNo = bootNo;
    }

    public String getDealers() {
        return dealers;
    }

    public void setDealers(String dealers) {
        this.dealers = dealers;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
