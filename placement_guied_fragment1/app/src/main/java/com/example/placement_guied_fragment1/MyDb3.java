package com.example.placement_guied_fragment1;

import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

public class MyDb3 extends AsyncTask<String,String,String> {
    static  int timerange=10;
    static  int min=timerange;
    static  int sec=0;
    MyDb3()
    { }
    @Override
    protected String doInBackground(String... strings) {
        String rurl="https://mehtaji.000webhostapp.com/project/exam1.php";
        String s="false";
        try
        {
            URL url=new URL(rurl);
            HttpURLConnection ht= (HttpURLConnection) url.openConnection();
            ht.setRequestMethod("POST");
            ht.setDoOutput(true);
            InputStream is=ht.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            s=br.readLine();
            br.close();
            is.close();
        }
        catch(Exception e){}
        return ""+s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        StringTokenizer st=new StringTokenizer(s,"#");
        int i=0;
        String s1[]=new String[st.countTokens()];
        while (st.hasMoreTokens()) {
            s1[i]=st.nextToken();
            i++;
        }
        TextView t1=MainActivity.m.findViewById(R.id.Question);
        Button b1=MainActivity.m.findViewById(R.id.option1);
        Button b2=MainActivity.m.findViewById(R.id.option2);
        Button b3=MainActivity.m.findViewById(R.id.option3);
        Button b4=MainActivity.m.findViewById(R.id.option4);
        t1.setText(s1[0]);
        b1.setText(s1[1]);
        b2.setText(s1[2]);
        b3.setText(s1[3]);
        b4.setText(s1[4]);
        new CountDownTimer(timerange*60*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                if(sec==0)
                {
                    sec=60;
                    min--;
                }
                TextView t1=MainActivity.m.findViewById(R.id.t1);
                t1.setText(""+min+":"+(--sec));
            }

            public void onFinish() {
                Toast.makeText(MainActivity.m, "no more time left", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}
