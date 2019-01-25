package com.anukul.sqlitedemo.fragment;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anukul.sqlitedemo.ContactDbHelper;
import com.anukul.sqlitedemo.model.ContactModel;
import com.anukul.sqlitedemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment implements View.OnClickListener{

    private EditText contactIdEd;
    private EditText nameEd;
    private EditText emailEd;
    private Button saveBtn;

    SQLiteDatabase sqLiteDatabase;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_contact, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactIdEd = view.findViewById(R.id.fragment_addContact_contactIdEd);
        nameEd = view.findViewById(R.id.fragment_addContact_nameEd);
        emailEd = view.findViewById(R.id.fragment_addContact_emailEd);
        saveBtn = view.findViewById(R.id.fragment_addContact_saveBtn);

        saveBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_addContact_saveBtn:
                insertContact();
                break;
        }
    }

    private void insertContact() {
//        int conteactId = Integer.parseInt(contactIdEd.getText().toString().trim());
        String name = nameEd.getText().toString().trim();
        String email = emailEd.getText().toString().trim();

       // ContactModel contactModel = new ContactModel();
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        sqLiteDatabase = contactDbHelper.getWritableDatabase();
        contactDbHelper.insertContact(new ContactModel(name,email),sqLiteDatabase);
        contactDbHelper.close();
        contactIdEd.setText("");
        nameEd.setText("");
        emailEd.setText("");
        Toast.makeText(getActivity(),  "Contact saved sucessfully", Toast.LENGTH_SHORT).show();

    }
}