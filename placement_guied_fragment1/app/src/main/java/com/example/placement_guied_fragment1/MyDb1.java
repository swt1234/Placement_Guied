package com.example.placement_guied_fragment1;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.StringTokenizer;

public class MyDb1 extends AsyncTask<String,String,String> {
    MyDb1()
    {}
    @Override
    protected String doInBackground(String... strings) {
        String rurl="https://mehtaji.000webhostapp.com/project/exam3.php";
        String s1=strings[0];
        String s="false";
        try
        {
            URL url=new URL(rurl);
            HttpURLConnection ht= (HttpURLConnection) url.openConnection();
            ht.setRequestMethod("POST");
            ht.setDoOutput(true);
            OutputStream os=ht.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String data1= URLEncoder.encode("s1","UTF-8");
            String data2= URLEncoder.encode(s1,"UTF-8");
            String data=data1+"="+data2;
            bw.write(data);
            bw.flush();
            bw.close();
            os.close();
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
    }
}