package com.blahblah.ringermode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Email_sending extends AppCompatActivity
{
    private TextInputEditText to_text,sub_text,msg_text;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sending);
        to_text = findViewById(R.id.to_text);
        sub_text = findViewById(R.id.sub_text);
        msg_text = findViewById(R.id.msg_text);
        btn_save = findViewById(R.id.button_send);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to_text.getEditableText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,new String[]{sub_text.getEditableText().toString()});
                intent.putExtra(Intent.EXTRA_TEXT,msg_text.getEditableText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose mail app"));
            }
        });
    }
}