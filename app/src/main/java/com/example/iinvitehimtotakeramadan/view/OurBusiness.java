package com.example.iinvitehimtotakeramadan.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iinvitehimtotakeramadan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OurBusiness extends AppCompatActivity {

    @BindView(R.id.activity_our_business_app_albaze_wep_sit)
    TextView activityOurBusinessAppAlbazeWepSit;
    @BindView(R.id.activity_our_business_app_albaze_provider)
    TextView activityOurBusinessAppAlbazeProvider;
    @BindView(R.id.activity_our_business_app_albaze_user)
    TextView activityOurBusinessAppAlbazeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_business);
        ButterKnife.bind(this);



        /////////////
    }

    @OnClick({R.id.activity_our_business_app_albaze_wep_sit, R.id.activity_our_business_app_albaze_provider, R.id.activity_our_business_app_albaze_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_our_business_app_albaze_wep_sit:
                Intent intent_wep_sit=new Intent(Intent.ACTION_VIEW, Uri.parse("https://ail-baz.com/"));
                startActivity(intent_wep_sit);

                break;
            case R.id.activity_our_business_app_albaze_provider:
                Intent intent_provider=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.albaz.provider"));
                startActivity(intent_provider);

                break;
            case R.id.activity_our_business_app_albaze_user:
                Intent intent_user=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.albazz.appuser"));
                startActivity(intent_user);
                break;
        }
    }
}
