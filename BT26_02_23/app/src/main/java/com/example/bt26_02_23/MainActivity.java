package com.example.bt26_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;



    public class MainActivity extends AppCompatActivity {
        String str = "Nam", str1 = "Bạn chưa chọn giáo dục!", str2, str3 = "Bạn chưa chọn âm nhạc!";
        Switch s;
        Button register, cancel;
        EditText name, number;
        SeekBar sb;
        int age;
        TextView sbValue;
        RadioButton col,uni,o,pop,rnb,ballad;
        CheckBox ckb;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            s=findViewById(R.id.sGender);
            register = findViewById(R.id.button_register);
            cancel = findViewById(R.id.button_cancel);
            sb=findViewById(R.id.sbAge);
            sbValue=findViewById(R.id.ageValue);
            col=findViewById(R.id.rbCol);
            uni=findViewById(R.id.rbUni);
            o=findViewById(R.id.rbO);
            pop=findViewById(R.id.rbPop);
            rnb=findViewById(R.id.rbRnb);
            ballad=findViewById(R.id.rbBallad);
            ckb =findViewById(R.id.ckb);
            name = findViewById(R.id.Input1);
            number = findViewById(R.id.Input2);

            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar sb, int progress, boolean b) {
                    sbValue.setText(String.valueOf(progress));

                }

                @Override
                public void onStartTrackingTouch(SeekBar sb) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar sb) {

                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name.setText("");
                    number.setText("");
                    ckb.setChecked(false);
                    s.setChecked(false);
                    sb.setProgress(0);
                    col.setChecked(false);
                    uni.setChecked(false);
                    o.setChecked(false);
                    pop.setChecked(false);
                    rnb.setChecked(false);
                    ballad.setChecked(false);

                }
            });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Name = name.getText().toString();
                    String Number = number.getText().toString();
                    age=sb.getProgress();
                    onCheckboxClicked();
                    Intent intent = new Intent(MainActivity.this, Register.class);
                    intent.putExtra("name", Name);
                    intent.putExtra("number", Number);
                    intent.putExtra("switch",str);
                    intent.putExtra("rgEducation", str1);
                    intent.putExtra("rgMusic", str3);
                    intent.putExtra("ckbSport", str2);
                    intent.putExtra("age", age);
                    startActivity(intent);
                }
            });

        }
        public void onRadioButtonClicked(View view) {
            Boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch (view.getId()) {
                case R.id.rbCol:
                    if (col.isChecked()) str1 = "Cao đẳng";
                    break;
                case R.id.rbUni:
                    if (uni.isChecked()) str1 = "Đại học";
                    break;
                case R.id.rbO:
                    if (o.isChecked()) str1 = "Khác";
                    break;
                case R.id.rbPop:
                    if (pop.isChecked()) str3 = "Pop";
                    break;
                case R.id.rbRnb:
                    if (rnb.isChecked()) str3 = "Rnb";
                    break;
                case R.id.rbBallad:
                    if (ballad.isChecked()) str3 = "Ballad";
                    break;

            }
        }

        public void onCheckboxClicked() {
            if (ckb.isChecked()) {
                str2 = "Có!";
                ckb.setChecked(false);
            }
            else{
                str2 ="Không!";
            }
        }
        public void onCheckedChanged(View view){
            Boolean switch_gender1 = s.isChecked();

            if (s.isChecked()) {
                str = "Nữ";
                s.setChecked(false);
            }
        }



    }
