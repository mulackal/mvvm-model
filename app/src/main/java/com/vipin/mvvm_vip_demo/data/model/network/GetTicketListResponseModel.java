
package com.vipin.mvvm_vip_demo.data.model.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTicketListResponseModel {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("stationId")
    @Expose
    private Integer stationId;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("employeeId")
    @Expose
    private Integer employeeId;
    @SerializedName("ticketId")
    @Expose
    private String ticketId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;
    @SerializedName("ticketName")
    @Expose
    private String ticketName;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("totalAmount")
    @Expose
    private String totalAmount;
    @SerializedName("isSendSuccessfully")
    @Expose
    private Boolean isSendSuccessfully;
    @SerializedName("ticketAddItemModel")
    @Expose
    private Integer ticketAddItemModel;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("taxAmount")
    @Expose
    private String taxAmount;
    @SerializedName("grandTotal")
    @Expose
    private String grandTotal;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("isVoid")
    @Expose
    private Boolean isVoid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getIsSendSuccessfully() {
        return isSendSuccessfully;
    }

    public void setIsSendSuccessfully(Boolean isSendSuccessfully) {
        this.isSendSuccessfully = isSendSuccessfully;
    }

    public Integer getTicketAddItemModel() {
        return ticketAddItemModel;
    }

    public void setTicketAddItemModel(Integer ticketAddItemModel) {
        this.ticketAddItemModel = ticketAddItemModel;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Boolean getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(Boolean isVoid) {
        this.isVoid = isVoid;
    }

}
