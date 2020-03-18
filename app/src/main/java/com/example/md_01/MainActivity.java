package com.example.md_01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText weight,height;
    private RadioButton radio_first;
    private String sex;
    private Button check_button;
    private double bmi;
    private double weight_standard;
    private Double weight_double,height_double;
    private String bmi_status;
    private String advice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        radio_first = findViewById(R.id.first);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        check_button = findViewById(R.id.check_button);
        check_button.setOnClickListener(this);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View v) {
        try{
            weight_double = Double.parseDouble(weight.getText().toString());
            height_double = Double.parseDouble(height.getText().toString());
            if(radio_first.isChecked()){
                sex = "男";
                weight_standard = (height_double - 80) * 0.7;
                bmi = (weight_double) / (Math.pow(height_double / 100,2));
            }else{
                sex = "女";
                weight_standard = (height_double - 70) * 0.6;
                bmi = (weight_double) / (Math.pow(height_double / 100,2));
            }
            if(bmi >= 28){
                bmi_status = "肥胖";
                advice = "控制摄入，增大消耗";
            }else if(bmi >= 24){
                bmi_status = "超重";
                advice = "控制摄入，增大消耗";
            }else if(bmi >= 18.5){
                bmi_status = "正常";
                advice = "保持";
            }else {
                bmi_status = "过轻";
                advice = "营养均衡，咨询医师。";
            }

            BigDecimal bg = new BigDecimal(weight_standard);
            double weight_stardard_two = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            BigDecimal bg2 = new BigDecimal(bmi);
            double bmi_two = bg2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

            Intent intent = new Intent(getApplicationContext(),Compute.class);
            intent.putExtra("sex",sex);
            intent.putExtra("weight",weight_stardard_two);
            intent.putExtra("height",height.getText().toString());
            intent.putExtra("bmi",bmi_two);
            intent.putExtra("advice",advice);
            intent.putExtra("bmi_status",bmi_status);
            startActivity(intent);
            weight.setText("");
            height.setText("");
        }catch (Exception ignored){
            Toast.makeText(getApplicationContext(),"请检查输入是否完全",Toast.LENGTH_SHORT).show();
        }

    }
}

