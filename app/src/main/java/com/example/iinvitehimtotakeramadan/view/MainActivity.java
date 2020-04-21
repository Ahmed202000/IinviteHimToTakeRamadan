package com.example.iinvitehimtotakeramadan.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iinvitehimtotakeramadan.BuildConfig;
import com.example.iinvitehimtotakeramadan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.activity_main_prayer_times, R.id.activity_main_constipation_time, R.id.activity_main_sating, R.id.activity_main_Invite_breakfast_time, R.id.activity_main_remember_allah, R.id.activity_main_pray_for_suhoor, R.id.activity_main_remember_the_morning, R.id.activity_main_evening_prayers, R.id.activity_main_abut_app, R.id.activity_main_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_main_prayer_times:
                startActivity(new Intent(this, PrayerTimes.class));
                break;
            case R.id.activity_main_constipation_time:
                startActivity(new Intent(this, ConstipationTime.class));
                break;
            case R.id.activity_main_sating:
                startActivity(new Intent(this, Sating.class));
                break;
            case R.id.activity_main_Invite_breakfast_time:
                startActivity(new Intent(this, InviteBreakfastTime.class));
                break;
            case R.id.activity_main_remember_allah:
                startActivity(new Intent(this, RememberAllah.class));
                break;
            case R.id.activity_main_pray_for_suhoor:
                startActivity(new Intent(this, PrayForSuhoor.class));
                break;
            case R.id.activity_main_remember_the_morning:
                startActivity(new Intent(this, RememberTheMorning.class));
                break;
            case R.id.activity_main_evening_prayers:
                startActivity(new Intent(this, EveningPrayers.class));
                break;
            case R.id.activity_main_abut_app:
                startActivity(new Intent(this, AbutApp.class));
                break;
            case R.id.activity_main_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
        }
    }
}
