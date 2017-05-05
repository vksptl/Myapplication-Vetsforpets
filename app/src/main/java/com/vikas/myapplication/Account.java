package com.vikas.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Account extends AppCompatActivity {
    String email,password,fJSON,url,fname,lname;
    Button b1;
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textView1=(TextView)findViewById(R.id.at1);
        textView2=(TextView)findViewById(R.id.at2);
        textView3=(TextView)findViewById(R.id.at3);
        Intent intent=getIntent();
        email=intent.getStringExtra("email");

        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertToDatabase(email);
            }
        });
        email=intent.getStringExtra("email");

        url="http://vetsforpets.000webhostapp.com/retrieve1.php?email="+email;

        getJSON(url);

    }

    private void getJSON(final String url) {
        class GetJSON extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //Toast.makeText(Signin.this,url,Toast.LENGTH_LONG).show();
                loading = ProgressDialog.show(Account.this, "Please Wait...", null, true, true);
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                //Toast.makeText(Signin.this,s,Toast.LENGTH_LONG).show();
                super.onPostExecute(s);

                fJSON=s;


                parseJSON(fJSON);
                loading.dismiss();
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);




    }






    public void parseJSON(String jsonval){

        Toast.makeText(Account.this, "yo is " + jsonval, Toast.LENGTH_SHORT).show();

        try {
            JSONObject ob=new JSONObject(jsonval);
            JSONArray ar=ob.getJSONArray("result");


            JSONObject h=ar.getJSONObject(0);
            fname= h.getString("fname");
            lname=h.getString("lname");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        finally {
            textView1.setText(fname);
            textView2.setText(lname);
            textView3.setText(email);
        }
    }


    private void insertToDatabase(final String email ){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", email));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("https://vetsforpets.000webhostapp.com/deleteapp.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(getApplicationContext(),"Your Appointment has been Cancelled", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(email);
    }





}
