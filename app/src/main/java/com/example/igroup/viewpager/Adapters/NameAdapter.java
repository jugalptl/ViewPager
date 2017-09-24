package com.example.igroup.viewpager.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igroup.viewpager.Pojo.Clients;
import com.example.igroup.viewpager.R;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by iGroup on 3/18/2017.
 */
public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolderNames> {

    private LayoutInflater layoutInflater;
        public String[] name;

    protected Context context;
    public ArrayList<Clients> tempClientsList = new ArrayList<>();
    Clients currentClient;

    public NameAdapter(Context context, ArrayList<Clients> clientArrayList) {

        this.tempClientsList = clientArrayList;

        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.notifyDataSetChanged();
    }


    @Override
    public ViewHolderNames onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.custom_row_namelist,parent,false);
        ViewHolderNames viewHolder = new ViewHolderNames(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolderNames holder, int position) {



        currentClient = tempClientsList.get(position);

        if(!currentClient.getFirstName().equals(null) && currentClient.getFirstName() != null)
        {
            holder.Name.setText(currentClient.getFirstName().substring(0,1).toUpperCase() + currentClient.getFirstName().substring(1).toString());
        }
        else
        {
            holder.Name.setText("");
        }

        holder.Address.setText(currentClient.getLastName().toString());
        holder.Email.setText(currentClient.getEmail().toString());
        holder.profile.setBackgroundResource(R.drawable.profilepicture);


    }

    @Override
    public int getItemCount() {
        return tempClientsList.size();
    }

    public class ViewHolderNames extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView Name,Address,Email;
        SimpleDraweeView profile;

        public ViewHolderNames(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.clientName);
            Address = (TextView)itemView.findViewById(R.id.address);
            Email=(TextView)itemView.findViewById(R.id.email);
            profile=(SimpleDraweeView)itemView.findViewById(R.id.clientImage);

        }



        @Override
        public void onClick(View v) {

        }
    }
}
