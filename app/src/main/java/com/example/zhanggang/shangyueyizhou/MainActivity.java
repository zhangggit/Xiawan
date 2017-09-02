package com.example.zhanggang.shangyueyizhou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyView.onClickLener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView myview = (MyView) findViewById(R.id.myview);
        myview.setOnClickLener(this);

    }

    @Override
    public void getBack(View view) {
        Toast.makeText(this, "点击了返回", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMore(View view) {
        Toast.makeText(this, "点击了更多", Toast.LENGTH_SHORT).show();
    }
}
