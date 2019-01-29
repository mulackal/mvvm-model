package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.view.MenuItem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Tax {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;

    @ForeignKey(
            entity = MenuItem.class,
            parentColumns = "id",
            childColumns = "itemId")
    private Integer itemId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
