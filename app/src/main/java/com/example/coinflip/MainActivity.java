package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView kep;
    private LinearLayout linear;
    private Button fejBtn;
    private Button irasBtn;
    private TextView dobas;
    private TextView gyozelem;
    private TextView vereseg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init()
    {
        layout = findViewById(R.id.layout);
        kep = findViewById(R.id.kep);
        linear = findViewById(R.id.linear);
        fejBtn = findViewById(R.id.fejBtn);
        irasBtn = findViewById(R.id.irasBtn);
        dobas = findViewById(R.id.dobas);
        gyozelem = findViewById(R.id.gyozelem);
        vereseg = findViewById(R.id.vereseg);
    }
}