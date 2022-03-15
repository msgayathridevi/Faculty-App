package com.example.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class fac_count extends AppCompatActivity {

    String code_str;
    TextView code_txt, count_txt;

    DatabaseReference rootnode;
    long count_val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fac_count);

        count_txt = findViewById(R.id.count_txt);
        code_txt = findViewById(R.id.code_txt);

        // get code to display
        //Intent i = getIntent();
        code_str = getIntent().getStringExtra("code");

        Toast.makeText(fac_count.this, "code : "+ code_str, Toast.LENGTH_SHORT).show();
        code_txt.setText("Code : "+ code_str);

        // data values storage in date format
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        String dates = formatter.format(date);

        // get count
        // FireBase
        rootnode = FirebaseDatabase.getInstance().getReference("data").child(dates);
        rootnode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                count_val = snapshot.getChildrenCount();
                count_txt.setText("Realtime Rated Peers : "+count_val);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // enabling offline entries
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // keeping FireBase on sync
        rootnode.keepSynced(true);

    }
}