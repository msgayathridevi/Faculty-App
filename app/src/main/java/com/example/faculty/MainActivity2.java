package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    static final String code_str ="CODE";
    int code;
    Button goto_room;
    EditText code_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Data get
        Intent i = getIntent();
        code = i.getIntExtra(code_str,0);

        code_check = findViewById(R.id.enter_room_code);
        goto_room = findViewById(R.id.goto_room);
        goto_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(code_check.getText().toString())==code){
                    Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                    startActivity(intent);
                    //finish();
                    Toast.makeText(MainActivity2.this, "correct code", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity2.this, "Wrong code bro.!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}