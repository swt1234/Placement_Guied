package com.example.placement_guied_fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static  MainActivity m;
    TextView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=findViewById(R.id.Question);
        m=this;
        MyDb3 m=new MyDb3();
        m.execute();
    }

    public void next(View view)
    {
        Intent in=new Intent(this,companies.class);
        startActivity(in);
    }

    public void check(View view) {
        Button b= (Button) view;
        TextView t1=findViewById(R.id.Question);
        String s=b.getText().toString();
        String s1=t1.getText().toString();
        MyDb2 m=new MyDb2();
        m.execute(s1,s);
    }
}
