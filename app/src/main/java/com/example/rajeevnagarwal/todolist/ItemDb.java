package com.example.rajeevnagarwal.todolist;

import android.provider.BaseColumns;

/**
 * Created by Rajeev Nagarwal on 11/9/2016.
 */

public final class ItemDb {
    private ItemDb(){};
    public class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "Item";
        public static final String TABLE_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "detail";
    }

}
