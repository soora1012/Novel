package com.gmail.soora1012.Novel.fragment;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gmail.soora1012.Novel.CustomDialog;
import com.gmail.soora1012.Novel.R;
import com.gmail.soora1012.Novel.sqlite.NovelDatabaseManager;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MenuFragment2 extends Fragment {
    private EditText content, title;
    private Button add;
    NovelDatabaseManager novelDatabaseManager;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_menu2,container,false);
        novelDatabaseManager = NovelDatabaseManager.getInstance(getActivity());

        title = view.findViewById(R.id.title);
        content = view.findViewById(R.id.content);
        add =view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String formatDate = simpleDateFormat.format(date);

                ContentValues addRowValue = new ContentValues();
                addRowValue.put("title", title.getText().toString());
                addRowValue.put("context", content.getText().toString());
                addRowValue.put("date", formatDate);
                addRowValue.put("views", 0);
                addRowValue.put("last_continue", 0);
                novelDatabaseManager.insert(addRowValue);

                content.setText("");
                title.setText("");
                new CustomDialog(getActivity()).
                        OneDialog(getString(R.string.notice), getString(R.string.add),
                                new CustomDialog.CustomOneDialogListener() {
                                    @Override
                                    public void onPositiveClicked() {
                                    }
                                }

                        );

            }
        });


        return view;
    }




}
