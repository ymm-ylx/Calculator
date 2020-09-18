package com.example.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Jupiter on 2016/10/6.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_0,bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_multiply,bt_divide,bt_add,bt_minus,bt_point,bt_del,bt_equal,bt_clean,bt_left,bt_right,bt_pow;
    TextView text_input;
    boolean clear_flag; //清空标识

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.caidan,menu);
        return true;
    }

    //定义菜单响应事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.tran_item:
                Intent intent_tran=
                        new Intent(MainActivity.this,TranActivity.class);
                startActivity(intent_tran);
                break;
            case R.id.three_item:
                Intent intent_three=
                        new Intent(MainActivity.this,ThreeActivity.class);
                startActivity(intent_three);
                break;
            case R.id.length_item:
                Intent intent_length=
                        new Intent(MainActivity.this,LengthActivity.class);
                startActivity(intent_length);
                break;
            case R.id.help_item:
                Toast.makeText(this,"这是帮助",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                try {
                    System.exit(0);
                } catch (Exception e) {
                }
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        bt_0 = (Button)findViewById(R.id.bt_0);
        bt_1 = (Button)findViewById(R.id.bt_1);
        bt_2 = (Button)findViewById(R.id.bt_2);
        bt_3 = (Button)findViewById(R.id.bt_3);
        bt_4 = (Button)findViewById(R.id.bt_4);
        bt_5 = (Button)findViewById(R.id.bt_5);
        bt_6 = (Button)findViewById(R.id.bt_6);
        bt_7 = (Button)findViewById(R.id.bt_7);
        bt_8 = (Button)findViewById(R.id.bt_8);
        bt_9 = (Button)findViewById(R.id.bt_9);
        bt_multiply = (Button)findViewById(R.id.bt_multiply);
        bt_divide = (Button)findViewById(R.id.bt_divide);
        bt_add = (Button)findViewById(R.id.bt_add);
        bt_minus = (Button)findViewById(R.id.bt_minus);
        bt_point = (Button)findViewById(R.id.bt_point);
        bt_del = (Button)findViewById(R.id.bt_del);
        bt_equal = (Button)findViewById(R.id.bt_equal);
        bt_clean = (Button)findViewById(R.id.bt_clean);
        bt_left = (Button)findViewById(R.id.bt_left);
        bt_right = (Button)findViewById(R.id.bt_right);
        bt_pow = (Button)findViewById(R.id.bt_pow);

        text_input = (TextView)findViewById(R.id.textView);

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_point.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_clean.setOnClickListener(this);
        bt_left.setOnClickListener(this);
        bt_right.setOnClickListener(this);
        bt_pow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = text_input.getText().toString();
        switch (v.getId()){
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_point:
            case R.id.bt_left:
            case R.id.bt_right:
                if(clear_flag){
                    clear_flag=false;
                    str = "";
                    text_input.setText("");
                }
                text_input.setText(str+((Button)v).getText());
                break;

            case R.id.bt_add:
            case R.id.bt_minus:
            case R.id.bt_multiply:
            case R.id.bt_pow:
            case R.id.bt_divide:
                if(clear_flag){
                    clear_flag=false;
                    text_input.setText("");
                }
                text_input.setText(str+((Button)v).getText());
                break;

            case R.id.bt_del:
                if(clear_flag){
                    clear_flag=false;
                    str = "";
                    text_input.setText("");
                }else if(str != null && !str.equals("")){
                    text_input.setText(str.substring(0,str.length()-1));
                }
                break;

            case R.id.bt_clean:
                clear_flag=false;
                str = "";
                text_input.setText("");
                break;

            case R.id.bt_equal:
                getResult();
                break;
        }
    }
    //运算结果
    private void getResult(){

        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        String exp = text_input.getText().toString();

        String s = exp;
        Calculate c = new Calculate();
        StringBuilder RPN = new StringBuilder();
        float temp = c.calculate(s, RPN);
        text_input.setText(Float.toString(temp));
    }
}