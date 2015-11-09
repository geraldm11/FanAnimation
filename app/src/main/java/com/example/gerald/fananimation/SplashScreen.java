package com.example.gerald.fananimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by gerald on 11/9/2015.
 */
public class SplashScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread timerThread = new Thread(){
            public void run()
            {
                try
                {
                    sleep(2000);
                    Intent i = new Intent(SplashScreen.this, FanController.class);
                    startActivity(i);
                    finish();
                } catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        timerThread.start();
    }
}
