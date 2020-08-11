package com.gmail.soora1012.Novel.fragment;

import android.database.Cursor;
import android.os.Bundle;

import com.gmail.soora1012.Novel.Item.NovelItem;
import com.gmail.soora1012.Novel.R;
import com.gmail.soora1012.Novel.adapter.NovelListAdapter;
import com.gmail.soora1012.Novel.sqlite.NovelDatabaseManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class MenuFragment1 extends Fragment {

    private NovelDatabaseManager novelDatabaseManager;
    private  RecyclerView recyclerView;
    private NovelListAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_menu1, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        novelDatabaseManager = NovelDatabaseManager.getInstance(getActivity());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ArrayList novelList =  getBoardData();
        recyclerView.setHasFixedSize(true);
        adapter = new NovelListAdapter(getActivity(),novelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

    }

    public ArrayList getBoardData()
    {
        ArrayList novelList = new ArrayList<>();
        String[] columns = new String[] {"_id", "title", "context", "date", "last_continue", "views"};

        Cursor cursor = novelDatabaseManager.query(columns, null, null,null,null,null);

        if(cursor != null)
        {
            while (cursor.moveToNext())
            {
                NovelItem currentData = new NovelItem();
                currentData.setId(cursor.getInt(0));
                currentData.setTitle(cursor.getString(1));
                currentData.setContext(cursor.getString(2));
                currentData.setDate(cursor.getString(3));
                currentData.setView(cursor.getInt(4));
                currentData.setView(cursor.getInt(5));

                novelList.add(currentData);

            }
        }

        return novelList;}

}

