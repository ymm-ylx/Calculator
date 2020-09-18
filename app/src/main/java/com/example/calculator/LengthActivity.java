package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class LengthActivity extends AppCompatActivity implements View.OnClickListener {
    Button bu_0, bu_1, bu_2, bu_3, bu_4, bu_5, bu_6, bu_7, bu_8, bu_9, bu_point, bu_mm, bu_cm, bu_dm, bu_m, bu_km, bu_cul, bu_del, bu_clean;
    TextView text_input;
    boolean clear_flag; //清空标识
    private Spinner mspinner;
    private String zhye;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        bu_0 = (Button) findViewById(R.id.bu_0);
        bu_1 = (Button) findViewById(R.id.bu_1);
        bu_2 = (Button) findViewById(R.id.bu_2);
        bu_3 = (Button) findViewById(R.id.bu_3);
        bu_4 = (Button) findViewById(R.id.bu_4);
        bu_5 = (Button) findViewById(R.id.bu_5);
        bu_6 = (Button) findViewById(R.id.bu_6);
        bu_7 = (Button) findViewById(R.id.bu_7);
        bu_8 = (Button) findViewById(R.id.bu_8);
        bu_9 = (Button) findViewById(R.id.bu_9);
        bu_del = (Button) findViewById(R.id.bu_del);
        bu_clean = (Button) findViewById(R.id.bu_clean);
        bu_point = (Button) findViewById(R.id.bu_point);
        bu_mm = (Button) findViewById(R.id.bu_mm);
        bu_cm = (Button) findViewById(R.id.bu_cm);
        bu_dm = (Button) findViewById(R.id.bu_dm);
        bu_m = (Button) findViewById(R.id.bu_m);
        bu_km = (Button) findViewById(R.id.bu_km);
        bu_cul = (Button) findViewById(R.id.bu_cul);
        text_input = (TextView) findViewById(R.id.textView_length);
        bu_0.setOnClickListener(this);
        bu_1.setOnClickListener(this);
        bu_2.setOnClickListener(this);
        bu_3.setOnClickListener(this);
        bu_4.setOnClickListener(this);
        bu_5.setOnClickListener(this);
        bu_6.setOnClickListener(this);
        bu_7.setOnClickListener(this);
        bu_8.setOnClickListener(this);
        bu_9.setOnClickListener(this);
        bu_del.setOnClickListener(this);
        bu_clean.setOnClickListener(this);
        bu_mm.setOnClickListener(this);
        bu_cm.setOnClickListener(this);
        bu_dm.setOnClickListener(this);
        bu_m.setOnClickListener(this);
        bu_km.setOnClickListener(this);
        bu_point.setOnClickListener(this);
        bu_cul.setOnClickListener(this);


        String[] ctype = new String[]{"毫米", "厘米", "分米", "米", "千米"};
        //创建一个数组适配器
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        mspinner = findViewById(R.id.spinner);
        mspinner.setAdapter(adapter);
//条目点击事件
        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private String positions;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positions = adapter.getItem(position);
                if (positions.equals("毫米")) {
                    zhye = 2 + "";

                    //Toast.makeText(LengthActivity.this, "全部", Toast.LENGTH_SHORT).show();
                } else if (positions.equals("厘米")) {
                    zhye = 3 + "";
                    //Toast.makeText(LengthActivity.this, "游戏", Toast.LENGTH_SHORT).show();

                } else if (positions.equals("分米")) {
                    zhye = 4 + "";
                    //Toast.makeText(LengthActivity.this, "电影", Toast.LENGTH_SHORT).show();

                } else if (positions.equals("米")) {
                    zhye = 5 + "";
                    //Toast.makeText(LengthActivity.this, "娱乐", Toast.LENGTH_SHORT).show();

                } else if (positions.equals("千米")) {
                    zhye = 6 + "";
                    //Toast.makeText(LengthActivity.this, "图书", Toast.LENGTH_SHORT).show();

                }
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }


        });

    }

    @Override
    public void onClick(View v) {
        String str = text_input.getText().toString();
        switch (v.getId()) {
            case R.id.bu_0:
            case R.id.bu_1:
            case R.id.bu_2:
            case R.id.bu_3:
            case R.id.bu_4:
            case R.id.bu_5:
            case R.id.bu_6:
            case R.id.bu_7:
            case R.id.bu_8:
            case R.id.bu_9:
            case R.id.bu_point:
            case R.id.bu_mm:
            case R.id.bu_dm:
            case R.id.bu_km:
            case R.id.bu_cm:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text_input.setText("");
                }
                text_input.setText(str + ((Button) v).getText());
                break;
            case R.id.bu_m:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text_input.setText("");
                }
                text_input.setText(str + ((Button) v).getText()+" ");
                break;
            case R.id.bu_del:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text_input.setText("");
                } else if (str != null && !str.equals("")) {
                    text_input.setText(str.substring(0, str.length() - 1));
                }
                break;

            case R.id.bu_clean:
                clear_flag = false;
                str = "";
                text_input.setText("");
                break;

            case R.id.bu_cul:
                getResult();
                break;

        }

    }

    private void getResult() {
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        String exp = text_input.getText().toString();
        String mm=exp.substring(0,exp.length()-2);
        float num = Float.parseFloat(mm);
        switch (zhye) {
            case "2":
                /*
                Toast.makeText(LengthActivity.this, "全部", Toast.LENGTH_SHORT).show();
                String exp = text_input.getText().toString();
                String mm=exp.substring(0,exp.length()-2);
                text_input.setText(mm);
                */
                //text_input.setText(Float.toString(num*10)+"厘米");
                if(exp.substring(exp.length()-2,exp.length()).equals("毫米"))
                    text_input.setText(exp);
                else if(exp.substring(exp.length()-2,exp.length()).equals("厘米"))
                    text_input.setText(Float.toString(num*10)+"毫米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("分米"))
                    text_input.setText(Float.toString(num*100)+"毫米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("米 "))
                    text_input.setText(Float.toString(num*1000)+"毫米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("千米"))
                    text_input.setText(Float.toString(num*1000000)+"毫米");
                break;

                //char[]  mm= exp.toCharArray();
                //char[] mm_1= Arrays.copyOfRange(mm, 0, mm.length-3);
            case "3":
                if(exp.substring(exp.length()-2,exp.length()).equals("毫米"))
                    text_input.setText(Float.toString(num/10)+"厘米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("厘米"))
                    text_input.setText(exp);
                else if(exp.substring(exp.length()-2,exp.length()).equals("分米"))
                    text_input.setText(Float.toString(num*10)+"厘米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("米 "))
                    text_input.setText(Float.toString(num*100)+"厘米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("千米"))
                    text_input.setText(Float.toString(num*100000)+"厘米");
                break;
            case "4":
                if(exp.substring(exp.length()-2,exp.length()).equals("毫米"))
                    text_input.setText(Float.toString(num/100)+"分米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("厘米"))
                    text_input.setText(Float.toString(num/10)+"分米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("分米"))
                    text_input.setText(exp);
                else if(exp.substring(exp.length()-2,exp.length()).equals("米 "))
                    text_input.setText(Float.toString(num*10)+"分米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("千米"))
                    text_input.setText(Float.toString(num*10000)+"分米");
                break;
            case "5":
                if(exp.substring(exp.length()-2,exp.length()).equals("毫米"))
                    text_input.setText(Float.toString(num/1000)+"米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("厘米"))
                    text_input.setText(Float.toString(num/100)+"米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("分米"))
                    text_input.setText(Float.toString(num/10)+"米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("米 "))
                    text_input.setText(exp);
                else if(exp.substring(exp.length()-2,exp.length()).equals("千米"))
                    text_input.setText(Float.toString(num*1000)+"米");
                break;
            case "6":
                if(exp.substring(exp.length()-2,exp.length()).equals("毫米"))
                    text_input.setText(Float.toString(num/10000000)+"千米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("厘米"))
                    text_input.setText(Float.toString(num/1000000)+"千米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("分米"))
                    text_input.setText(Float.toString(num/100000)+"千米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("米 "))
                    text_input.setText(Float.toString(num/1000)+"千米");
                else if(exp.substring(exp.length()-2,exp.length()).equals("千米"))
                    text_input.setText(exp);
                break;

        }
    }

}