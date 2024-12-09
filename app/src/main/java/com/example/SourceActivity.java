package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp01.R;

public class SourceActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_money_converter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void converter(View v)
    {
        //on suppose que la conversion est bien effectuée..
        double result = 20;
         Intent i = new Intent(this,
                 ResultActivity.class);
         i.putExtra("result", result);
        //navigation sans reponse:
         //startActivity(i);
         // naviagation avec reponse:
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String userName = data.getStringExtra("username");
                Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();
            }
        }
    }
}