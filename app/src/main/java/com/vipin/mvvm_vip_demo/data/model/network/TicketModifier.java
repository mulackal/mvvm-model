package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;



import java.io.Serializable;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class TicketModifier implements Serializable {

    public TicketModifier(@NonNull int ticketItemId, String name, List<TicketModifierItem> ticketModifierItems) {
        this.ticketItemId = ticketItemId;
        this.name = name;
        this.ticketModifierItems = ticketModifierItems;
    }

    @NonNull
    @PrimaryKey
    private Integer id;

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


    @ColumnInfo(name = "ticketModifierItems")
    private List<TicketModifierItem> ticketModifierItems = null;

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

    public List<TicketModifierItem> getTicketModifierItems() {
        return ticketModifierItems;
    }

    public void setTicketModifierItems(List<TicketModifierItem> ticketModifierItems) {
        this.ticketModifierItems = ticketModifierItems;
    }
}
