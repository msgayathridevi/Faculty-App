package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button generate;
    String code_str;
    int code[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        generate = findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // unique code generation
                code = uniquecode(10);
                /*Random random = new Random();
                code = random.nextInt(1000000-100000)+100000;
                code_str = Integer.toString(code);
                result.setText("Room Code : " + code_str);*/

               /* // passing code values
                Intent i = new Intent();
                i.putExtra(MainActivity2.code_str,code);

                // intenting activities
                Intent intent = new Intent(MainActivity.this, MainActivity7.class);
                intent.putExtra("code",code);
                startActivity(intent);*/
                for(int i =0;i<10;i++)
                  Toast.makeText(MainActivity.this, "codes : "+ code, Toast.LENGTH_SHORT).show();
            }
        });

        //Log.d("hey bruuhhh");
    }

        static int[] uniquecode(int n){
            int []a = new int[n];
            for(int i =0; i < n; i++){
                a[i]=i;
            }
            int result[] = new int[n];
            int x=n;
            SecureRandom rd = new SecureRandom();
            for(int i=0;i<n;i++){
                int num = rd.nextInt(x);
                result[i] = a[num];
                a[num] = a[x-1];
                x--;
            }
            return result;
        }
}