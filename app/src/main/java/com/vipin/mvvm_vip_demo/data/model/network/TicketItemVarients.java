package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class TicketItemVarients implements Serializable {

    public TicketItemVarients(@NonNull int ticketItemId, int itemId, String name, Double rate, Double currentRate,
                              Double taxAmount, Boolean isSelected, List<Tax> taxes,
                              String skuCode , Double rateWithTax, Double discountAmt, Double discountPer) {
        this.ticketItemId = ticketItemId;
        this.itemId = itemId;
        this.name = name;
        this.rate = rate;
        this.currentRate = currentRate;
        this.taxAmount = taxAmount;
        this.isSelected = isSelected;
        this.taxes =taxes;
        this.skuCode = skuCode;
        this.rateWithTax = rateWithTax;
        this.discountAmt = discountAmt;
        this.discountPer = discountPer;
    }


    @SerializedName("discountAmt")
    @Expose
    private Double discountAmt;
    @SerializedName("discountPer")
    @Expose
    private Double discountPer;

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Double getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Double discountPer) {
        this.discountPer = discountPer;
    }

    @NonNull
    @PrimaryKey
    private Integer id;

    private Integer itemId;

    private Double rateWithTax;


    @NonNull
    @ForeignKey(
            entity = TicketAddItemModel.class,
            parentColumns = "id",
            childColumns = "ticketItemId",
            onDelete = CASCADE,
            onUpdate = CASCADE)
    private int ticketItemId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "rate")
    private Double rate;

    @SerializedName("currentRate")
    @Expose
    private Double currentRate;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;

    @SerializedName("isSelected")
    @ColumnInfo(name = "selected")
    private Boolean isSelected;

    @SerializedName("uomshortName")
    @Expose
    private String uomshortName;

    @SerializedName("allowDecimal")
    @Expose
    private Boolean allowDecimal;

    @SerializedName("taxes")
    @Expose
    private List<Tax> taxes = null;

    @SerializedName("skuCode")
    @Expose
    private String skuCode;

    public Double getRateWithTax() {
        return rateWithTax;
    }

    public void setRateWithTax(Double rateWithTax) {
        this.rateWithTax = rateWithTax;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public int getTicketItemId() {
        return ticketItemId;
    }

    public void setTicketItemId(@NonNull int ticketItemId) {
        this.ticketItemId = ticketItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Double currentRate) {
        this.currentRate = currentRate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public String getUomshortName() {
        return uomshortName;
    }

    public void setUomshortName(String uomshortName) {
        this.uomshortName = uomshortName;
    }

    public Boolean getAllowDecimal() {
        return allowDecimal;
    }

    public void setAllowDecimal(Boolean allowDecimal) {
        this.allowDecimal = allowDecimal;
    }
}
