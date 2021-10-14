package com.example.exercicio04;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnIniciar;
    private TextView txtCount;
    private Integer count = 10;


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

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        txtCount.setText(count.toString());
        count--;

    }

    @Override
    protected Void doInBackground(Integer... integers) {

        for(int i = 10; i >= 0; i--){
            publishProgress(i);
            SystemClock.sleep(1000);
        }
        return null;
    }
}
