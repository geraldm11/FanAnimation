package com.example.gerald.fananimation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;


import static android.widget.Toast.*;

public class FanController extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private final boolean D = Log.isLoggable(TAG, Log.DEBUG);

    private ToggleButton passTog;
    Button btnslow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // To get full screen without bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_fan_controller);



        ToggleButton passTog =(ToggleButton)findViewById(R.id.toggleButton);
        passTog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Button btnslow = (Button) findViewById(R.id.btnslow);
                    btnslow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FanAnimation.mSpeed = 5f;
                            Toast toast = makeText(FanController.this,
                                    "Slow Velocity",
                                    LENGTH_SHORT);
                            toast.show();
                        }

                    });

                    Toast toast = makeText(FanController.this,
                            "The Fan is ON",
                            LENGTH_SHORT);
                    toast.show();

                    Button mediumButton = (Button)findViewById(R.id.btnmedium);
                    mediumButton .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FanAnimation.mSpeed = 15f;
                            Toast toast = makeText(FanController.this,
                                    "Medium Velocity ",
                                    LENGTH_SHORT);
                            toast.show();
                        }
                    });


                    Button fastButton = (Button)findViewById(R.id.btnfast);
                    fastButton.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            FanAnimation.mSpeed = 30f;
                            Toast toast = makeText(FanController.this,
                                    "Max Velocity",
                                    LENGTH_SHORT);
                            toast.show();
                        }
                    });


                }else{
                    FanAnimation.mSpeed = 0f;
                    Toast toast = makeText(FanController.this,
                            "The Fan is OFF",
                            LENGTH_SHORT);
                    toast.show();
                    Button btnslow = (Button)findViewById(R.id.btnslow);
                    btnslow.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            FanAnimation.mSpeed = 0f;
                            Toast toast = makeText(FanController.this,
                                    "Please Turn on the Fan First",
                                    LENGTH_SHORT);
                            toast.show();
                        }
                    });
                    Button mediumButton = (Button)findViewById(R.id.btnmedium);
                    mediumButton .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast toast = makeText(FanController.this,
                                    "Please Turn on the Fan First",
                                    LENGTH_SHORT);
                            toast.show();
                            FanAnimation.mSpeed = 0f;
                        }
                    });

                    Button fastButton = (Button) findViewById(R.id.btnfast);
                    fastButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast toast = makeText(FanController.this,
                                    "Please Turn on the Fan First",
                                    LENGTH_SHORT);
                            toast.show();
                            FanAnimation.mSpeed = 0f;
                        }
                    });
                }
            }

        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fan_controller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
