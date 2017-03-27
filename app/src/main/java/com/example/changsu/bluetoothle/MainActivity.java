package com.example.changsu.bluetoothle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Button mBtnScan;
    Button mBtnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnScan = (Button)findViewById(R.id.btn_scan);
        mBtnScan.setOnClickListener(mClickListener);

        mBtnMap = (Button)findViewById(R.id.btn_map);
        mBtnMap.setOnClickListener(mClickListener);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    Button.OnClickListener mClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.btn_scan:
                    startActivity(new Intent(MainActivity.this, BleDeviceScanActivity.class));
                    finish();
                    break;
                case R.id.btn_map:
                    startActivity(new Intent(MainActivity.this, MapActivity.class));
                    finish();
                    break;

                default:
                    break;
            }
        }
    };
}
