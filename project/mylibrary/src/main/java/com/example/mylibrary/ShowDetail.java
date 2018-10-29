package com.example.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by KIM on 10/18/2018.
 */

public class ShowDetail extends AppCompatActivity {
   private TextView tvTime;
   private TextView tvTitle;
   private TextView tvContent;
   private TextView tvType;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_detail);

        // init
        tvTime = findViewById(R.id.tv_time);
        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        tvType = findViewById(R.id.tv_type);

        DataNotification dataNotification =   getIntent().getParcelableExtra("dataNotification");

        //set content for textViews
        tvTime.setText(dataNotification.getTime());
        tvTitle.setText(dataNotification.getTitle());
        tvContent.setText(dataNotification.getContent());
        tvType.setText(dataNotification.getType());



    }
}
