package com.example.nick_pc.magic8ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Magic8BallCore m_core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //подключение ядра приложения
        m_core = new Magic8BallCore(this);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    protected void onResume() {
        super.onResume();

        m_core.NotifyResume();
    }

    protected void onPause() {
        super.onPause();

        m_core.NotifyPause();
    }
}
