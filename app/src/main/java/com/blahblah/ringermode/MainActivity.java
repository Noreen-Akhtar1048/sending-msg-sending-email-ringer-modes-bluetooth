package com.blahblah.ringermode;

import static com.blahblah.ringermode.R.color.white;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    AudioManager audioManager;
    Button btn_silent, btn_vibrate, btn_ringing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ringing = findViewById(R.id.button3);
        btn_vibrate = findViewById(R.id.button2);
        btn_silent = findViewById(R.id.button1);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int current_mode = audioManager.getRingerMode();
        if(current_mode == AudioManager.RINGER_MODE_NORMAL)
            btn_ringing.setBackgroundResource(white);
        else if(current_mode == AudioManager.RINGER_MODE_SILENT)
            btn_silent.setBackgroundResource(white);
        else if(current_mode == AudioManager.RINGER_MODE_VIBRATE)
            btn_vibrate.setBackgroundResource(white);

        btn_silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(getApplicationContext(),"Silent mode is activated",Toast.LENGTH_LONG).show();
                btn_silent.setBackgroundResource(white);
                btn_vibrate.setBackgroundResource(R.color.purple_500);
                btn_ringing.setBackgroundResource(R.color.purple_500);
            }
        });
        btn_vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(getApplicationContext(),"Vibration mode is activated",Toast.LENGTH_LONG).show();
                btn_silent.setBackgroundResource(R.color.purple_500);
                btn_vibrate.setBackgroundResource(white);
                btn_ringing.setBackgroundResource(R.color.purple_500);
            }
        });
        btn_ringing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(getApplicationContext(),"Ringing mode is activated",Toast.LENGTH_LONG).show();
                btn_silent.setBackgroundResource(R.color.purple_500);
                btn_vibrate.setBackgroundResource(R.color.purple_500);
                btn_ringing.setBackgroundResource(white);
            }
        });
    }
}