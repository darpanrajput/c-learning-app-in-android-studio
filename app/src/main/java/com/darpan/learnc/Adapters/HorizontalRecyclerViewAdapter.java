package com.darpan.learnc.Adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.darpan.learnc.R;
import com.darpan.learnc.Tabs.Tab2;
import com.darpan.learnc.models.secondfragmentsItems;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.myViewHolder> {
    Context mcontext;
    List<secondfragmentsItems> mdata;
    int index;

    public HorizontalRecyclerViewAdapter(Context mcontext, List<secondfragmentsItems> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_tab2, null,
                false);
        final myViewHolder viewHolder = new myViewHolder(v);

        return viewHolder;
    }


    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, final int i) {
        index=i;

        netsedRvAdapter netsedRvAdapter = new netsedRvAdapter(mcontext, mdata.get(i).getNestedList(),index);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);
        myViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        myViewHolder.recyclerView.setAdapter(netsedRvAdapter);


    }


    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.secondFragmentRecyclerView);


        }
    }

}
