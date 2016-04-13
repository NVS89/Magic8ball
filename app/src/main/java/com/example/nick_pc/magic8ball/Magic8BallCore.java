package com.example.nick_pc.magic8ball;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.EventLog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nick_pc.magic8ball.Languages.AnswersBase;

import java.util.Random;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class Magic8BallCore {
    //константы
    private static final int VIBRATE_INTERVAL = 200;
    private static final int SLEEP_RESET_INTERVAL = 1500;
    //переменные вибрации, акселерометра, сенсора
    private Vibrator m_vibrator;
    private SensorManager m_sensorManager;
    private Sensor m_accelerometer;
    // переменные вида фона, ответов
    private RelativeLayout m_answerLayout;
    private RelativeLayout m_mainLayout;
    //Мейн активити, обработчик событий
    private Activity m_activity;
    private EventHandlers m_handlers;

    private long lastShow;
    private static long m_pausedAt;
    // текстовые поля
    private TextView m_textView1;
    private TextView m_textView2;
    private TextView m_textView3;
    // база ответов(фраз), фраза за умолчанием
    private AnswersBase m_answers;
    private static int m_currentAnswer = 0;
    //конструктор класса
    public Magic8BallCore (Activity activity){
        if(activity == null){
            throw new IllegalArgumentException("activity");
        }
        m_activity = activity;
        m_vibrator = (Vibrator)activity.getSystemService(Context.VIBRATOR_SERVICE);
        m_sensorManager = (SensorManager)activity.getSystemService(Context.SENSOR_SERVICE);
        m_accelerometer = m_sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        m_handlers = new EventHandlers(this);

        m_answerLayout = (RelativeLayout)m_activity.findViewById(R.id.answerLayout);
        m_mainLayout = (RelativeLayout)m_activity.findViewById(R.id.mainLayout);

        AnswersBroker answersBroker = new AnswersBroker();
        m_answers = answersBroker.GetAnswers();

        m_activity.findViewById(R.id.answerImage).setOnClickListener(m_handlers);
        m_sensorManager.registerListener(m_handlers, m_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        m_textView1 = (TextView)m_activity.findViewById(R.id.textView1);
        m_textView2 = (TextView)m_activity.findViewById(R.id.textView2);
        m_textView3 = (TextView)m_activity.findViewById(R.id.textView3);

        InitializeAnswerView(0);
    }

    public void  NotifyResume(){
        m_sensorManager.registerListener(m_handlers,m_accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    if((System.currentTimeMillis()- m_pausedAt)>SLEEP_RESET_INTERVAL){
        InitializeAnswerView(0);
    }
        else {
        InitializeAnswerView(m_currentAnswer);
    }
    }
    public void NotifyPause(){
        m_sensorManager.unregisterListener(m_handlers);
        m_pausedAt = System.currentTimeMillis();
    }
    private int GetImageRandomNumber()
    {
        Random generator = new Random();
        int result = generator.nextInt(m_answers.Count() - 1) + 1;

        return result;
    }

    private static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    //инициализатор ответов
    public void InitializeAnswerView(int id)
    {
        AnswerPhrase answer = m_answers.GetAnswer(id);

        m_textView1.setText(answer.get_line1());
        m_textView2.setText(answer.get_line2());
        m_textView3.setText(answer.get_line3());
    }

    public void DisplayAnswer()
    {
        long curTime = System.currentTimeMillis();
        if ((curTime - lastShow) < 1500)
        {
            return;
        }

        lastShow = curTime;

        Animation mainLayoutAnimation = AnimationUtils.loadAnimation(m_activity, R.anim.translate);
        m_mainLayout.startAnimation(mainLayoutAnimation);

        int answerNumber =  GetImageRandomNumber();
        m_currentAnswer = answerNumber;
        InitializeAnswerView(answerNumber);

        Animation animation = AnimationUtils.loadAnimation(m_activity, R.anim.alpha);
        m_answerLayout.startAnimation(animation);

        m_vibrator.vibrate(VIBRATE_INTERVAL);
    }

}
