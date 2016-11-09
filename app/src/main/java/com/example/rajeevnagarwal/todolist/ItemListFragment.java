package com.example.rajeevnagarwal.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rajeev Nagarwal on 11/2/2016.
 */

public class ItemListFragment extends Fragment {

    private RecyclerView mItemRecyclerView;
    private ItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedinstanceState)
    { super.onCreate(savedinstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        mItemRecyclerView = (RecyclerView) view
                .findViewById(R.id.item_item_view);
        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    { super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_item_list,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item1) {
        switch   (item1.getItemId())   {
            case R.id.menu_item_new_item: Item  item  =  new   Item();
                Intent intent  =   ItemPagerActivity.newIntent(getActivity(), item);
                startActivity(intent);
                return true;
            default:      return super.onOptionsItemSelected(item1);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ItemLab itemLab = ItemLab.get(getActivity());
        List<Item> items = itemLab.getItems();

        if (mAdapter == null) {
            mAdapter = new ItemAdapter(items);
            mItemRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;

        private Item mItem;

        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_item_title_text_view);
        }

        public void bindItem(Item item) {
            mItem = item;
            mTitleTextView.setText(mItem.getTitle());

        }

        @Override
        public void onClick(View v) {
            Intent intent =DetailActivity.newIntent(getActivity(), mItem.getId());
            startActivity(intent);
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

        private List<Item> mItems;
        public ItemAdapter(List<Item> items) {
            mItems = items;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_item, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            Item item = mItems.get(position);
            holder.bindItem(item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}

