package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TranActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_2_8,bt_2_10,bt_2_16,bt_8_2,bt_8_10,bt_8_16,bt_10_2,bt_10_8,bt_10_16,bt_16_2,bt_16_8,bt_16_10,
    btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_a,btn_b,btn_c,btn_d,btn_e,btn_f;
    TextView text_input;
    boolean clear_flag; //清空标识
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran);
        bt_2_8 = (Button)findViewById(R.id.bt_2_8);
        bt_2_10 = (Button)findViewById(R.id.bt_2_10);
        bt_2_16 = (Button)findViewById(R.id.bt_2_16);
        bt_8_2 = (Button)findViewById(R.id.bt_8_2);
        bt_8_10 = (Button)findViewById(R.id.bt_8_10);
        bt_8_16 = (Button)findViewById(R.id.bt_8_16);
        bt_10_2 = (Button)findViewById(R.id.bt_10_2);
        bt_10_8 = (Button)findViewById(R.id.bt_10_8);
        bt_10_16= (Button)findViewById(R.id.bt_10_16);
        bt_16_2 = (Button)findViewById(R.id.bt_16_2);
        bt_16_8 = (Button)findViewById(R.id.bt_16_8);
        bt_16_10 = (Button)findViewById(R.id.bt_16_10);
        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_a = (Button)findViewById(R.id.btn_a);
        btn_b = (Button)findViewById(R.id.btn_b);
        btn_c = (Button)findViewById(R.id.btn_c);
        btn_d= (Button)findViewById(R.id.btn_d);
        btn_e = (Button)findViewById(R.id.btn_e);
        btn_f = (Button)findViewById(R.id.btn_f);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_f.setOnClickListener(this);
        text_input = (TextView)findViewById(R.id.textView_tran);
        bt_2_8.setOnClickListener(this);
        bt_2_10.setOnClickListener(this);
        bt_2_16.setOnClickListener(this);
        bt_8_2.setOnClickListener(this);
        bt_8_10.setOnClickListener(this);
        bt_8_16.setOnClickListener(this);
        bt_10_2.setOnClickListener(this);
        bt_10_8.setOnClickListener(this);
        bt_10_16.setOnClickListener(this);
        bt_16_2.setOnClickListener(this);
        bt_16_10.setOnClickListener(this);
        bt_16_10.setOnClickListener(this);

    }
    public void onClick(View v) {
        String str = text_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_a:
            case R.id.btn_b:
            case R.id.btn_c:
            case R.id.btn_d:
            case R.id.btn_e:
            case R.id.btn_f:
                if(clear_flag){
                    clear_flag=false;
                    str = "";
                    text_input.setText("");
                }
                text_input.setText(str+((Button)v).getText());
                break;
            case R.id.bt_2_8:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toOctalString(Integer.parseInt(str, 2)) );break;
            case R.id.bt_2_10:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.valueOf(str,2).toString() );break;
            case R.id.bt_2_16:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toHexString(Integer.parseInt(str, 2)) );break;
            case R.id.bt_8_2:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toBinaryString(Integer.valueOf(str,8)));break;
            case R.id.bt_8_10:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.valueOf(str,8).toString() );break;
            case R.id.bt_8_16:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toHexString(Integer.valueOf(str,8)));break;
            case R.id.bt_10_2:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toBinaryString(Integer.parseInt(str)) );break;
                case R.id.bt_10_8:
                text_input.setText( Integer.toOctalString(Integer.parseInt(str)) );break;
            case R.id.bt_10_16:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText(Integer.toHexString(Integer.parseInt(str)) );break;
            case R.id.bt_16_2:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.toBinaryString(Integer.valueOf(str,16)) );break;
            case R.id.bt_16_8:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText(  Integer.toOctalString(Integer.valueOf(str,16)) );break;
            case R.id.bt_16_10:
                if(clear_flag){
                    clear_flag = false;
                    return;
                }
                clear_flag = true;
                text_input.setText( Integer.valueOf(str,16).toString() );break;



        }

    }





}