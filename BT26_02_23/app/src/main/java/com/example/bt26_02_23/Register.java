package com.example.bt26_02_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    private TextView name,number,edu,sport,gender,age,music;
    Button turnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.OutputN1);
        number=findViewById(R.id.OutputN2);
        edu=findViewById(R.id.txtEdu);
        sport=findViewById(R.id.txtSport);
        gender=findViewById(R.id.txtgender);
        age=findViewById(R.id.txtAge);
        music=findViewById(R.id.txtMusic);


        String Name=getIntent().getStringExtra("name");
        String Number=getIntent().getStringExtra("number");
        String Edu=getIntent().getStringExtra("rgEducation");
        String Sport=getIntent().getStringExtra("ckbSport");
        String Gender=getIntent().getStringExtra("switch");
        String Music=getIntent().getStringExtra("rgMusic");
        int Age= getIntent().getIntExtra("age", 0);

        name.setText(Name);
        number.setText(Number);
        edu.setText(Edu);
        music.setText(Music);
        sport.setText(Sport);
        gender.setText(Gender);
        age.setText(Integer.toString(Age));

        turnBack = findViewById(R.id.btnReturn);
        turnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Register.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
