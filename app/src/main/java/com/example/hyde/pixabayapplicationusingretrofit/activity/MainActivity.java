package com.example.hyde.pixabayapplicationusingretrofit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hyde.pixabayapplicationusingretrofit.R;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.flow);
        img2 = (ImageView) findViewById(R.id.na);
        img3 = (ImageView) findViewById(R.id.anim);
        img4 = (ImageView) findViewById(R.id.natu);
        edit = (EditText) findViewById(R.id.sear);
        text = (TextView) findViewById(R.id.go);

        // Untuk TextView Go
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recyc.class);
                myIntent.putExtra("q", "" + edit.getText().toString());
                startActivity(myIntent);
            }
        });

        // untuk gambar 1
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recyc.class);
                myIntent.putExtra("q", "flower");
                myIntent.putExtra("type", "photo");
                startActivity(myIntent);

            }
        });
        // untuk gambar 2
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Recyc.class);
                myIntent.putExtra("q", "love");
                myIntent.putExtra("type", "photo");
                startActivity(myIntent);
            }
        });
        // untuk gambar 3
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Recyc.class);
                myIntent.putExtra("q", "animal");
                myIntent.putExtra("type", "photo");
                startActivity(myIntent);

            }
        });
        // untuk gambar 4
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Recyc.class);
                myIntent.putExtra("q", "nature");
                myIntent.putExtra("type", "photo");
                startActivity(myIntent);
            }
        });


    }
}