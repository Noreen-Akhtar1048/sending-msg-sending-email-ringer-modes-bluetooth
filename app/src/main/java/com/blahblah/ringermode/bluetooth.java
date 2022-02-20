package com.blahblah.ringermode;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bluetooth extends AppCompatActivity
{
    private static final int REQUEST_ENABLED_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        final Button btn_on = findViewById(R.id.button_on);
        final Button btn_off = findViewById(R.id.button_off);
        final Button btn_dis = findViewById(R.id.button_dis);
        final TextView textView = findViewById(R.id.textView);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            textView.append("Device not supported");
        }
        btn_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bluetoothAdapter.isEnabled()){
                    Intent enabled = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    enabled.putExtra(BluetoothAdapter.ACTION_REQUEST_ENABLE,REQUEST_ENABLED_BT);
                    startActivity(enabled);
                }
            }
        });
        btn_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bluetoothAdapter.isDiscovering()){
                    Toast.makeText(getApplicationContext(),"Making your device discoverable",Toast.LENGTH_LONG).show();
                    Intent enabled = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    enabled.putExtra(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE,REQUEST_DISCOVERABLE_BT);
                    startActivity(enabled);
                }
            }
        });
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(),"Turning off bluetooth",Toast.LENGTH_LONG).show();
            }
        });
    }
}