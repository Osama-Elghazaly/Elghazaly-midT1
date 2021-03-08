package com.example.elghazaly_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {
    String strgName;

    String gender;
    String job;
    String fullBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button bttnSubmit=(Button)findViewById(R.id.bttnSubmit);
        Button bttn1=(Button)findViewById(R.id.goToOneFrom2);
        Button bttn2=(Button)findViewById(R.id.goToThreeFrom2);

        EditText name=(EditText)findViewById(R.id.editTextTextPersonName);
        EditText birth=(EditText)findViewById(R.id.editTextNumber);
        RadioButton radButtonMale=(RadioButton)findViewById(R.id.radioBttn1);
        RadioButton radButtonFemale=(RadioButton)findViewById(R.id.radioBttn2);
        RadioButton radButtonStudent=(RadioButton)findViewById(R.id.radBttnStudnet);
        RadioButton radButtonInstructor=(RadioButton)findViewById(R.id.radBttnInstructor);
        TextView rslt=(TextView)findViewById(R.id.result);

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Activity2.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

            }
        });



        bttnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strgName=name.getText().toString();


                if(radButtonFemale.isChecked())
                    gender="Mrs.";
                else if (radButtonMale.isChecked())
                    gender="Mr.";




                rslt.setText("Hi "+gender+" "+strgName+" "+fullBirth+" years old");

                if(radButtonInstructor.isChecked())
                    Toast.makeText(Activity2.this,"Hi,prof "+strgName,Toast.LENGTH_LONG).show();



            }
        });

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,MainActivity.class));
            }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,Activity3.class));
            }
        });



    }

    Calendar c= Calendar.getInstance();
    DateFormat fmtDate=DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,month);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            fullBirth=("You are born in: "+fmtDate.format(c.getTime().toString()));
        }
    };
}