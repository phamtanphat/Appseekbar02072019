package com.example.appseekbar02072019;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    SeekBar skOne,skTwo,skThree;
    ImageButton imgPlay;
    CheckBox ckOne,ckTwo,ckThree;
    Random random;
    int indexOne , indexTwo , indexThree = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        // 1 : Cho 3 seekbar chạy random
        // 2 : Con nào về nhất thông báo và 2 con kia dừng lại
        // 3 : Xử lý cho nut play
//            + Chọn 1 check box
//            + Sau đó mới được start
        init();
        seekbarRandom();
    }

    private void init() {
        random = new Random();
    }

    private void seekbarRandom() {
        CountDownTimer countDownTimer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                indexOne = random.nextInt(10);
                indexTwo = random.nextInt(10);
                indexThree = random.nextInt(10);

                skOne.setProgress(skOne.getProgress() + indexOne);
                skTwo.setProgress(skTwo.getProgress() + indexTwo);
                skThree.setProgress(skThree.getProgress() + indexThree);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();

    }

    private void anhxa() {
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        imgPlay = findViewById(R.id.imageviewPlay);
        ckOne = findViewById(R.id.checkboxOne);
        ckTwo = findViewById(R.id.checkboxTwo);
        ckThree = findViewById(R.id.checkboxThree);
    }


}
