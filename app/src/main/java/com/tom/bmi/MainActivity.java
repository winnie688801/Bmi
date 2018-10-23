package com.tom.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "onClick: help");
                new AlertDialog.Builder(MainActivity.this)
                .setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok, null)
                        .show();
                            }
        });
    }

        @Override
        protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

        @Override
        protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

        @Override
        protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

        @Override
        protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

        @Override
        protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

        @Override
        protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }

    public void bmi(View view) {
        Log.d("MainActivity" , "bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity" , w +"/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight /(height*height);
        Log.d("MainActivity" , bmi+"");
        Intent intent = new Intent(this,Result.class);
        intent.putExtra("BMI",bmi);

        startActivity(intent);

        /*Toast.makeText(this,getString(R.string.your_bmi_is) +bmi , Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setTitle(R.string.bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText("");
                        edHeight.setText("");
                    }
                }).show();*/

    }
}