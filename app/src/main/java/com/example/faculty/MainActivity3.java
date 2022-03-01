package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    public RatingBar ratingbar;
    public SeekBar seek1, seek2;
    public EditText txt;
    public Button submit;

    //FirebaseDatabase rootnode;
    DatabaseReference reference;
    DatabaseReference rootnode;

    float star, star2;
    int seek1_prog = 0, seek2_prog=0;
    String feed_text;

    // data values storage in date format
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
    Date date = new Date();
    String dates = formatter.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // hooks to all xml elements
        ratingbar = findViewById(R.id.star_rtng);
        seek1 = findViewById(R.id.seekbar1);
        seek2 = findViewById(R.id.seekbar2);
        txt = findViewById(R.id.feed);
        submit = findViewById(R.id.submit);

        // getting star rate value
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                star = v;
                star2 = ratingBar.getRating();
                if(star==star2)
                    Toast.makeText(MainActivity3.this, "Your rating : " + star, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this, "Star Rating not same", Toast.LENGTH_SHORT).show();
            }
        });

        // getting seekbars value
        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seek1_prog = i;
                //txt.setText(String.valueOf(seek1_prog));
                //Toast.makeText(MainActivity3.this, "Progress : "+seek1_prog, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity3.this, "Drag and pick a value ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity3.this, "Rated : "+seek1_prog, Toast.LENGTH_SHORT).show();
            }
        });

        seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seek2_prog = i;
                //txt.setText(String.valueOf(seek1_prog));
                //Toast.makeText(MainActivity3.this, "Progress : "+seek1_prog, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity3.this, "Drag and pick a value ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity3.this, "Rated : "+seek2_prog, Toast.LENGTH_SHORT).show();
            }
        });

        //Toast.makeText(this, "Feedback : "+feed_text, Toast.LENGTH_SHORT).show();

        //LocalDate dt = java.time.LocalDate.now().toString();
        rootnode = FirebaseDatabase.getInstance().getReference("student").child(dates);
        // saving data in FireBase
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(i);
                insert_data();
                /*//saving feedback data
                feed_text = txt.getText().toString();
                Toast.makeText(MainActivity3.this, "Feedback : "+feed_text, Toast.LENGTH_SHORT).show();

                //rootnode = FirebaseDatabase.getInstance().getReference().child("users");
                //reference = rootnode.getReference("users");

                UserHelperClass helperclass = new UserHelperClass(star, seek1_prog, seek2_prog, feed_text);
                //reference.setValue(helperclass);
                rootnode.push().setValue(helperclass);
*/
            }
        });
    }
    private void insert_data(){
        //saving feedback data
        feed_text = txt.getText().toString();
        Toast.makeText(MainActivity3.this, "Feedback : "+feed_text, Toast.LENGTH_SHORT).show();

        //rootnode = FirebaseDatabase.getInstance().getReference().child("users");
        //reference = rootnode.getReference("users");

        UserHelperClass helperclass = new UserHelperClass(star, seek1_prog, seek2_prog, feed_text);
        //reference.setValue(helperclass);
        rootnode.push().setValue(helperclass);

        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}