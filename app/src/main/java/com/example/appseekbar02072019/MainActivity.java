package com.example.appseekbar02072019;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    SeekBar skOne, skTwo, skThree;
    ImageButton imgPlay;
    CheckBox ckOne, ckTwo, ckThree;
    Random random;
    int indexOne, indexTwo, indexThree = 0;
    boolean isLoading = false;
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
        event();

    }

    private void event() {
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ckOne.isChecked() || ckTwo.isChecked() || ckThree.isChecked()){
                    if (isLoading == false){
                        isLoading = true;
                        disableView();
                        seekbarRandom();
                    }else{
                        Toast.makeText(MainActivity.this, "Đang chạy", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Bạn phải chon 1 con vật", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void disableView(){
        ckOne.setEnabled(false);
        ckThree.setEnabled(false);
        ckTwo.setEnabled(false);
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        imgPlay.setEnabled(false);
    }
    private void enableView(){
        ckOne.setEnabled(true);
        ckThree.setEnabled(true);
        ckTwo.setEnabled(true);
        skOne.setEnabled(true);
        skTwo.setEnabled(true);
        skThree.setEnabled(true);
        imgPlay.setEnabled(true);
    }
    private void init() {
        random = new Random();
        singleChoiceCheckbox();
    }

    private void singleChoiceCheckbox() {
        ckOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckTwo.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });
        ckTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckOne.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });
        ckThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ckOne.setChecked(false);
                    ckTwo.setChecked(false);
                }
            }
        });
    }

    private void seekbarRandom() {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                if (skOne.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, skOne.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    isLoading = false;
                    enableView();
                } else if (skTwo.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, skTwo.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    isLoading = false;
                    enableView();
                } else if (skThree.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, skThree.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    isLoading = false;
                    enableView();
                } else {
                    indexOne = random.nextInt(10) + 1;
                    indexTwo = random.nextInt(10) + 2;
                    indexThree = random.nextInt(10) + 3;

                    skOne.setProgress(skOne.getProgress() + indexOne);
                    skTwo.setProgress(skTwo.getProgress() + indexTwo);
                    skThree.setProgress(skThree.getProgress() + indexThree);
                }
            }

            @Override
            public void onFinish() {
                Log.d("BBB", "Finish");
            }
        };
        countDownTimer.start();

    }

    private void anhxa() {
        skOne = findViewById(R.id.seekbarOne);
        skOne.setTag("Con Ong");
        skTwo = findViewById(R.id.seekbarTwo);
        skTwo.setTag("Con Cóc");
        skThree = findViewById(R.id.seekbarThree);
        skThree.setTag("Con Cừu");
        imgPlay = findViewById(R.id.imageviewPlay);
        ckOne = findViewById(R.id.checkboxOne);
        ckTwo = findViewById(R.id.checkboxTwo);
        ckThree = findViewById(R.id.checkboxThree);
    }


}
