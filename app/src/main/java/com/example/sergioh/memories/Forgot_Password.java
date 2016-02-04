package com.example.sergioh.memories;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Forgot_Password extends AppCompatActivity {
    Button volver;
    TextView text_toolbar;
    EditText Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        text_toolbar = (TextView)findViewById(R.id.text_toolbar);
        text_toolbar.setText("Forgot Password");
        volver=(Button)findViewById(R.id.btn_volverToolbar);

        Email =(EditText)findViewById(R.id.email_forgotPassword);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }


    public void Send_Email_forgotPassword(View v){
        String email = Email.getText().toString();
        if(email.equalsIgnoreCase("")){
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

            dialogo.setTitle("Error");
            dialogo.setMessage("Ingrese un Email Valido");
            dialogo.setIcon(R.drawable.option2);
            dialogo.setPositiveButton("continuar", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int witch) {
                    dialog.cancel();
                }
            });
            dialogo.create();
            dialogo.show();
        }else{

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }


}
