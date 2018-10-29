package com.example.mylibrary;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Calendar;

public class SenderActivity extends AppCompatActivity {

    private String CHANNEL_ID="channelID";
    private ListView lvNotification;
    private adapter.Adapter adapter;
    private DataNotification dataNotification;
    private  ManagerDatabase managerDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //innitial database
        managerDatabase = new ManagerDatabase(this);
        // create DataNotification to add to Database and send Notificaiton
        final DataNotification dataNotification = new DataNotification();
        dataNotification.setTime(Calendar.getInstance().getTime().toString());
        dataNotification.setTitle("Title");
        dataNotification.setContent("Trên tờ Daily Mail, ký giả Ian Ladyman có bài viết: “Một Ronaldo năng động vượt mặt Pogba”. Ông đánh giá: “Sự so sánh cho hai cầu thủ là tất yếu bởi họ đều được trả rất nhiều tiền để giúp CLB của mình chiến thắng. Nhưng trong trận đấu này chỉ có một người cho thấy mình có khả năng đó, và điểm then chốt không chỉ là Ronaldo kiến tạo bàn thắng của Paulo Dybala”.\n" +
                "\n" +
                "Trong khi đó Andy Dunn của tờ The Mirror nhìn nhận sự so sánh này theo khía cạnh marketing. “Trong lúc Ronaldo giải cứu một fan cuồng chạy vào sân khỏi bị còng tay và cùng chụp ảnh selfie với người đó, Pogba đã rời khỏi sân từ lâu. Ronaldo và Pogba đều là hai ngôi sao marketing, nhưng chỉ có một kẻ đang làm tốt hơn hẳn và người đó là người chiến thắng, người luôn tạo ra đột biết trận này qua trận khác để có cơ hội làm tăng giá trị hình ảnh của mình hơn nữa”, Dunn bình luận.");
        dataNotification.setType("New");

        // Create an explicit intent for an Activity in your app
        // PedingIntent meaning that NotificationManager can use ShowDetail activity
        Intent intent = new Intent(this,ShowDetail.class);
        intent.putExtra("dataNotification",dataNotification);
        final PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[] {intent}, PendingIntent.FLAG_ONE_SHOT);

        // set attribute of Notification
        // setContentIntent - Every notification should respond to a tap
       final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.sendmessage)
                .setContentTitle(dataNotification.getTitle())
                .setWhen(System.currentTimeMillis())
                .setContentText(dataNotification.getContent())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Send notification
       final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
       notificationManager.notify(0,mBuilder.build());

       // add to database
        managerDatabase.addNotification(dataNotification);
        finish();

    }
}
