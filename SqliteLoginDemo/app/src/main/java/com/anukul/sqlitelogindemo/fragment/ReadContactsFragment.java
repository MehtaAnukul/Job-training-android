package com.anukul.sqlitelogindemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anukul.sqlitelogindemo.ContactDbHelper;
import com.anukul.sqlitelogindemo.ContactModel;
import com.anukul.sqlitelogindemo.R;
import com.anukul.sqlitelogindemo.adapter.ReadContactAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

    private RecyclerView customReadContactRecyclerView;
    private ArrayList<ContactModel> contactModelArrayList;
    private ReadContactAdapter readContactAdapter;

    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contacts, container, false);

        customReadContactRecyclerView = view.findViewById(R.id.fragment_readContact_recyclerView);

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        contactModelArrayList = contactDbHelper.getAllUser();
        readContactAdapter = new ReadContactAdapter(contactModelArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        customReadContactRecyclerView.setLayoutManager(layoutManager);
        customReadContactRecyclerView.setAdapter(readContactAdapter);
        return view;
    }

}
