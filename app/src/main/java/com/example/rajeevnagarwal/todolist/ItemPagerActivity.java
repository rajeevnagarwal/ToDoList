package com.example.rajeevnagarwal.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class ItemPagerActivity extends AppCompatActivity {


    private static final String EXTRA_ITEM_ID =
            "com.example.rajeevnagarwal.todolist.item_id";

    public static Intent newIntent(Context packageContext, Item itemId) {
        Intent intent = new Intent(packageContext, ItemPagerActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Item itemId = (Item) getIntent()
                .getSerializableExtra(EXTRA_ITEM_ID);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = ItemFragment.newInstance(itemId);
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
