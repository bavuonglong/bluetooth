package com.codeko.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (bluetoothAdapter.isEnabled()) {

        } else {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(intent);

            if (bluetoothAdapter.isEnabled()) {

            }
        }
    }

    public void turnBluetoothOff(View view) {
        bluetoothAdapter.disable();
    }

    public void findDiscoverableDevices(View view) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(intent);
    }

    public void viewPairedDevices(View view) {
        Set pairedDevices = bluetoothAdapter.getBondedDevices();
        ListView listView = findViewById(R.id.lvPairedDevices);

        List list = Arrays.asList(pairedDevices);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , list);
    }
}
