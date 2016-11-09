package com.example.rajeevnagarwal.todolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Rajeev Nagarwal on 11/8/2016.
 */

public class DescriptionActivity extends Fragment {
    private static final String ARG_ITEM_ID = "item_id";
    private Item mItem;
    private TextView mTitleField;
    private TextView mDescriptionField;
    public static DescriptionActivity newInstance(UUID itemId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_ID, itemId);

        DescriptionActivity fragment = new DescriptionActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getArguments().getSerializable(ARG_ITEM_ID);
        mItem = ItemLab.get(getActivity()).getItem(itemId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_description, container, false);

        mTitleField = (TextView) v.findViewById(R.id.title);
        mDescriptionField = (TextView) v.findViewById(R.id.details);
        mTitleField.setText("Title: \n");
        mTitleField.append(mItem.getTitle());
        mDescriptionField.setText("Details: \n");
        mDescriptionField.append(mItem.getDescription());
        return v;
    }


}
