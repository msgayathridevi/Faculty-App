package com.example.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity7 extends AppCompatActivity {

    static final String code_str ="CODE";
    int code;
    TextView code_txt, count_txt;

    DatabaseReference rootnode;
    long count_val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        count_txt = findViewById(R.id.count_txt);
        code_txt = findViewById(R.id.code_txt);

        // get code to display
        //Intent i = getIntent();
        code = getIntent().getIntExtra("code",10);

        code_txt.setText("Code : "+ code);

        // data values storage in date format
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        String dates = formatter.format(date);

        // get count
        // FireBase
        rootnode = FirebaseDatabase.getInstance().getReference("student2").child(dates);
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