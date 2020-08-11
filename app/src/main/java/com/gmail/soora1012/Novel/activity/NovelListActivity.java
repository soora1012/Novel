package com.gmail.soora1012.Novel.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.soora1012.Novel.R;
import com.gmail.soora1012.Novel.sqlite.NovelDatabaseManager;

public class NovelListActivity extends AppCompatActivity {
    NovelDatabaseManager novelDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_list);
        novelDatabaseManager = NovelDatabaseManager.getInstance(this);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        String context = intent.getExtras().getString("context");
        String date = intent.getExtras().getString("date");
        int view = Integer.valueOf(intent.getExtras().getString("view"))+1;
        final int id = Integer.valueOf(intent.getExtras().getString("id"));


        TextView tv_title = findViewById(R.id.title);
        tv_title.setText(title);
        TextView tv_content = findViewById(R.id.content);
        tv_content.setText(context);
        TextView tv_date = findViewById(R.id.date);
        tv_date.setText(date);
        TextView tv_view = findViewById(R.id.view);
        tv_view.setText(String.valueOf(view));


        novelDatabaseManager.updateData(id, view);


        Button del = findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                novelDatabaseManager.removeData(id);
                finish();

            }
        });


    }
}
