package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select_user extends AppCompatActivity {

    Button fac, stu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_user);

        fac = findViewById(R.id.fac);
        stu = findViewById(R.id.stu);

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(select_user.this, fac_generate.class);
                startActivity(intent);
            }
        });

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_user.this, wel_stu.class);
                startActivity(intent);
            }
        });
    }
}