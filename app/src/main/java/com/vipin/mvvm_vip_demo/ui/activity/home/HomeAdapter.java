package com.vipin.mvvm_vip_demo.ui.activity.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.vipin.mvvm_vip_demo.R;
import com.vipin.mvvm_vip_demo.data.model.network.Result;
import com.vipin.mvvm_vip_demo.databinding.ItemViewBinder;

import java.util.ArrayList;
import java.util.List;




public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


    Context mcontext;


    public List<Result> nDataList = new ArrayList<>();

    public HomeAdapter(Context context) {

        this.mcontext = context;
    }

    public void setHomeDataList(@NonNull List<Result> DataList) {
        this.nDataList = DataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemViewBinder itemViewBind;

        public MyViewHolder(ItemViewBinder itemBinding) {
            super(itemBinding.getRoot());

            this.itemViewBind = itemBinding;
        }

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewBinder binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_items, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

           holder.itemViewBind.setItemViewModel(nDataList.get(position));

         if (nDataList.get(position).getAdult())
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