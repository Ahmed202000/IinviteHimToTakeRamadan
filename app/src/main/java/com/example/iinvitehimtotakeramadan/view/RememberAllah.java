package com.example.iinvitehimtotakeramadan.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iinvitehimtotakeramadan.R;

public class RememberAllah extends AppCompatActivity {

    private int mCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_allah);


        final TextView txtCount=findViewById(R.id.txtCount);

        Button btnCount=findViewById(R.id.btnCount);
        ImageView imgClear=findViewById(R.id.imgClear);

        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtCount.setText("0");

            }
        });



        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//
//                if(l2 >= l1) {
//                    insertactone.setBackgroundColor(Color.RED);
//                    vibe.vibrate(100);

 //               MediaPlayer mediaPlayer= MediaPlayer.create(RememberAllah.this,R.raw.duaa);
 //               mediaPlayer.start();
                mCount ++;
                txtCount.setText(Integer.toString(mCount));
            }
        });
    }

}

