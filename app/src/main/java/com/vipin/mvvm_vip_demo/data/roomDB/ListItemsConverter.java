package com.vipin.mvvm_vip_demo.data.roomDB;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vipin.mvvm_vip_demo.data.roomDB.model.DetailsModel;


import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ListItemsConverter implements Serializable {

    @TypeConverter // note this annotation
    public String fromOptionValuesList(List<DetailsModel> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DetailsModel>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<DetailsModel> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DetailsModel>>() {
        }.getType();
        List<DetailsModel> ticketModifierItems = gson.fromJson(optionValuesString, type);
        return ticketModifierItems;
    }
}
