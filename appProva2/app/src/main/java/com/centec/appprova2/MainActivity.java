package com.centec.appprova2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvStatus, tvIMC;
    EditText etPeso, etAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        tvIMC = findViewById(R.id.tvIMC);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
    }

    public void calcularIMC(View view){
        String peso = etPeso.getText().toString();
        String altura = etAltura.getText().toString();

        double pesoNew = Double.parseDouble(peso);
        double alturaNew = Double.parseDouble(altura);

        double imc = pesoNew/(alturaNew*alturaNew);
        tvIMC.setText(String.format("IMC: %2f ",imc));

        if(imc<18.5){
            tvStatus.setText(String.format("Status: Abaixo do Peso"));
        } else if (imc<24.9) {
            tvStatus.setText(String.format("Status: Peso Ideal"));
        } else if (imc<29.9) {
            tvStatus.setText(String.format("Status: Acima do Peso"));
        } else if (imc<34.9) {
            tvStatus.setText(String.format("Status: Obesidade Grau I"));
        } else if (imc<39.9) {
            tvStatus.setText(String.format("Status: Obesidade Grau II"));
        }else {
            tvStatus.setText(String.format("Status: Obesidade Grau III"));
        }

    }
}