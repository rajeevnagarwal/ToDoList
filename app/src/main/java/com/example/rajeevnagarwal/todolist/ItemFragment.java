package com.example.rajeevnagarwal.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Rajeev Nagarwal on 11/2/2016.
 */

public class ItemFragment extends Fragment {

    private static final String ARG_ITEM_ID = "item_id";
    private Item mItem;
    private EditText mTitleField;
    private EditText mDescriptionField;
    private Button mAddButton;

    public static ItemFragment newInstance(Item itemId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_ID, itemId);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItem = (Item) getArguments().getSerializable(ARG_ITEM_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item, container, false);

        mTitleField = (EditText) v.findViewById(R.id.item_title);
        mAddButton = (Button)v.findViewById(R.id.add);
        mDescriptionField = (EditText)v.findViewById(R.id.item_description);
        mTitleField.setText(mItem.getTitle());
        mDescriptionField.setText(mItem.getDescription());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    mItem.setTitle(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDescriptionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mItem.setDescription(s.toString().trim());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println(mItem.getTitle());
                System.out.println(mItem.getDescription());
                if(mItem.getDescription()!=null&&mItem.getTitle()!=null) {
                    if (mItem.getTitle().length() > 0 && mItem.getDescription().length() > 0) {
                        if(!ItemLab.get(getActivity()).getItems().contains(mItem)) {
                            ItemLab.get(getActivity()).addItem(mItem);
                            Toast.makeText(getActivity(), "Item added", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getActivity(), "Item could not be added", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Item could not be added", Toast.LENGTH_SHORT).show();

                }
            }


        });



        return v;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }


    }


}
