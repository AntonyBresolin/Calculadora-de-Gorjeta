package com.antonybresolin.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valorConta;
    private TextView porcentageSeekBar;
    private TextView gorjeta;
    private TextView total;
    private SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorConta = findViewById(R.id.textImputValorConta);
        gorjeta = findViewById(R.id.textViewGorjeta);
        total = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);
        porcentageSeekBar = findViewById(R.id.textViewPorcentagemSeekBark);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentageSeekBar.setText(i + "%");
                calcular(i, Double.parseDouble(valorConta.getText().toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calcular(int porcentagem, Double valorDaConta) {
        Double valorGorjeta = (valorDaConta * porcentagem) / 100;
        valorDaConta += valorGorjeta;

        gorjeta.setText("R$ " + tirarCasasDecimais(valorGorjeta));
        total.setText("R$ " + tirarCasasDecimais(valorDaConta));
    }

    private Double tirarCasasDecimais(Double numero) {
        numero = Math.round(numero * 100.0) / 100.0;

        return numero;
    }

}