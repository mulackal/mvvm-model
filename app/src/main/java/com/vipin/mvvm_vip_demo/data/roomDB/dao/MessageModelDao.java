package com.vipin.mvvm_vip_demo.data.roomDB.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;


import com.vipin.mvvm_vip_demo.data.roomDB.DateConverterUtil;
import com.vipin.mvvm_vip_demo.data.roomDB.model.MessageModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverterUtil.class) // Date type storing use
public interface MessageModelDao {

    @Query("select * from MessageModel  ORDER BY personName ASC")
    LiveData<List<MessageModel>>getAllMessageItems();

    @Insert(onConflict = REPLACE) // Same value insert time conflict problem avoid use
    void addMessage(MessageModel messageModel);

    @Delete
    void deleteMessageAll(MessageModel messageModel); // one item deleted

   /* //Table full clear

    @Query("DELETE FROM word_table")
    void deleteAll();*/




}
