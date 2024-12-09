package com.example;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp01.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 120;
    private static final int MY_PERMISSIONS_REQUEST_SET_ALARM = 125;
    TextView result_target_lab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //get the value convert result:
        //get the current intent:
        Intent i = getIntent();
        // get the result value:
        double value = i.getDoubleExtra("result",0);
        result_target_lab = findViewById(R.id.result_tagert_lab);
        result_target_lab.setText(value+"");
    }
    public void returnResult(View v)
    {
        //create an intent without parameters:
        Intent i = new Intent();
        //put data into intent:
        i.putExtra("username", "Omar");
        // lauch actiivty source;
        setResult(RESULT_OK,i);//current activity has a result.
        // terminate the current activity:
        finish();
    }

    public void call(View v)
    {
        ActivityCompat.requestPermissions(ResultActivity.this,
                new String[]{Manifest.permission.CALL_PHONE},
                MY_PERMISSIONS_REQUEST_CALL_PHONE);
        Intent i =new Intent();
        i.setAction(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + "92053433"));
       startActivity(i);

    }
    public void sendSMS(View V)
    {
        ActivityCompat.requestPermissions(ResultActivity.this,
                new String[]{Manifest.permission.SEND_SMS},
                MY_PERMISSIONS_REQUEST_SEND_SMS);
        Intent i =new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setData(Uri.parse("tel:" + "92053433"));
        i.putExtra(Intent.EXTRA_TEXT,"hello");
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
            Toast.makeText(this, "sms envoyé", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "sms non envoyé!!", Toast.LENGTH_SHORT).show();
    }
    public void createAlarm(View V) {
        ActivityCompat.requestPermissions(ResultActivity.this,
                new String[]{Manifest.permission.SET_ALARM},
                MY_PERMISSIONS_REQUEST_SET_ALARM);
        ArrayList days = new ArrayList();
    days.add(Calendar.MONDAY);days.add(Calendar.THURSDAY);
        days.add(Calendar.WEDNESDAY);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                .putExtra(AlarmClock.EXTRA_HOUR, 15)
                .putExtra(AlarmClock.EXTRA_MINUTES, 57).
                putExtra(AlarmClock.EXTRA_DAYS,days).
                putExtra(AlarmClock.EXTRA_VIBRATE,true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(this, "alarm created!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else {
           // Toast.makeText(this, "alarm non crée!", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setMessage("erreur");
            msg.show();
        }



    }
    public void sendSMS2(View V)
    {
        ActivityCompat.requestPermissions(ResultActivity.this,
                new String[]{Manifest.permission.SEND_SMS},
                MY_PERMISSIONS_REQUEST_SEND_SMS);
        Intent i =new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setData(Uri.parse("tel:" + "26260995"));
        i.putExtra(Intent.EXTRA_TEXT,"hi");
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
            Toast.makeText(this, "sms envoyé", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "sms non envoyé!!", Toast.LENGTH_SHORT).show();
    }

    public void setalarme(View V) {
        ActivityCompat.requestPermissions(ResultActivity.this,
                new String[]{Manifest.permission.SET_ALARM},
                MY_PERMISSIONS_REQUEST_SET_ALARM);
        ArrayList days = new ArrayList();

}
}