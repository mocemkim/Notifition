package com.example.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;

public class ShowListNotification extends AppCompatActivity {
    List<DataNotification> listDataNotification;
    Adapter adapter;
    ListView lvNotification;
    ImageView imageView;
    ManagerDatabase managerDatabase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_listnotification);

        // init
        listDataNotification = new ArrayList<DataNotification>();
        imageView = findViewById(R.id.img_background);

        // set background for ImageView
        imageView.setBackgroundResource(R.drawable.background);
        // get database and show listview
        managerDatabase = new ManagerDatabase(this);
        listDataNotification = managerDatabase.getAllNotification();
        lvNotification = findViewById(R.id.lv_listnotification);
        Adapter adapter = new Adapter(this,R.layout.item_column,listDataNotification);
        lvNotification.setAdapter(adapter);

    }
}
