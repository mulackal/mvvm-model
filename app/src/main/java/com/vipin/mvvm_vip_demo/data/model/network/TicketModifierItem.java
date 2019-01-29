package com.vipin.mvvm_vip_demo.data.model.network;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "TicketModifierItem")
public class TicketModifierItem {

	public TicketModifierItem(@NonNull Integer modifierId, String name, String price, Boolean isSelected) {
		this.modifierId = modifierId;
		this.name = name;
		this.price = price;
		this.isSelected = isSelected;
	}

	@PrimaryKey(autoGenerate = true)
	private Integer id;

	@NonNull
	@ForeignKey(
			entity = TicketModifier.class,
			parentColumns = "id",
			childColumns = "modifierId",
			onDelete = CASCADE,
			onUpdate = CASCADE)
	private Integer modifierId;

	private String name;

	private String price;

	private Boolean isSelected;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NonNull
	public Integer getModifierId() {
		return modifierId;
	}

	public void setModifierId(@NonNull Integer modifierId) {
		this.modifierId = modifierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Boolean getSelected() {
		return isSelected;
	}

	public void setSelected(Boolean selected) {
		isSelected = selected;
	}
}
