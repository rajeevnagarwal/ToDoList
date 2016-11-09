package com.example.rajeevnagarwal.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class ItemActivity extends SingleFragmentActivity {

    private static final String EXTRA_ITEM_ID = "com.example.rajeevnagarwal.todolist.item_id";
    public static Intent newIntent(Context packageContext, Item itemId)
    {
        Intent intent = new Intent(packageContext,ItemActivity.class);
        intent.putExtra(EXTRA_ITEM_ID,itemId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        Item itemId = (Item)getIntent().getSerializableExtra(EXTRA_ITEM_ID);
        return ItemFragment.newInstance(itemId);
    }
}
