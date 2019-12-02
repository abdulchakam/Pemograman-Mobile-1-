package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private int[] btnAngka = {R.id.btnNol, R.id.btnSatu, R.id.btnDua, R.id.btnTiga,
                              R.id.btnEmpat, R.id.btnLima, R.id.btnEnam, R.id.btnTujuh,
                              R.id.btnDelapan, R.id.btnSembilan};

    private int[] btnOperator = {R.id.btnTambah, R.id.btnKurang, R.id.btnKali, R.id.btnBagi};

    private TextView txtLayar;

    private boolean angkaTerakhir;

    private boolean stateEror;

    private boolean titik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtLayar = (TextView) findViewById(R.id.txtLayar);

        setAngkaOnClickListern();

        setOperatorOnClickListern();
    }

    private void setAngkaOnClickListern() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;

                if (stateEror) {
                    txtLayar.setText(button.getText());
                    stateEror = false;
                } else {
                    txtLayar.append(button.getText());
                }
                angkaTerakhir = true;
            }
        };

        for (int id : btnAngka) {
            findViewById(id).setOnClickListener(listener);
        }
    }
        private void setOperatorOnClickListern () {

            View.OnClickListener listener =  new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (angkaTerakhir && !stateEror){
                        Button button = (Button) v;

                        txtLayar.append(button.getText());

                        angkaTerakhir = false;

                        titik = false;


                    }
                }
            };

            for (int id : btnOperator){
                findViewById(id).setOnClickListener(listener);
            }

            findViewById(R.id.btnTitik).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (angkaTerakhir && !titik){
                        txtLayar.append(".");
                        angkaTerakhir = false;
                        titik = true;

                    }
                }
            });findViewById(R.id.btnBersih).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txtLayar.setText("");

                    angkaTerakhir = false;
                    stateEror = false;
                    titik = false;

                }
            });

            findViewById(R.id.btnSamadengan).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onEqual();
                }
            });
        }

        private void onEqual(){

            if(angkaTerakhir && !stateEror){
                String txt = txtLayar.getText().toString();
                Expression expression = new ExpressionBuilder(txt).build();

                try{
                    double result = expression.evaluate();

                    txtLayar.setText(Double.toString(result));

                    titik = true;
                } catch (ArithmeticException ex){
                    txtLayar.setText("Eror");
                    stateEror = true;
                    angkaTerakhir = false;
                }
            }
        }
    }