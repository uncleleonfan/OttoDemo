package com.itheima.ottodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册到Bus
        MyBus.getInstance().register(this);
    }

    /**
     * 默认强制onEvent的方法将在主线程执行
     */
    @Subscribe
    public void onEvent(MyEvent event) {
        Toast.makeText(this, event.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册Bus
        MyBus.getInstance().unregister(this);
    }

    public void onPublishEvent(View view) {
        MyBus.getInstance().post(new MyEvent("Hello Bus"));
    }
}
