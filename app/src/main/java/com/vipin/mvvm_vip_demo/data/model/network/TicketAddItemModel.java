package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Entity(tableName = "TicketAddItemModel")
public class TicketAddItemModel implements Parcelable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    public TicketAddItemModel() {
    }

    public TicketAddItemModel(int storeId, Double total, Double grandTotal, Double tax, Double discount, String itemName, Double quantity, int itemId, List<Tax> taxes, Boolean modifier, Boolean variant, List<TicketModifier> ticketModifiers, List<TicketItemVarients> ticketItemVarients ,
                              Boolean isVoid, String uomshortName, Boolean allowDecimal,
                              Integer uomId, String skuCode , Double rateWithTax, Double discountAmt,
                              Double discountPer) {
        this.storeId = storeId;
        this.total = total;
        this.grandTotal = grandTotal;
        this.tax = tax;
        this.discount = discount;
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemId = itemId;
        this.taxes = taxes;
        this.modifier = modifier;
        this.variant = variant;
        this.ticketModifiers = ticketModifiers;
        this.ticketItemVarients = ticketItemVarients;
        this.isVoid = isVoid;
        this.uomshortName = uomshortName;
        this.allowDecimal =allowDecimal;
        this.uomId = uomId;
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


    protected TicketAddItemModel(Parcel in) {
        id = in.readInt();
        if (in.readByte() == 0) {
            discountAmt = null;
        } else {
            discountAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            discountPer = null;
        } else {
            discountPer = in.readDouble();
        }
        storeId = in.readInt();
        if (in.readByte() == 0) {
            rateWithTax = null;
        } else {
            rateWithTax = in.readDouble();
        }
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readDouble();
        }
        if (in.readByte() == 0) {
            grandTotal = null;
        } else {
            grandTotal = in.readDouble();
        }
        if (in.readByte() == 0) {
            tax = null;
        } else {
            tax = in.readDouble();
        }
        if (in.readByte() == 0) {
            discount = null;
        } else {
            discount = in.readDouble();
        }
        itemName = in.readString();
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readDouble();
        }
        itemId = in.readInt();
        byte tmpModifier = in.readByte();
        modifier = tmpModifier == 0 ? null : tmpModifier == 1;
        byte tmpVariant = in.readByte();
        variant = tmpVariant == 0 ? null : tmpVariant == 1;
        byte tmpIsVoid = in.readByte();
        isVoid = tmpIsVoid == 0 ? null : tmpIsVoid == 1;
        uomshortName = in.readString();
        byte tmpAllowDecimal = in.readByte();
        allowDecimal = tmpAllowDecimal == 0 ? null : tmpAllowDecimal == 1;
        uomId = in.readInt();
        skuCode = in.readString();
        senttokds = in.readByte() != 0;
        kotPrinted = in.readByte() != 0;
    }

    public static final Creator<TicketAddItemModel> CREATOR = new Creator<TicketAddItemModel>() {
        @Override
        public TicketAddItemModel createFromParcel(Parcel in) {
            return new TicketAddItemModel(in);
        }

        @Override
        public TicketAddItemModel[] newArray(int size) {
            return new TicketAddItemModel[size];
        }
    };

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
    public int storeId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    private Double rateWithTax;

    @ColumnInfo(name = "total")
    private Double total;

    @ColumnInfo(name = "grandTotal")
    private Double grandTotal;

    @ColumnInfo(name = "tax")
    private Double tax;

    @ColumnInfo(name = "discount")
    private Double discount;

    @ColumnInfo(name = "itemName")
    private String itemName;

    @ColumnInfo(name = "quantity")
    public Double quantity;

    @ColumnInfo(name = "itemId")
    public int itemId;

    private List<Tax> taxes = null;

    @ColumnInfo(name = "isModifier")
    private Boolean modifier;

    @ColumnInfo(name = "isVariant")
    private Boolean variant;


    @ColumnInfo(name = "ticketModifiers")
    private List<TicketModifier> ticketModifiers = null;


    @ColumnInfo(name = "ticketItemVarients")
    private List<TicketItemVarients> ticketItemVarients = null;
    @SerializedName("isVoid")
    @Expose
    private Boolean isVoid = false;
    @SerializedName("uomshortName")
    @Expose
    private String uomshortName;
    @SerializedName("allowDecimal")
    @Expose
    private Boolean allowDecimal;
    @SerializedName("uomId")
    @Expose
    public int uomId;

    @SerializedName("skuCode")
    @Expose
    private String skuCode;
    @SerializedName("senttokds")
    @Expose
    private boolean senttokds= false;
    @SerializedName("kotPrinted")
    @Expose
    private boolean kotPrinted= false;

    public boolean isSenttokds() {
        return senttokds;
    }

    public void setSenttokds(boolean senttokds) {
        this.senttokds = senttokds;
    }

    public boolean isKotPrinted() {
        return kotPrinted;
    }

    public void setKotPrinted(boolean kotPrinted) {
        this.kotPrinted = kotPrinted;
    }

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

    public int getUomId() {
        return uomId;
    }

    public void setUomId(int uomId) {
        this.uomId = uomId;
    }

    public List<TicketItemVarients> getTicketItemVarients() {
        return ticketItemVarients;
    }

    public void setTicketItemVarients(List<TicketItemVarients> ticketItemVarients) {
        this.ticketItemVarients = ticketItemVarients;
    }

    public List<TicketModifier> getTicketModifiers() {
        return ticketModifiers;
    }

    public void setTicketModifiers(List<TicketModifier> ticketModifiers) {
        this.ticketModifiers = ticketModifiers;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public Boolean getModifier() {
        return modifier;
    }

    public void setModifier(Boolean modifier) {
        this.modifier = modifier;
    }

    public Boolean getVariant() {
        return variant;
    }

    public void setVariant(Boolean variant) {
        this.variant = variant;
    }

    public Boolean getVoid() {
        return isVoid;
    }

    public void setVoid(Boolean aVoid) {
        isVoid = aVoid;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        if (discountAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(discountAmt);
        }
        if (discountPer == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(discountPer);
        }
        parcel.writeInt(storeId);
        if (rateWithTax == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(rateWithTax);
        }
        if (total == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(total);
        }
        if (grandTotal == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(grandTotal);
        }
        if (tax == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(tax);
        }
        if (discount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(discount);
        }
        parcel.writeString(itemName);
        if (quantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(quantity);
        }
        parcel.writeInt(itemId);
        parcel.writeByte((byte) (modifier == null ? 0 : modifier ? 1 : 2));
        parcel.writeByte((byte) (variant == null ? 0 : variant ? 1 : 2));
        parcel.writeByte((byte) (isVoid == null ? 0 : isVoid ? 1 : 2));
        parcel.writeString(uomshortName);
        parcel.writeByte((byte) (allowDecimal == null ? 0 : allowDecimal ? 1 : 2));
        parcel.writeInt(uomId);
        parcel.writeString(skuCode);
        parcel.writeByte((byte) (senttokds ? 1 : 0));
        parcel.writeByte((byte) (kotPrinted ? 1 : 0));
    }
}