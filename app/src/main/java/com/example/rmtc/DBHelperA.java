package com.example.rmtc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperA extends SQLiteOpenHelper {

    public static final String DBName = "RMTC.db";

    public DBHelperA(Context context) {
        super(context, "RMTC.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDBA) {
        MyDBA.execSQL("create Table order(name primary key autoincrement TEXT, quantity INTEGER, price FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDBA, int i, int i1) {
        MyDBA.execSQL("drop table if exists order");
    }

    public Boolean insertData(String name, String quantity, String price){
        SQLiteDatabase MyDBA = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("quantity", quantity);
        contentValues.put("price", price);
        long result = MyDBA.insert("order", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean addStock(String name, String quantity) {
        SQLiteDatabase MyDBA = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("quantity", quantity);
        Cursor cursor = MyDBA.rawQuery("Select * from order where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = MyDBA.update("order", contentValues , "name=?", new String[]{quantity});
            if(result == -1) {
                return false;
             }
            else{
                return true;
             }
        }
        else{
            return false;
        }
    }

    public Boolean delStock(String name, String quantity) {
        SQLiteDatabase MyDBA = this.getWritableDatabase();
        Cursor cursor = MyDBA.rawQuery("Select * from order where quantity = ?", new String[]{quantity});
        if (cursor.getCount() > 0) {
            long result = MyDBA.delete("order", "quantity=?", new String[]{quantity});
            if(result == -1) {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
}
