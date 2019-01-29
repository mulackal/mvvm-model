package com.vipin.mvvm_vip_demo.data.roomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.vipin.mvvm_vip_demo.data.roomDB.dao.DetailsModelDao;
import com.vipin.mvvm_vip_demo.data.roomDB.dao.MessageModelDao;
import com.vipin.mvvm_vip_demo.data.roomDB.model.DetailsModel;
import com.vipin.mvvm_vip_demo.data.roomDB.model.MessageModel;


@Database(entities = {MessageModel.class, DetailsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "borrow_db")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract MessageModelDao itemAndPersonModel();

    public abstract DetailsModelDao itemDetailsModel();



}
