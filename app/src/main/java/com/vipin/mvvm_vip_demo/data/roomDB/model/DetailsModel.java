package com.vipin.mvvm_vip_demo.data.roomDB.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*@Entity(tableName = "weather", indices = {@Index(value = {"date"}, unique = true)})
public class WeatherEntry {}*/

@Entity
public class DetailsModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "personName")
    private String personName;


    private String borrowDate;

    public DetailsModel(String personName, String borrowDate) {

        this.personName = personName;
        this.borrowDate = borrowDate;
    }


   /* @TypeConverters(ListItemsConverter.class) // list responds string to convert and store db
    @ColumnInfo(name = "ticketModifiers")
    private List<DetailsModel> ticketModifiers = null;
*/

   /* public List<DetailsModel> getTicketItemVarients() {
        return ticketItemVarients;
    }

    public void setTicketItemVarients(List<DetailsModel> ticketItemVarients) {
        this.ticketItemVarients = ticketItemVarients;
    }*/

    public String getPersonName() {
        return personName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
}
