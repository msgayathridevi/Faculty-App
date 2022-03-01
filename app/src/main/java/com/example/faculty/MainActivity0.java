package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity0 extends AppCompatActivity {

    Button fac, stu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        fac = findViewById(R.id.fac);
        stu = findViewById(R.id.stu);

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity0.this,MainActivity.class);
                startActivity(intent);
            }
        });

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity0.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}