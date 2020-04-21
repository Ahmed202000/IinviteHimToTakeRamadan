package com.example.iinvitehimtotakeramadan.view;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iinvitehimtotakeramadan.R;
import com.example.iinvitehimtotakeramadan.view.servies.AlertReceiver;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Sating extends AppCompatActivity {

    @BindView(R.id.activity_sating_prayer)
    CheckBox activitySatingPrayer;
    @BindView(R.id.activity_sating_our_business)
    TextView activitySatingOurBusiness;
    @BindView(R.id.activity_sating_privacy_policies)
    TextView activitySatingPrivacyPolicies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sating);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.activity_sating_prayer, R.id.activity_sating_our_business, R.id.activity_sating_privacy_policies, R.id.activity_sating_rating})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_sating_prayer:

                showDialog(1);
                // ارسال نتفكيشن بوقت محدد
//                    Calendar calendar=Calendar.getInstance();
//                    calendar.set(Calendar.HOUR_OF_DAY,12);
//                    calendar.set(Calendar.MINUTE,30);
//                    calendar.set(Calendar.SECOND,0);
//
//                    Intent alertIntent=new Intent(getApplicationContext(), AlertReceiver.class);
//                    AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

                //ارسال نتفكيشن مره واحده
//                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,
//                            PendingIntent.FLAG_CANCEL_CURRENT));

                //ارسال نتفكيشن يوميه
//                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_HOUR,PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,
//                        PendingIntent.FLAG_CANCEL_CURRENT));

                //عمل ايقاف للاشعارات
//                alarmManager.cancel(PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,
//                        PendingIntent.FLAG_CANCEL_CURRENT));


                break;

            case R.id.activity_sating_our_business:
                startActivity(new Intent(Sating.this, OurBusiness.class));

                break;

            case R.id.activity_sating_privacy_policies:

                Intent intent_privacy_policies = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/ailbaz2020/%D8%A7%D9%84%D8%B5%D9%81%D8%AD%D8%A9-%D8%A7%D9%84%D8%B1%D8%A6%D9%8A%D8%B3%D9%8A%D8%A9"));
                startActivity(intent_privacy_policies);

                break;
            case R.id.activity_sating_rating:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));


                break;

        }
    }

    //اضهارCalendar واختيار منه الوقت
    protected Dialog onCreateDialog(int id) {

        Calendar calendar = Calendar.getInstance();
        if (id == 1)
            return new TimePickerDialog(Sating.this, TimeMap, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
        return null;


    }

    protected TimePickerDialog.OnTimeSetListener TimeMap =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);
                    calendar.set(Calendar.SECOND, 0);

                    Intent alertIntent = new Intent(getApplicationContext(), AlertReceiver.class);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    //ارسال نتفكيشن يوميه
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, PendingIntent.getBroadcast(getApplicationContext(), 0, alertIntent,
                            PendingIntent.FLAG_CANCEL_CURRENT));


                }
            };

}
