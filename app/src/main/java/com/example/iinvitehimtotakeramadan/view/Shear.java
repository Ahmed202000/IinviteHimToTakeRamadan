package com.example.iinvitehimtotakeramadan.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.iinvitehimtotakeramadan.R;

public class Shear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shear);


        Intent intent=getIntent();

        if (intent.hasExtra("Duaa")) {

            Intent shear=new Intent(Intent.ACTION_SEND);
            shear.setType("text/plian");
            shear.putExtra(Intent.EXTRA_TEXT, intent.getExtras().getString("Duaa"));
            if (shear.resolveActivity(getPackageManager()) != null) {

                startActivity(Intent.createChooser(shear, "مشاركه الدعاء"));

            }
        }

        NotificationManager noManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        noManager.cancel(1);
        finish();

    }
}
