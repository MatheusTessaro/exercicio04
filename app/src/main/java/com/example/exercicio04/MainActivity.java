package com.example.exercicio04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIniciar;
    private TextView txtCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        txtCount = findViewById(R.id.txtCount);


        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ProcessarTask task = new ProcessarTask(btnIniciar, txtCount);
        if(view.getId() == R.id.btnIniciar){
            task.execute(0);

        }
    }
}