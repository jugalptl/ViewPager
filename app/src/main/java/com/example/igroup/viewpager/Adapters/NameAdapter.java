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
 * Created by iGroup on 12/7/2016.
 */
public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolderNames> {

    private LayoutInflater layoutInflater;
   /* public ArrayList<String> Namelist = new ArrayList<>();
    public ArrayList<String> Addresslist = new ArrayList<>();
   */ public ArrayList<String[]> ContactInfo = new ArrayList<String[]>();
        public String[] name;
    public String[] add;
    public String[] email = new String[5];
    //public ArrayList<Clients> tempClientsList;
    protected Context context;
    public ArrayList<Clients> tempClientsList = new ArrayList<>();
    Clients currentClient;

    public NameAdapter(Context context, ArrayList<Clients> clientArrayList) {

        name = new String[]{"Jugal", "Ravi", "Divyang", "Mirav", "Maddy"};
        add = new String[]{"Canada","Vadodara","Padra","Canada","Gorva"};
       ContactInfo.add(name);
        ContactInfo.add(add);
       // this.clientsList = tempClientsList;
        this.tempClientsList = clientArrayList;
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"+clientArrayList.toString() );
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        //notifyItemRangeChanged(0, clientsList.size());
        this.notifyDataSetChanged();
    }


    @Override
    public ViewHolderNames onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = layoutInflater.inflate(R.layout.custom_row_namelist,parent,false);
        View view = layoutInflater.inflate(R.layout.custom_row_namelist,parent,false);
        ViewHolderNames viewHolder = new ViewHolderNames(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolderNames holder, int position) {

       // holder.Name.setText("Jugal Patel");
       // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+Namelist.get(0));
      //  holder.Name.setText(Namelist.get(1));
       // holder.Address.setText(Addresslist.get(0));
       /* for( int i = 0; i < ContactInfo.size(); i++ ) {
            for (int j = 0; j < ContactInfo.get(i).length; j++) {  System.out.printf(" $ " + ContactInfo.get(i)[j]);
                holder.Name.setText(ContactInfo.get(i)[j]);
                //System.out.println();
            }
        }*/

        currentClient = tempClientsList.get(position + 1);

        if(!currentClient.getFirstName().equals(null) && currentClient.getFirstName() != null)
        {
            holder.Name.setText(currentClient.getFirstName().substring(0,1).toUpperCase() + currentClient.getFirstName().substring(1).toString());
        }
        else
        {
            holder.Name.setText("");
        }

          //  holder.Name.setText(name[position]);
        holder.Address.setText(currentClient.getLastName().toString());
        holder.Email.setText(currentClient.getEmail().toString());
        holder.profile.setBackgroundResource(R.drawable.profilepicture);


    }

    @Override
    public int getItemCount() {
        return 5;
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
