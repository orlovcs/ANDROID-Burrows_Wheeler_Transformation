package com.example.orlovcs.android_burrows_wheeler_transformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

Button encode;
Button decode;
EditText rawText;
EditText encodedText;
TextView shifts;
TextView encodedTextview;
ArrayList<String> cyclicentries = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encode = findViewById(R.id.button2);
        decode = findViewById(R.id.button4);

rawText = findViewById(R.id.editText3);
encodedText = findViewById(R.id.editText4);

shifts = findViewById(R.id.textView12);
encodedTextview = findViewById(R.id.textView13);

        encode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String s = rawText.getText().toString();
                s = s + "$";
                String as = "";
                Integer length = s.length();

                for (int i = 0; i < length ; i++){
                    String entry = s.substring(i, length)  + s.substring(0, i);
                    cyclicentries.add(entry);
                    as = as  + entry + "\n";
                }

                shifts.setText(as);


                Collections.sort(cyclicentries);
                String encoding = "";

                for (String ss : cyclicentries){
                   encoding = encoding + ss.substring(ss.length() - 1, ss.length());
                }

                encodedTextview.setText(encoding);


            }
        });


    }
}
