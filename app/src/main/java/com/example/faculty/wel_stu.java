package com.example.faculty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class wel_stu extends AppCompatActivity {

    String code_str = "CODE";
    Button goto_room;
    EditText code_check;
    DatabaseReference rootnode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wel_stu);

        code_check = findViewById(R.id.enter_room_code);
        goto_room = findViewById(R.id.goto_room);
        goto_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootnode  = FirebaseDatabase.getInstance().getReference("code");
                rootnode.limitToLast(1).addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {

                        code_str = (dataSnapshot.getValue()).toString().substring(10,16);

                        if((code_check.getText().toString()).equals(code_str)){
                            Intent intent = new Intent(wel_stu.this, stu_rp1.class);
                            startActivity(intent);
                            Toast.makeText(wel_stu.this, "correct code", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(wel_stu.this, "Wrong code bro.!", Toast.LENGTH_LONG).show();
                        }
                        //Toast.makeText(wel_stu.this, "final code : " + code_str, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                        code_str = (dataSnapshot.getValue().toString()).substring(10,16);
                        Toast.makeText(wel_stu.this, "changed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {}

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });
            }
        });
    }
}