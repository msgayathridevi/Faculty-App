package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.Charset;
import java.util.Random;

public class fac_generate extends AppCompatActivity {

    TextView result;
    Button generate;
    String code_str;

    DatabaseReference rootnode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fac_generate);

        result = findViewById(R.id.result);
        generate = findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code_str=getAlphaNumericString(6);
                // passing code values
                //Intent i = new Intent(getApplicationContext(), wel_stu.class);
                //i.putExtra("code_str",code_str);

                Toast.makeText(fac_generate.this, "code : "+ code_str, Toast.LENGTH_SHORT).show();
                insert_data();
                // intenting activities
                Intent intent = new Intent(fac_generate.this, fac_count.class);
                intent.putExtra("code",code_str);
                startActivity(intent);

            }
        });
        //Log.d("hey bruuhhh");
    }

    static String getAlphaNumericString(int n)
    {
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // remove all spacial char
        String  AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");

        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {
            if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
                    || Character.isDigit(AlphaNumericString.charAt(k))  && (n > 0)) {

                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }

    private void insert_data() {
        // FireBase
        rootnode = FirebaseDatabase.getInstance().getReference("code");

        helperclass_faculty helperclass = new helperclass_faculty(code_str);
        rootnode.push().setValue(helperclass);
    }
}