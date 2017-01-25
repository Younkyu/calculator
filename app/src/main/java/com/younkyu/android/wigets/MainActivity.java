package com.younkyu.android.wigets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btngg;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //2. findViewByid 로 뷰 세팅
        btngg = (Button) findViewById(R.id.btnGGrid);
        btn5 = (Button) findViewById(R.id.button5);




        //3. 버튼에 onClickListener 달기
        btngg.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnGGrid:
                // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
                // Intent를 통해서 로드할 컴포넌트를 지정해야 한다.
                intent = new Intent(this, GridActivity.class);
                // ^ 대상이 되는 컴포넌트
                startActivity(intent);
                break;
            case R.id.button5:
                // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
                // Intent를 통해서 로드할 컴포넌트를 지정해야 한다.
                intent = new Intent(this, CalculatorActivity.class);
                // ^ 대상이 되는 컴포넌트
                startActivity(intent);
                break;
        }
    }

}