package com.basiccalc.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button liida, lahuta, korruta, jaga;
    private TextView tulemus;
    private EditText etFirstNumber, etSecondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        liida = (Button)findViewById(R.id.liida);
        lahuta = (Button)findViewById(R.id.lahuta);
        korruta = (Button)findViewById(R.id.korruta);
        jaga = (Button)findViewById(R.id.jaga);

        etFirstNumber = (EditText)findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText)findViewById(R.id.etSecondNumber);

        tulemus = (TextView)findViewById(R.id.tulemus);

        liida.setOnClickListener(this);
        lahuta.setOnClickListener(this);
        korruta.setOnClickListener(this);
        jaga.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num1 = etFirstNumber.getText().toString();
        String num2 = etSecondNumber.getText().toString();

        switch(getTaskId()){
            case R.id.liida:
                int liitmine = Integer.parseInt(num1) + Integer.parseInt(num2);
                tulemus.setText(String.valueOf(liitmine));
                break;
            case R.id.lahuta:
                int lahutamine = Integer.parseInt(num1) - Integer.parseInt(num2);
                tulemus.setText(String.valueOf(lahutamine));
                break;
            case R.id.korruta:
                int korrutamine = Integer.parseInt(num1) * Integer.parseInt(num2);
                tulemus.setText(String.valueOf(korrutamine));
                break;
            case R.id.jaga:
                try{
                    int jagamine = Integer.parseInt(num1) / Integer.parseInt(num2);
                    tulemus.setText(String.valueOf(jagamine));
                }
                catch (Exception e){
                    tulemus.setText("Ei saa jagada 0-ga");
                }
                break;
        }
    }
}