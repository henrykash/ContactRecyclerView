package com.example.contactrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ViewHolder>{
    //initialize the array list of contacts and pass to it Contact class in order to avoid null pointer exception
    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;

    //initialize a constructor for this class press alt + insert
    public ContactsRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    //to create an instance of a View Holder class  for every   item on a recycler view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a view object to instantiate/inflate the layout items for each new items
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,contacts.get(position).getName() + "selected", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(holder.image);

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

          private  TextView txtName , txtEmail;
          private  CardView parent;
          private ImageView image;


        //create this constructor to initialize the view holder class press alt + insert to create it
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             txtName= itemView.findViewById(R.id.txtName);
             txtEmail = itemView.findViewById(R.id.txtEmail);
             image = itemView.findViewById(R.id.image);
             parent= itemView.findViewById(R.id.parent);
        }
    }
}
