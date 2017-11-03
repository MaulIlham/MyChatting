package com.example.schiffers.chatting.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.schiffers.chatting.R;
import com.example.schiffers.chatting.models.chat;

import java.util.ArrayList;
import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.chatHolder>{
    List<chat>mData=new ArrayList<chat>();
    Context ctx;
    //private Activity mACtivity;

    public chatAdapter(Context context,List<chat> data) {
        this.ctx=context;
        this.mData=data;
    }

    @Override
    public chatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View view= layoutInflater.inflate(R.layout.listview,parent,false);
        return new chatHolder(view);
    }

    @Override
    public void onBindViewHolder(chatHolder holder, int position) {
        //chat ch=mData.get(position);
        holder.tv1.setText(mData.get(position).getUsername());
        holder.tv1.setText(mData.get(position).getMessage());
        holder.tv3.setText(mData.get(position).getDate());
        holder.ft.setImageResource(mData.get(position).getfoto());
    }

    @Override
    public int getItemCount() {
       return mData.size();
    }

    public class chatHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3;
        ImageView ft;
        public chatHolder(View itemView) {
            super(itemView);

            tv1=(TextView)itemView.findViewById(R.id.txtusr);
            tv2=(TextView)itemView.findViewById(R.id.txtmessa);
            tv3=(TextView)itemView.findViewById(R.id.txttgl);
            ft=(ImageView)itemView.findViewById(R.id.imageView);
        }
        }
}