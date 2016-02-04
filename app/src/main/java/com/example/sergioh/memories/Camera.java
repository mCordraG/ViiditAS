package com.example.sergioh.memories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Camera extends AppCompatActivity {
    //Necesitamos un Boton y un imageView
    private RelativeLayout bt_hacerfoto;
    private ImageView img;
    TextView text_sup;
    Button Cancel,Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_camera);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Cancel = (Button)findViewById(R.id.btn_volverToolbar_camera);
        Next = (Button)findViewById(R.id.btn_NextToolbar_camera);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        text_sup = (TextView)findViewById(R.id.mensaje_sup_camera);
        Bundle bundle = new Bundle();
        text_sup.setText(bundle.get("respuesta").toString());



        //Relacionamos con el XML
        img = (ImageView)this.findViewById(R.id.imageView1);
        bt_hacerfoto = (RelativeLayout) this.findViewById(R.id.RelativeLayout_btn_camera);
        //Añadimos el Listener Boton

        bt_hacerfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent para llamar a la Camara
                Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //Creamos una carpeta en la memeria del terminal
                File imagesFolder = new File(
                        Environment.getExternalStorageDirectory(), "Tutorialeshtml5");
                imagesFolder.mkdirs();
                //añadimos el nombre de la imagen
                File image = new File(imagesFolder, "foto.jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                //Le decimos al Intent que queremos grabar la imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                //Lanzamos la aplicacion de la camara con retorno (forResult)
                startActivityForResult(cameraIntent, 1);
            }});

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Comprovamos que la foto se a realizado
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenada en la memoria
            Bitmap bMap = BitmapFactory.decodeFile(
                    Environment.getExternalStorageDirectory()+
                            "/Tutorialeshtml5/"+"foto.jpg");
            //Añadimos el bitmap al imageView para
            //mostrarlo por pantalla
            img.setImageBitmap(bMap);
        }
    }
    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
