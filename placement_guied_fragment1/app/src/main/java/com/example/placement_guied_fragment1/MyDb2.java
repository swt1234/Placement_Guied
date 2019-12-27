package com.example.placement_guied_fragment1;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class MyDb2 extends AsyncTask<String,String,String> {
    String s1;
    MyDb2()
    {}
    @Override
    protected String doInBackground(String... strings) {
        String rurl="https://mehtaji.000webhostapp.com/project/exam2.php";
        s1=strings[0];
        String s2=strings[1];
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
            String data3= URLEncoder.encode("s2","UTF-8");
            String data4= URLEncoder.encode(s2,"UTF-8");
            String data=data1+"="+data2+"&"+data3+"="+data4;
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
        if(s.equals("true"))
        {
            MyDb1 m=new MyDb1();
            m.execute(s1);
        }
    }
}