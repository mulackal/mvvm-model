package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Entity(tableName = "TicketListModel")
public class TicketListModel implements Parcelable {


    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;
    @SerializedName("grandTotal")
    @Expose
    private Double grandTotal;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("isVoid")
    @Expose
    private Boolean isVoid;
    @SerializedName("ticketId")
    @Expose
    private Integer ticketId = 0;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;
    @SerializedName("ticketName")
    @Expose
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ticketName")
    private String ticketName;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("totalAmount")
    @Expose
    private Double totalAmount;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("stationId")
    @Expose
    private Integer stationId;
    @SerializedName("customerId")
    @Expose
    private String customerId;
    @SerializedName("employeeId")
    @Expose
    private Integer employeeId;
    @SerializedName("isSendSuccessfully")
    @Expose
    private Boolean isSendSuccessfully;
    @SerializedName("ticketAddItemModels")
    @Expose
    @ColumnInfo(name = "ticketAddItemModels")
    private List<TicketAddItemModel> ticketAddItemModels = null;

    @SerializedName("tableName")
    @Expose
    private String tableName;

    @SerializedName("tableId")
    @Expose
    private Integer tableId;


    protected TicketListModel(Parcel in) {
        discount = in.readString();
        if (in.readByte() == 0) {
            taxAmount = null;
        } else {
            taxAmount = in.readDouble();
        }
        if (in.readByte() == 0) {
            grandTotal = null;
        } else {
            grandTotal = in.readDouble();
        }
        customerName = in.readString();
        if (in.readByte() == 0) {
            storeId = null;
        } else {
            storeId = in.readInt();
        }
        byte tmpIsVoid = in.readByte();
        isVoid = tmpIsVoid == 0 ? null : tmpIsVoid == 1;
        if (in.readByte() == 0) {
            ticketId = null;
        } else {
            ticketId = in.readInt();
        }
        createdDate = in.readString();
        createdTime = in.readString();
        ticketName = in.readString();
        employeeName = in.readString();
        if (in.readByte() == 0) {
            totalAmount = null;
        } else {
            totalAmount = in.readDouble();
        }
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        if (in.readByte() == 0) {
            stationId = null;
        } else {
            stationId = in.readInt();
        }
        customerId = in.readString();
        if (in.readByte() == 0) {
            employeeId = null;
        } else {
            employeeId = in.readInt();
        }
        byte tmpIsSendSuccessfully = in.readByte();
        isSendSuccessfully = tmpIsSendSuccessfully == 0 ? null : tmpIsSendSuccessfully == 1;
        ticketAddItemModels = in.createTypedArrayList(TicketAddItemModel.CREATOR);
        tableName = in.readString();
        if (in.readByte() == 0) {
            tableId = null;
        } else {
            tableId = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(discount);
        if (taxAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(taxAmount);
        }
        if (grandTotal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(grandTotal);
        }
        dest.writeString(customerName);
        if (storeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(storeId);
        }
        dest.writeByte((byte) (isVoid == null ? 0 : isVoid ? 1 : 2));
        if (ticketId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ticketId);
        }
        dest.writeString(createdDate);
        dest.writeString(createdTime);
        dest.writeString(ticketName);
        dest.writeString(employeeName);
        if (totalAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(totalAmount);
        }
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        if (stationId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stationId);
        }
        dest.writeString(customerId);
        if (employeeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(employeeId);
        }
        dest.writeByte((byte) (isSendSuccessfully == null ? 0 : isSendSuccessfully ? 1 : 2));
        dest.writeTypedList(ticketAddItemModels);
        dest.writeString(tableName);
        if (tableId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tableId);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TicketListModel> CREATOR = new Creator<TicketListModel>() {
        @Override
        public TicketListModel createFromParcel(Parcel in) {
            return new TicketListModel(in);
        }

        @Override
        public TicketListModel[] newArray(int size) {
            return new TicketListModel[size];
        }
    };

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
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

    public Boolean getVoid() {
        return isVoid;
    }

    public void setVoid(Boolean aVoid) {
        isVoid = aVoid;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
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

    @NonNull
    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(@NonNull String ticketName) {
        this.ticketName = ticketName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getSendSuccessfully() {
        return isSendSuccessfully;
    }

    public void setSendSuccessfully(Boolean sendSuccessfully) {
        isSendSuccessfully = sendSuccessfully;
    }

    public List<TicketAddItemModel> getTicketAddItemModels() {
        return ticketAddItemModels;
    }

    public void setTicketAddItemModels(List<TicketAddItemModel> ticketAddItemModels) {
        this.ticketAddItemModels = ticketAddItemModels;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public TicketListModel(String discount, Double taxAmount, Double grandTotal, String customerName, Integer storeId, Boolean isVoid, String createdDate, String createdTime, String ticketName, String employeeName, Double totalAmount, Integer userId, Integer stationId, String customerId, Integer employeeId, Boolean isSendSuccessfully,
                           String tableName, Integer tableId) {
        this.discount = discount;
        this.taxAmount = taxAmount;
        this.grandTotal = grandTotal;
        this.customerName = customerName;
        this.storeId = storeId;
        this.isVoid = isVoid;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.ticketName = ticketName;
        this.employeeName = employeeName;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.stationId = stationId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.isSendSuccessfully = isSendSuccessfully;
        this.tableName = tableName;
        this.tableId = tableId;

    }

    public TicketListModel() {

    }



}