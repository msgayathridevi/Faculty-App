package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity5 extends AppCompatActivity {

    Button prev_pg, submit;

    RatingBar star_rtng;
    float star_value;

    RadioGroup rg;
    RadioButton rad_btn;
    String rg_str;

    EditText feed;
    String feed_text;

    static String portion, interactive;
    static int digital_prog;

    DatabaseReference rootnode;

    // data values storage in date format
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
    Date date = new Date();
    String dates = formatter.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // getting star rate value
        star_rtng = findViewById(R.id.star_rtng);
        star_rtng.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                star_value = v;
                Toast.makeText(MainActivity5.this, "Your rating : " + star_value, Toast.LENGTH_SHORT).show();
            }
        });

        // radio data
        rg = findViewById(R.id.rg);

        //saving feedback data
        feed = findViewById(R.id.feed);

        // buttons
        prev_pg = findViewById(R.id.prev_pg);
        submit = findViewById(R.id.submit);

        prev_pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(i);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed_text = feed.getText().toString();
                Toast.makeText(MainActivity5.this, "Feedback : "+feed_text, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(i);
                insert_data();
            }
        });

    }

    public void rbclick(View view){
        int radioid = rg.getCheckedRadioButtonId();
        rad_btn = findViewById(radioid);
        Toast.makeText(this, " selected hw complex : " + rad_btn.getText(), Toast.LENGTH_SHORT).show();
    }

    private void insert_data(){
        // FireBase
        rootnode = FirebaseDatabase.getInstance().getReference("student2").child(dates);

        // get previous data
        portion = getIntent().getStringExtra("portion");
        interactive = getIntent().getStringExtra(interactive);
        digital_prog = getIntent().getIntExtra("digital_prog", 0);
        // Toast.makeText(this, "portion: "+portion+" \ninteract: "+interactive+"\ndigital: "+digital_prog, Toast.LENGTH_SHORT).show();

        //saving feedback data
        feed_text = feed.getText().toString();
        Toast.makeText(MainActivity5.this, "Feedback : "+feed_text, Toast.LENGTH_SHORT).show();

        rg_str = rad_btn.getText().toString();
        Toast.makeText(this, "rg_str : "+rg_str, Toast.LENGTH_SHORT).show();
        UserHelperClass2 helperclass = new UserHelperClass2(portion, interactive, digital_prog, star_value, rg_str, feed_text);
        rootnode.push().setValue(helperclass);

        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}