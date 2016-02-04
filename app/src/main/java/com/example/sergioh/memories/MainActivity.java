package com.example.sergioh.memories;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String TAG="JAVIER";
    Button btn_facebook;
    String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_facebook = (Button)findViewById(R.id.btn_loginFacebook);

        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crear instancia para AsyncCallWS
                AsyncCallWS task = new AsyncCallWS();
                //ejecuta
                task.execute();
            }
        });
    }
    public void toCreateAccount(View v){

        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }
    public void toLoginAccount(View v){

        Intent i = new Intent(this, Login_account.class);
        startActivity(i);

    }
    public void toLoginFacebook() throws IOException, XmlPullParserException {

        HttpClient cliente = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://api.stage.viidit.com/api/account/loginwithfacebook");
        post.setHeader("content-type", "application/x-www-form-urlencoded");
        post.setHeader("fbtoken", "CAACEdEose0cBAIMrgIIZBLKQnSR5DZCZCkZA8532FGobBcVwjjbAA9uCEywiIso1GuboD" +
                "YSwSI4BBNtbVft9TfbSNqn8LGvHYTb5MZAW3crEhpkRJcVgBqZAttTizGclxg0ZBIrZC35Yjy16uZCNryNLPvH7w4xTABb3eB" +
                "RF1lYErXhCPEwUZA9Gbt2ZClsBAZAoenPn9PdLtR3wZBHMuLwpZC2indSj1ZCQNB4gzIZD");
        post.setHeader("deviceid", "1234");
        post.setHeader("apikey", "algo");
        HttpResponse resp = cliente.execute(post);
        String respStr = EntityUtils.toString(resp.getEntity());
        ParserXML parserXML = new ParserXML();
        mensaje = parserXML.Parsear(respStr);


    }
    public void toForgot_Password(View v){

        Intent i = new Intent(this, Forgot_Password.class);
        startActivity(i);

    }
    public void toTerms_Conditions(View v){

        Intent i = new Intent(this, Terms_Conditions.class);
        startActivity(i);

    }
    public void toPrivacy_Policy(View v){

        Intent i = new Intent(this, Privacy_Policy.class);
        startActivity(i);

    }
    public void toCamera(View v){

        Intent i = new Intent(this, Camera.class);
        startActivity(i);

    }
    @Override
    public void onBackPressed() {

        finish();
    }

    //Tarea Asincronica
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            try {
                toLoginFacebook();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            Toast.makeText(getApplicationContext(), mensaje,Toast.LENGTH_LONG).show();


        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            Toast.makeText(getApplicationContext(),"primer",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }
}
