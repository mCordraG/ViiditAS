package com.example.sergioh.memories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toCreateAccount(View v){

        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }
    public void LoginAccount(View v){

        Intent i = new Intent(this, Login_account.class);
        startActivity(i);

    }
    public void LoginFacebook(View v){

        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }
    public void Terms_Conditions(View v){

        Intent i = new Intent(this, Terms_Conditions.class);
        startActivity(i);

    }
    public void Privacy_Policy(View v){

        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }
    public void Go_Camera(View v){

        Intent i = new Intent(this, Camera.class);
        startActivity(i);

    }
}
