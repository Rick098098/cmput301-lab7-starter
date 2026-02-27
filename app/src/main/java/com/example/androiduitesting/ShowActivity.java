package com.example.androiduitesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView tv=findViewById(R.id.text_city_name);
        Button back=findViewById(R.id.button_back);
        String name=getIntent().getStringExtra("city_name");
        if (name==null) name="";
        tv.setText(name);
        //tv.setText(??);
        back.setOnClickListener(v -> finish()); // 回到 MainActivity
    }
}