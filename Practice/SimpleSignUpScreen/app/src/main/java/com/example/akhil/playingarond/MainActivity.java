package com.example.akhil.playingarond;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText time;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.sleep_time);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sleepTime = Integer.parseInt(time.getText().toString());
                TaskRunner taskRunner = new TaskRunner();
                taskRunner.execute(sleepTime);
            }
        });
    }

    private class TaskRunner extends AsyncTask<Integer,String,String>
    {
        ProgressDialog dialog;
        TextView statusUpdate= findViewById(R.id.after_sleep_completes);
        @Override
        protected String doInBackground(Integer... xes) {
            publishProgress("Sleeping");
            try
            {
                Thread.sleep(xes[0]*1000);
            }

            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return "Sleep has been completed";
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("The Thread is Sleeping");
            dialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            if(dialog.isShowing()) {
                Log.d("OK","WE REACHED");
                dialog.dismiss();
            }
            statusUpdate.setText(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            statusUpdate.setText(values[0]);
        }
    }
}
