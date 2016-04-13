package com.example.nick_pc.magic8ball;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class EventHandlers
        implements SensorEventListener, View.OnClickListener
{
    private static final int SHAKE_THRESHOLD = 800;

    private      float last_x;
    private      float last_y;
    private      float last_z;

    private      long lastUpdate;
    private      long lastVibe;

    private Magic8BallCore m_core;

    public EventHandlers(Magic8BallCore core)
    {
        if (core == null)
        {
            throw new IllegalArgumentException("core");
        }

        m_core = core;
    }
    // обработчик событий аксселерометра
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                float currVal = x + y + z;
                currVal = currVal - last_x - last_y - last_z;
                float speed = Math.abs(currVal) / diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    m_core.DisplayAnswer();
                }

                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Nothing to do
    }

    @Override
    public void onClick(View view) {
        m_core.DisplayAnswer();
    }
}
