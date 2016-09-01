package com.example.savvato.pomidorroapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {
    private Chronometer chronometer;
    private PomodorroController controller;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.chronometer = (Chronometer) findViewById(R.id.chronometer);
        if (chronometer != null) {
            chronometer.setOnChronometerTickListener(this);
        }

        this.buttonStart = (Button) findViewById(R.id.buttonStart);
        if (this.buttonStart != null) {
            this.buttonStart.setOnClickListener(this);
        }
        this.controller = new PomodorroController();
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        if (elapsedMillis > controller.getTargetTime()) {
            chronometer.stop();
            Toast.makeText(this, controller.getPomidorroStatus() + " is over", Toast.LENGTH_LONG).show();
            controller.next();
            buttonStart.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                chronometer.setBase(SystemClock.elapsedRealtime());
                Toast.makeText(this, controller.getPomidorroStatus() + " began", Toast.LENGTH_LONG).show();
                chronometer.start();
                buttonStart.setEnabled(false);
                break;
        }
    }
}
