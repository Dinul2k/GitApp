package com.example.tempcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputnum;
    RadioButton celbtn,farbtn;
    Button calbtn;
    TextView resultview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputnum = findViewById(R.id.inputnum);
        celbtn = findViewById(R.id.celbtn);
        farbtn = findViewById(R.id.farbtn);
        calbtn = findViewById(R.id.calbtn);
        resultview = findViewById(R.id.resultview);
    }
    protected void onResume() {
        super.onResume();
        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations cal = new Calculations();
       String value = inputnum.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please enter tempreture",
                    Toast.LENGTH_LONG).show();
        }
        else{
         Float  temp=   Float.parseFloat(value);
            if(celbtn.isChecked()){
            temp= cal.convertCelciusToFahrenheit(temp);

            }
            else if (farbtn.isChecked()){
                temp =cal.convertFahrenheitToCelcius(temp);
            } else{
                Toast.makeText(this, "Please select tempreture type",
                        Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            resultview.setText(new Float(temp).toString());


        }
        }
    }





