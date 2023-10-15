package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button calculer;
    EditText txtPoid;
    EditText txtTail;
    TextView result;
    TextView description;

    float resIMC;
    String sex;

    RadioButton hommeRadio;
    RadioButton femmeRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       calculer = (Button)findViewById(R.id.btnCalculer);
       txtPoid = (EditText) findViewById(R.id.inpoutPoid);
       txtTail = (EditText) findViewById(R.id.inputTaille);

        hommeRadio = (RadioButton) findViewById(R.id.radioHomme);
        femmeRadio = (RadioButton) findViewById(R.id.radioFemme);

       result = (TextView) findViewById(R.id.txtResult);
       description = (TextView) findViewById(R.id.txtDescription);


        calculer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        resIMC = calculateIMC();

                        if (hommeRadio.isChecked()) {

                            sex = getTypeIMC("Homme", resIMC);
                        }

                        if (femmeRadio.isChecked()) {
                            sex = getTypeIMC("Femme", resIMC);
                        }

                        description.setText("IMC = "+ String.valueOf(resIMC));
                        result.setText(sex);
                    }
                });
    }

    public float calculateIMC(){
        float poid = Float.parseFloat(txtPoid.getText().toString());
        float tail = Float.parseFloat(txtTail.getText().toString());

        return poid / (tail*tail);
    }


    private String getTypeIMC(String type, float imc){
        String typeIMC = "";
        if (type == "Homme"){
            if ( imc < 18.5) {
                typeIMC = "Maigreur";
            } else if (imc > 18.5 && imc < 25) {
                typeIMC =  "Normal";
            } else if (imc > 25 && imc < 30 ) {
                typeIMC = "Surpoids";
            } else if (imc > 30 && imc < 40) {
                typeIMC = "Obesite moderer";
            }else{
                typeIMC = "Obesite Severe";
            }
        }

        if (type == "Femme"){
            if ( imc < 18.5) {
                typeIMC = "Maigreur";
            } else if (imc > 18.5 && imc < 25) {
                typeIMC =  "Normal";
            } else if (imc > 25 && imc < 30 ) {
                typeIMC = "Surpoids";
            } else if (imc > 30 && imc < 40) {
                typeIMC = "Obesite moderer";
            }else{
                typeIMC = "Obesite Severe";
            }
        }

        return typeIMC;
    }
}