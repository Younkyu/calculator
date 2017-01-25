package com.younkyu.android.wigets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnplus;
    Button btnminus;
    Button btnx;
    Button btncancel;
    Button btn0;
    Button btnrun;
    Button btnslash;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    TextView result;
    TextView preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claculator);

        result = (TextView) findViewById(R.id.result);
        preview = (TextView) findViewById(R.id.PreView);


        btnplus = (Button) findViewById(R.id.btnplus);
        btnplus.setOnClickListener(this);
        btnminus = (Button) findViewById(R.id.btnminus);
        btnminus.setOnClickListener(this);
        btnx = (Button) findViewById(R.id.btnx);
        btnx.setOnClickListener(this);
        btncancel = (Button) findViewById(R.id.btncancle);
        btncancel.setOnClickListener(this);
        btnslash = (Button) findViewById(R.id.btnslash);
        btnslash.setOnClickListener(this);
        btnrun = (Button) findViewById(R.id.btnrun);
        btnrun.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn0:
                preview.setText(preview.getText() + "0");
                break;
            case R.id.btn1:
                preview.setText(preview.getText() + "1");
                break;
            case R.id.btn2:
                preview.setText(preview.getText() + "2");
                break;
            case R.id.btn3:
                preview.setText(preview.getText() + "3");
                break;
            case R.id.btn4:
                preview.setText(preview.getText() + "4");
                break;
            case R.id.btn5:
                preview.setText(preview.getText() + "5");
                break;
            case R.id.btn6:
                preview.setText(preview.getText() + "6");
                break;
            case R.id.btn7:
                preview.setText(preview.getText() + "7");
                break;
            case R.id.btn8:
                preview.setText(preview.getText() + "8");
                break;
            case R.id.btn9:
                preview.setText(preview.getText() + "9");
                break;
            case R.id.btnplus:
                preview.setText(preview.getText() + "+");
                break;
            case R.id.btnminus:
                preview.setText(preview.getText() + "-");
                break;
            case R.id.btnx:
                preview.setText(preview.getText() + "*");
                break;
            case R.id.btnslash:
                preview.setText(preview.getText() + "/");
                break;
            case R.id.btncancle:
                preview.setText("preview:");
                result.setText("Result:");
                break;

            case R.id.btnrun:
                preview.setText(preview.getText() + "=");
                double results = 0;
                String ddap = String.valueOf(preview.getText());
                ddap = ddap.replace("preview:", "");
                ArrayList<String> wow = new ArrayList<>();

                for (int i = 0; i < ddap.length(); i++) {
                    if (ddap.substring(i, i + 1).equals("*")) {
                        wow.add(ddap.substring(0, i));
                        ddap = ddap.substring(i, ddap.length());
                        i = 0;
                    } else if (ddap.substring(i, i + 1).equals("/")) {
                        wow.add(ddap.substring(0, i));
                        ddap = ddap.substring(i, ddap.length());
                        i = 0;
                    } else if (ddap.substring(i, i + 1).equals("-")) {
                        wow.add(ddap.substring(0, i));
                        ddap = ddap.substring(i, ddap.length());
                        i = 0;
                    } else if (ddap.substring(i, i + 1).equals("+")) {
                        wow.add(ddap.substring(0, i));
                        ddap = ddap.substring(i, ddap.length());
                        i = 0;
                    } else if (ddap.substring(i, i + 1).equals("=")) {
                        wow.add(ddap.substring(0, i));
                        ddap = ddap.substring(i, ddap.length());
                        wow.add("=");
                        break;
                    }
                }
                int i = 1;

                wow.set(0, "+" + wow.get(0));
                Double hoo = 0.0;
                while (i < wow.size()) {
                    String how = wow.get(i);
                    String hew = how.substring(0, 1);
                    String her = how.substring(1, wow.get(i).length());
                    if (hew.equals("*")) {
                        hoo = (Double.parseDouble(wow.get(i - 1).substring(1, wow.get(i - 1).length()))) * (Double.parseDouble(her));
                        wow.set(i - 1, wow.get(i - 1).substring(0, 1) + hoo);
                        wow.remove(i);
                        i--;

                    } else if (hew.equals("/")) {
                        hoo = (Double.parseDouble(wow.get(i - 1).substring(1, wow.get(i - 1).length()))) / (Double.parseDouble(her));
                        wow.set(i - 1, wow.get(i - 1).substring(0, 1) + hoo);
                        wow.remove(i);
                        i--;
                    }

                    i++;
                }

                i = 1;
                hoo = 0.0;
                while (i < wow.size()) {
                    String how = wow.get(i);
                    String hew = how.substring(0, 1);
                    String her = how.substring(1, wow.get(i).length());
                    if (hew.equals("+")) {
                        hoo = (Double.parseDouble(wow.get(i - 1).substring(1, wow.get(i - 1).length()))) + (Double.parseDouble(her));
                        wow.set(i - 1, wow.get(i - 1).substring(0, 1) + hoo);
                        wow.remove(i);
                        i--;

                    } else if (hew.equals("-")) {
                        hoo = (Double.parseDouble(wow.get(i - 1).substring(1, wow.get(i - 1).length()))) - (Double.parseDouble(her));
                        wow.set(i - 1, wow.get(i - 1).substring(0, 1) + hoo);
                        wow.remove(i);
                        i--;
                    }

                    i++;
                }

                wow.set(0, wow.get(0).substring(1,wow.get(0).length()));
                result.setText("Result+:"+ wow.get(0));
        }
    }
}
