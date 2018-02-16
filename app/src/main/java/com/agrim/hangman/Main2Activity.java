package com.agrim.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar1;
    Button bt2;
    TextView tv1,tv2;
    EditText ed1;
    int n,k=0,l,m=0;
    String str,s2="",s3,s4,s6,str1,s8="",s9="";
    String[] s1,s5,s7;
    char[] ch;
    char c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt2 = (Button)findViewById(R.id.bt);
        ed1 = (EditText)findViewById(R.id.ed);
        tv1 = (TextView)findViewById(R.id.te1);
        tv2 = (TextView)findViewById(R.id.te2);
        toolbar1=(Toolbar)findViewById(R.id.toolbar);
        toolbar1.setTitle("HANGMAN");
        toolbar1.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar1);
        str = (MainActivity.c).toString();
        ch = str.toCharArray();
        n = str.length();
        s5 = "HANGMAN".split("");

        for(int i=0;i<n;i++) {
            if ((ch[i]=='a') || (ch[i]=='e') || (ch[i]=='o') || (ch[i]=='i') || (ch[i]=='u') || (ch[i]=='A') || (ch[i]=='E') || (ch[i]=='O') || (ch[i]=='U'))
               {s3 = Character.toString(ch[i]);
                   s2=s2+s3;}
            else
                {if (ch[i]==' ')
                   {s2=s2+" ";}
                else
                   {s2 = s2+"_";}}}
        tv2.setText(s2);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1="false";
                CharSequence s3 = ed1.getText();
                s4 = s3.toString();
                for(int j=0;j<n;j++)
                    {s6 = Character.toString(ch[j]);
                        if(s6.equals(s4))
                            {CharSequence ch2 = tv2.getText();
                                String str2 = ch2.toString();
                                s7=str2.split("");
                                s7[j+1]=s4;
                                s8="";
                            for(l=1;l<n+1;l++)
                               {s8 = s8+s7[l];}
                            tv2.setText(s8);
                            str1 = "true";}}
                if ((str1=="false") && (k<7))
                {       k++;
                        s9="";
                        s5[k] = "_";
                        for (l=1;l<8;l++)
                            s9 = s9+s5[l];
                        tv1.setText(s9);}
                CharSequence ch3 = tv2.getText();
                String str3 = ch3.toString();
                if (str3.equals(str))
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Main2Activity.this);
                    builder1.setMessage("YOU HAVE WON\n" +
                            "DO YOU WANT TO CLOSE THE APP").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            Intent intent5 = new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(intent5);
                            finish();
                        }
                    });
                    AlertDialog alert = builder1.create();
                    alert.setTitle("CONGRATS !!");
                    alert.show();
                }
                String str4 = "_______";
                CharSequence ch4 = tv1.getText();
                String str5 = ch4.toString();
                if (str5.equals(str4))
                {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(Main2Activity.this);
                    builder2.setMessage("YOU HAVE LOST\n" +
                            "DO YOU WANT TO CLOSE THE APP").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            Intent intent3 = new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(intent3);
                            finish();
                        }
                    });
                    AlertDialog alert1 = builder2.create();
                    alert1.setTitle("OOPS !!");
                    alert1.show();
                }
            }
        };bt2.setOnClickListener(myListener);
        }
    }

