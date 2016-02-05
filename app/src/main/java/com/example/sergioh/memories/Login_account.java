package com.example.sergioh.memories;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login_account extends AppCompatActivity {
    TextView text_toolbar;
    EditText Email,Password;
    ImageButton volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);

        text_toolbar = (TextView)findViewById(R.id.text_toolbar);
        text_toolbar.setText("Log in with email");

        Email =(EditText)findViewById(R.id.email_LoginAccount);
        Password= (EditText)findViewById(R.id.password_loginAccount);

        volver = (ImageButton)findViewById(R.id.btn_volverToolbar);
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
       /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    public void toForgot_Password(View v){

        Intent i = new Intent(this, Forgot_Password.class);
        startActivity(i);

    }
    public void toCreateAccount(View v){

        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }


    public void send_LoginAccount(View v){
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        if(email.equalsIgnoreCase("")||password.equalsIgnoreCase("")){
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

            dialogo.setTitle("Error");
            dialogo.setMessage("Ingrese todos los campos");
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
