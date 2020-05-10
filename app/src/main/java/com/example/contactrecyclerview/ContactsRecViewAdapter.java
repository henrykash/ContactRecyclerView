package com.example.contactrecyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ViewHolder>{
    //initialize the array list and pass to it Contact class in order to avoid null pointer exception
    private ArrayList<Contact> contacts = new ArrayList<>();

    //initialize a constructor for this class press alt + insert
    public ContactsRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

  //NB use this method to set the contacts as they change when accessing the data say over a web services
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();  //called to notify when the data changes
    }

    // this inner view holder class is responsible for holding every item on the recycler view
    public class ViewHolder extends RecyclerView.ViewHolder{

          private  TextView txtName;


        //create this constructor to initialize the view holder class press alt + insert to create it
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             txtName= itemView.findViewById(R.id.txtName);
        }
    }
}
