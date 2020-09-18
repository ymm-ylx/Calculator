package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity implements View.OnClickListener{

    Button b_0,b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_sin,b_cos,b_tan,b_point;
    TextView text_input;
    boolean clear_flag; //清空标识
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        b_0 = (Button)findViewById(R.id.b_0);
        b_1 = (Button)findViewById(R.id.b_1);
        b_2 = (Button)findViewById(R.id.b_2);
        b_3 = (Button)findViewById(R.id.b_3);
        b_4 = (Button)findViewById(R.id.b_4);
        b_5 = (Button)findViewById(R.id.b_5);
        b_6 = (Button)findViewById(R.id.b_6);
        b_7 = (Button)findViewById(R.id.b_7);
        b_8 = (Button)findViewById(R.id.b_8);
        b_9 = (Button)findViewById(R.id.b_9);
        b_sin = (Button)findViewById(R.id.b_sin);
        b_cos = (Button)findViewById(R.id.b_cos);
        b_tan = (Button)findViewById(R.id.b_tan);
        b_point = (Button)findViewById(R.id.b_point);

        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);
        b_sin.setOnClickListener(this);
        b_cos.setOnClickListener(this);
        b_tan.setOnClickListener(this);
        b_point.setOnClickListener(this);
        text_input = (TextView)findViewById(R.id.textView_three);


    }
    public void onClick(View v) {
        String str = text_input.getText().toString();
        switch (v.getId()) {
            case R.id.b_0:
            case R.id.b_1:
            case R.id.b_2:
            case R.id.b_3:
            case R.id.b_4:
            case R.id.b_5:
            case R.id.b_6:
            case R.id.b_7:
            case R.id.b_8:
            case R.id.b_9:
            case R.id.b_point:
                if(clear_flag){
                    clear_flag=false;
                    str = "";
                    text_input.setText("");
                }
                text_input.setText(str+((Button)v).getText());
                break;
            case R.id.b_sin:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                String s_sin=""+Math.sin(Math.toRadians(Double.parseDouble(str)));
                text_input.setText("正弦值为"+s_sin);break;
            case R.id.b_cos:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                String s_cos=""+Math.cos(Math.toRadians(Double.parseDouble(str)));
                text_input.setText("余弦值为"+s_cos);break;
            case R.id.b_tan:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                String s_tan=""+Math.tan(Math.toRadians(Double.parseDouble(str)));
                text_input.setText("正切值为"+s_tan);break;

        }

    }
}