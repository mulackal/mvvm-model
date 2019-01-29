package com.vipin.mvvm_vip_demo.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vipin.mvvm_vip_demo.R;
import com.vipin.mvvm_vip_demo.data.model.network.TicketListModel;
import com.vipin.mvvm_vip_demo.databinding.ItemViewBinderTicket;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {


    Context mcontext;


    public List<TicketListModel> nDataList = new ArrayList<>();

    public ListAdapter(Context context) {

        this.mcontext = context;
    }

    public void setDataList(@NonNull List<TicketListModel> DataList) {
        this.nDataList = DataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemViewBinderTicket itemViewBind;

        public MyViewHolder(ItemViewBinderTicket itemBinding) {
            super(itemBinding.getRoot());

            this.itemViewBind = itemBinding;
        }

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewBinderTicket binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_items, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

           holder.itemViewBind.setTicketListmodel(nDataList.get(position));

         if (nDataList.get(position).getVoid())
             holder.itemViewBind.viewcolor.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
         else
             holder.itemViewBind.viewcolor.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));


        holder.itemViewBind.txtNotificationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Click : "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        if (nDataList != null)
            return nDataList.size();
        else
            return 0;
    }



}