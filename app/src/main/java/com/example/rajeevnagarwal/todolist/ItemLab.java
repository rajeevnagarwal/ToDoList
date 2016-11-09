package com.example.rajeevnagarwal.todolist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Rajeev Nagarwal on 11/2/2016.
 */

public class ItemLab {
    private static ItemLab sItemLab;

    private ArrayList<Item> mItems;

    public static ItemLab get(Context context) {
        if (sItemLab == null) {
            sItemLab = new ItemLab(context);
        }
        return sItemLab;
    }

    private ItemLab(Context context) {
        mItems = new ArrayList<>();
    }
    public  void addItem(Item c)
    {
        mItems.add(c);
    }


    public List<Item> getItems() {
        return mItems;
    }

    public Item getItem(UUID id) {
        for (Item item : mItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
