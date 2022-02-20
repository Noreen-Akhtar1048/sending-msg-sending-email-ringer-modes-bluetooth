package com.blahblah.ringermode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Message_SENDING extends AppCompatActivity
{
    TextInputEditText mobile_text,message_text;
    Button Save;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_sending);
        mobile_text = findViewById(R.id.mobile_text);
        message_text = findViewById(R.id.message_text);
        Save = findViewById(R.id.btn_send);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("smsto:"));
                    intent.setType("vnd.android-dir/mms-sms");
                    intent.putExtra("address",new String(mobile_text.getEditableText().toString()));
                    intent.putExtra("sms-body",message_text.getEditableText().toString());
                    startActivity(Intent.createChooser(intent,"Send sms via: "));
//                    smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(mobile_text.getEditableText().toString(),null,message_text.getEditableText().toString(),null,null);
                    Toast.makeText(getApplicationContext(),"SMS sent successfully",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"SMS Failed to send ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}