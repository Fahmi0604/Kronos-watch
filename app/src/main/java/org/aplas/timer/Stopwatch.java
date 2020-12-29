package org.aplas.timer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class Stopwatch extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private Button mTimerbutton;
    private AlertDialog Adialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        mTimerbutton = findViewById(R.id.button_timer);
        mTimerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimer();
            }
        });

        chronometer = findViewById(R.id.stpwatch);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Adialog = new AlertDialog.Builder(Stopwatch.this).create();
//        Adialog.setTitle("Perhatian");
//        Adialog.setMessage("Aplikasi stopwatch siap berjalan");
//        Adialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        Adialog.show();
    }

    public void startWtch(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
            Toast.makeText(Stopwatch.this, "Mulai Menghitung", Toast.LENGTH_SHORT).show();
        }
    }

    public void pauseWtch(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            Toast.makeText(Stopwatch.this, "Berhenti Menghitung", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetWtch(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        Toast.makeText(Stopwatch.this, "Dimulai dari Nol yaaa...", Toast.LENGTH_SHORT).show();
    }

    public void openTimer() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}