package com.example.coinflip;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView kep;
    private LinearLayout linear;
    private Button fejBtn;
    private Button irasBtn;
    private TextView dobas;
    private TextView gyozelem;
    private TextView vereseg;
    private int tipp;
    private int dobott;
    private int dobasSzam;
    private int gyozelemSzam;
    private int veresegSzam;
    private Random rnd = new Random();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fejBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                dob();
                Ellenorzes();
            }
        });
        irasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                dob();
                Ellenorzes();
            }
        });
    }

    public void dob()
    {
        dobasSzam++;
        dobott = rnd.nextInt(2);
        if (dobott == 0)
        {
            kep.setImageResource(R.drawable.heads);
            Toast.makeText(this, "Fej", Toast.LENGTH_SHORT).show();

        }
        else
        {
            kep.setImageResource(R.drawable.tails);
            Toast.makeText(this, "Írás", Toast.LENGTH_SHORT).show();
        }

        if (tipp == dobott)
        {
            gyozelemSzam++;
        }
        else
        {
            veresegSzam++;
        }

        dobas.setText("Dobás: " + dobasSzam);
        gyozelem.setText("Győzelem: " + gyozelemSzam);
        vereseg.setText("Vereség: " + veresegSzam);
    }

    public void Ellenorzes()
    {
        if(dobasSzam == 5 || gyozelemSzam > 2 || veresegSzam > 2)
        {
            if(gyozelemSzam > veresegSzam)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Győzelem!")
                        .setMessage("Szeretne új játékot indítani?")
                        .setCancelable(false)
                        .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                nulla();
                            }
                        })
                        .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Vereség!")
                        .setMessage("Szeretne új játékot indítani?")
                        .setCancelable(false)
                        .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                nulla();
                            }
                        })
                        .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();
            }

        }
    }

    public void nulla()
    {
        dobas.setText("Dobás: 0");
        dobasSzam = 0;
        gyozelem.setText("Győzelem: 0");
        gyozelemSzam = 0;
        vereseg.setText("Vereség: 0");
        veresegSzam = 0;
        kep.setImageResource(R.drawable.heads);
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