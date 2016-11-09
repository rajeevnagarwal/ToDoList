package com.example.rajeevnagarwal.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.UUID;



/**
 * Created by Rajeev Nagarwal on 11/9/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String TEXT_TYPE =   "TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ItemDb.ItemEntry.TABLE_NAME+"("+
            ItemDb.ItemEntry.TABLE_ID+" "+TEXT_TYPE+COMMA_SEP+ItemDb.ItemEntry.COLUMN_TITLE+" "+TEXT_TYPE+COMMA_SEP+
            ItemDb.ItemEntry.COLUMN_DESCRIPTION+" "+TEXT_TYPE+")";
    private static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS "+ ItemDb.ItemEntry.TABLE_NAME;
    public static final int  DATABASE_VERSION = 2;
    public static final String DATABASE_NAME="PersonDb.db";
    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        onUpgrade(db,oldVersion,newVersion);
    }
    // For creating a record
    public void addItem(String id,String title,String detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        System.out.println(id);
        values.put(ItemDb.ItemEntry.TABLE_ID,id);
        values.put(ItemDb.ItemEntry.COLUMN_TITLE,title);
        values.put(ItemDb.ItemEntry.COLUMN_DESCRIPTION,detail);
        db.insert(ItemDb.ItemEntry.TABLE_NAME,null,values);
        db.close();
    }
    // For printing all records
    public ArrayList<Item> print()
    {
        ArrayList<Item> items = new ArrayList<Item>();
        String query = "SELECT * from "  + ItemDb.ItemEntry.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                Item obj = new Item(UUID.fromString(cursor.getString(cursor.getColumnIndex(ItemDb.ItemEntry.TABLE_ID))));
                obj.setTitle(cursor.getString(cursor.getColumnIndex(ItemDb.ItemEntry.COLUMN_TITLE)));
                obj.setDescription(cursor.getString(cursor.getColumnIndex(ItemDb.ItemEntry.COLUMN_DESCRIPTION)));
                items.add(obj);
            }while(cursor.moveToNext());

        }
        return items;
    }
}
