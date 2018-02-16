package com.agrim.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    EditText et1;
    TextView tv1;
    Toolbar toolbar1;
    public static CharSequence c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.bt);
        et1 = (EditText)findViewById(R.id.ed);
        tv1 = (TextView)findViewById(R.id.tv);
        toolbar1=(Toolbar)findViewById(R.id.toolbar);
        toolbar1.setTitle("HANGMAN");
        toolbar1.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar1);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = et1.getText();
                Intent intent = new Intent();
                Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent1);
                finish();
            }
        }; bt1.setOnClickListener(myListener);
        };
    }

