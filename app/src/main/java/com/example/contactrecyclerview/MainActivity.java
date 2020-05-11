package com.example.contactrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //initializing the recyclerview
    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("rihana","riri@gmail.com","https://image.shutterstock.com/image-photo/new-york-sep-14-2017-260nw-735435583.jpg"));
        contacts.add(new Contact("riri","riri@gmail.com","https://image.shutterstock.com/image-photo/new-york-sep-14-2017-260nw-735435583.jpg"));
        contacts.add(new Contact("Mary","mary@gmail.com", "https://image.shutterstock.com/image-photo/new-york-sep-14-2017-260nw-735435583.jpg"));
        contacts.add(new Contact("simi","simi@gmail.com","https://image.shutterstock.com/image-photo/new-york-sep-14-2017-260nw-735435583.jpg"));
        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
