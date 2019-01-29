package com.vipin.mvvm_vip_demo.data.model.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOpenTicketsResponseModel {

    @SerializedName("chargedOrderList")
    @Expose
    private List<TicketListModel> chargedOrderList = null;
    @SerializedName("newOrderList")
    @Expose
    private List<TicketListModel> newOrderList = null;
    @SerializedName("modifiedOrderList")
    @Expose
    private List<TicketListModel> modifiedOrderList = null;
    @SerializedName("deletedOrderList")
    @Expose
    private List<TicketListModel> deletedOrderList = null;

    public List<TicketListModel> getChargedOrderList() {
        return chargedOrderList;
    }

    public void setChargedOrderList(List<TicketListModel> chargedOrderList) {
        this.chargedOrderList = chargedOrderList;
    }

    public List<TicketListModel> getNewOrderList() {
        return newOrderList;
    }

    public void setNewOrderList(List<TicketListModel> newOrderList) {
        this.newOrderList = newOrderList;
    }

    public List<TicketListModel> getModifiedOrderList() {
        return modifiedOrderList;
    }

    public void setModifiedOrderList(List<TicketListModel> modifiedOrderList) {
        this.modifiedOrderList = modifiedOrderList;
    }

    public List<TicketListModel> getDeletedOrderList() {
        return deletedOrderList;
    }

    public void setDeletedOrderList(List<TicketListModel> deletedOrderList) {
        this.deletedOrderList = deletedOrderList;
    }
}
