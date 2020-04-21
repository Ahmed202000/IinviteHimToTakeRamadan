package com.example.iinvitehimtotakeramadan.view;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iinvitehimtotakeramadan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpenDuaa extends AppCompatActivity {

    @BindView(R.id.activity_open_duaa_txt)
    TextView activityOpenDuaaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_duaa);
        ButterKnife.bind(this);

        Intent intent=getIntent();

        if (intent.hasExtra("Duaa")){

            activityOpenDuaaTxt.setText(intent.getExtras().getString("Duaa"));
        }

        NotificationManager noManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        noManager.cancel(1);
    }
}
