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
import android.widget.TextView;

public class Create_account extends AppCompatActivity {
    EditText name,first_name,Email,password;
    TextView text_toolbar;
    TextView crear;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        name = (EditText)findViewById(R.id.name);
        first_name = (EditText)findViewById(R.id.first_name);
        Email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        crear = (TextView)findViewById(R.id.btn_create_account);
        text_toolbar = (TextView)findViewById(R.id.text_toolbar);
        text_toolbar.setText("Create a account");
        volver=(Button)findViewById(R.id.btn_volverToolbar);

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

    public void send_CreateAccount(View v){
        String nombre = name.getText().toString();
        String apellido = first_name.getText().toString();
        String email = Email.getText().toString();
        String contraseña = password.getText().toString();
        if(nombre.equalsIgnoreCase("")||apellido.equalsIgnoreCase("")||email.equalsIgnoreCase("")||contraseña.equalsIgnoreCase("")){
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
    public void toTerms_Conditions(View v){

        Intent i = new Intent(this, Terms_Conditions.class);
        startActivity(i);

    }
    public void toPrivacy_Policy(View v){

        Intent i = new Intent(this, Privacy_Policy.class);
        startActivity(i);

    }

}
