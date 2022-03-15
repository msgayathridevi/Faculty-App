package com.example.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class stu_rp1 extends AppCompatActivity {

    TextView code_txt;
    int code;

    RadioGroup rg1_pg1, rg2_pg1;
    RadioButton rad_btn1, rad_btn2;
    int radioid1, radioid2;
    Button next_pg;

    SeekBar seekbar;
    TextView min_val, max_val;
    int digital_prog = 3;

    ///Button angry, sad, okay, smile, happy;
    RadioButton rb1, rb2, rb3, rb4, rb5;

    String portion, interactive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_rp1);

        // get code display
        code = getIntent().getIntExtra("code",0);
        code_txt = findViewById(R.id.code_txt);
        code_txt.setText("Code : "+ code);

        // radio data
        rg1_pg1 = findViewById(R.id.rg1_pg1);
        rg2_pg1 = findViewById(R.id.rg2_pg1);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);


        String an = getEmoji(0x1F621), sa = getEmoji(0x2639),
                ok = getEmoji(0x1F610), sm = getEmoji(0x1F642), ha = getEmoji(0x1F601);
        rb1.setText(an);
        rb2.setText(sa);
        rb3.setText(ok);
        rb4.setText(sm);
        rb5.setText(ha);

        // seekbar data
        seekbar = findViewById(R.id.seekbar);
        min_val = findViewById(R.id.min_val);
        max_val = findViewById(R.id.max_val);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                digital_prog = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(stu_rp1.this, "Drag and pick a value ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(stu_rp1.this, "Rated : " + digital_prog, Toast.LENGTH_SHORT).show();
            }
        });

        next_pg = findViewById(R.id.prev_pg);
        next_pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stu_rp1.this, stu_rp2.class);
                i.putExtra("portion", portion);
                i.putExtra(stu_rp2.interactive, interactive);
                i.putExtra("digital_prog", digital_prog);
                startActivity(i);
            }
        });

    }

    public String getEmoji(int i) {
        return new String(Character.toChars(i));
    }

    public void rbclick1(View view){
        radioid1 = rg1_pg1.getCheckedRadioButtonId();
        rad_btn1 = findViewById(radioid1);
        portion = rad_btn1.getText().toString();
        Toast.makeText(this, " selected hw complex : " + rad_btn1.getText(), Toast.LENGTH_SHORT).show();
    }

    public void rbclick2(View view){
        radioid2 = rg2_pg1.getCheckedRadioButtonId();
        rad_btn2 = findViewById(radioid2);
        interactive = rad_btn2.getText().toString();
        //Toast.makeText(this, " selected emoji : " + rad_btn2.getText(), Toast.LENGTH_SHORT).show();
    }

}