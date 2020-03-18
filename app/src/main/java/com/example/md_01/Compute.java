package com.example.md_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Compute extends AppCompatActivity {

    private TextView customer_sex,customer_weight,customer_height,customer_bmi,customer_status,customer_advice;
    private Button back;
    private String flag_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        initView();
    }

    private void initView() {
        customer_sex = findViewById(R.id.customer_sex);
        customer_sex.setText(getIntent().getStringExtra("sex"));
        //身高
        customer_height = findViewById(R.id.customer_height);
        customer_height.setText(getIntent().getStringExtra("height"));
        //标准体重
        customer_weight = findViewById(R.id.customer_weight);
        customer_weight.setText(String.valueOf(getIntent().getDoubleExtra("weight",0.00)));
        //BMI
        customer_bmi = findViewById(R.id.customer_bmi);
        customer_bmi.setText(String.valueOf(getIntent().getDoubleExtra("bmi",0.00)));
        //身体状态
        customer_status = findViewById(R.id.customer_status);
        customer_status.setText(getIntent().getStringExtra("bmi_status"));
        //医生建议
        customer_advice = findViewById(R.id.customer_advice);
        customer_advice.setText(getIntent().getStringExtra("advice"));

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
