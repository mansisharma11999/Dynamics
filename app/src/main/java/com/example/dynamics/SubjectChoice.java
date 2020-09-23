package com.example.dynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

public class SubjectChoice extends AppCompatActivity {
    TextView login;
    String Name;
    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_choice);
        login=findViewById(R.id.Loginame);
        l1=findViewById(R.id.lv1);
        Intent j=getIntent();
        Name=j.getStringExtra("Name");
        login.setText(Name);
        final String values[]={"English","Computer","Maths","Science","SSc"};
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(values));
        l1.setAdapter(adapter);
    }
}