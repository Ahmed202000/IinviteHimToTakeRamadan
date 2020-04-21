package com.example.iinvitehimtotakeramadan.view.servies;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.iinvitehimtotakeramadan.R;
import com.example.iinvitehimtotakeramadan.view.MainActivity;


import java.util.Random;

import static android.provider.Settings.System.getString;

public class AlertReceiver extends BroadcastReceiver {

    public static final String CHANNEL_ID = "com.chikeandroid.tutsplustalerts.ANDROID";
    public static final String CHANNEL_NAME = "ANDROID CHANNEL";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {


        String[] All_duee=context.getResources().getStringArray(R.array.Duaa);
        Random random=new Random();
        int NUM=random.nextInt(All_duee.length);
        String Duaa_To_notifiy=All_duee[NUM];

        Intent intent_OpenDuaa= new Intent(context, com.example.iinvitehimtotakeramadan.view.OpenDuaa.class);
        intent_OpenDuaa.putExtra("Duaa",Duaa_To_notifiy);
        PendingIntent pendOpen=PendingIntent.getActivity(context,222,intent_OpenDuaa,PendingIntent.FLAG_CANCEL_CURRENT);


        Intent intent_Shear= new Intent(context, com.example.iinvitehimtotakeramadan.view.Shear.class);
        intent_Shear.putExtra("Duaa",Duaa_To_notifiy);
        PendingIntent intentShear=PendingIntent.getActivity(context,333,intent_Shear,PendingIntent.FLAG_CANCEL_CURRENT);


        Intent intent_mainActivity=new Intent(context,MainActivity.class);
        PendingIntent notificatoin=PendingIntent.getActivity(context,100,intent_mainActivity,0);


        Bitmap bitmap_icon= BitmapFactory.decodeResource(context.getResources(),R.drawable.logo);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("ادعيه قرأنيه")
                .setLargeIcon(bitmap_icon)
                .setContentTitle(Duaa_To_notifiy)
                .addAction(R.drawable.ic_open,"فتح الدعاء",pendOpen)
                .addAction(R.drawable.ic_share,"مشتركه ",intentShear);




        builder.setContentIntent(notificatoin);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);


        NotificationManager noManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        noManager.cancel(1);
        noManager.notify(1,builder.build());


        MediaPlayer mediaPlayer= MediaPlayer.create(context,R.raw.duaa);
        mediaPlayer.start();

    }
}
