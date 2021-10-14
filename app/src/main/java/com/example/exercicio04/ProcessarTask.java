package com.example.exercicio04;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnIniciar;
    private TextView txtCount;


    public ProcessarTask(Button btnIniciar, TextView txtCount){
        this.btnIniciar = btnIniciar;
        this.txtCount = txtCount;
    }


    @Override
    protected void onPreExecute() {
        btnIniciar.setEnabled(false);
        txtCount.setText("10");

    }

    @Override
    protected void onPostExecute(Void unused) {
        btnIniciar.setEnabled(true);
        SystemClock.sleep(2500);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int min = values[0];

        for (int i = 10; i >= 0; i--){
            SystemClock.sleep(1000);
            String count = String.valueOf(i);
            txtCount.setText(count);
        }
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int min = integers[0];

        for(int i = 10; i >= min; i--){
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }
}
