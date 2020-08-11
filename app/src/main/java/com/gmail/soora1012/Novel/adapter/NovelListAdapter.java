package com.gmail.soora1012.Novel.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.soora1012.Novel.Item.NovelItem;
import com.gmail.soora1012.Novel.R;
import com.gmail.soora1012.Novel.activity.MainActivity;
import com.gmail.soora1012.Novel.activity.NovelListActivity;

import java.util.ArrayList;

public class NovelListAdapter extends RecyclerView.Adapter<NovelListAdapter.Holder> {


    private ArrayList<NovelItem> novelItems = new ArrayList<>();
    private Context mContext;

    public NovelListAdapter(Context context, ArrayList<NovelItem> list) {
        this.mContext = context;
        this.novelItems = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_novel, parent, false);
        Holder holder = new Holder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {
        int itemposition = position;
        holder.title.setText(novelItems.get(itemposition).getTitle());
        holder.date.setText(novelItems.get(itemposition).getDate());
        holder.views.setText(String.valueOf(novelItems.get(itemposition).getView()));


    }

    @Override
    public int getItemCount() {
        return novelItems.size();

    }


    public class Holder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView date;
        public TextView views;


        public Holder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            views = view.findViewById(R.id.view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NovelItem  items  = novelItems.get( getAdapterPosition());
                    Intent intent = new Intent(mContext, NovelListActivity.class);
                    intent.putExtra("id", String.valueOf(items.getId()));
                    intent.putExtra("title", items.getTitle());
                    intent.putExtra("context",items.getContext());
                    intent.putExtra("date",items.getDate());
                    intent.putExtra("view",String.valueOf(items.getView()));
                    mContext.startActivity(intent);
                }
            });

        }
    }

}