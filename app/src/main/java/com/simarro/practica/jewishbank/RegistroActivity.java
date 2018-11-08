package com.simarro.practica.jewishbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.simarro.practica.jewishbank.bd.MiBancoOperacional;
import com.simarro.practica.jewishbank.pojo.Cliente;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {


    MiBancoOperacional mbo=null;
     Button btnRegistro=null;
     Button btnCancelar=null;
     EditText nif=null;
    EditText nombre=null;
    EditText apellidos=null;
    EditText claveSeguridad=null;
    EditText email=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        mbo = MiBancoOperacional.getInstance(this);
        //referencias
        this.btnRegistro=findViewById(R.id.btnRegistrar);
        this.btnCancelar=findViewById(R.id.btnCancelar);
        this.nif=findViewById(R.id.editText3);
        this.nombre=findViewById(R.id.editText6);
        this.apellidos=findViewById(R.id.editText7);
        this.claveSeguridad=findViewById(R.id.editText8);
        this.email=findViewById(R.id.editText9);

        this.btnRegistro.setOnClickListener(this);
        this.btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==this.btnRegistro.getId()){
            int id= (int) Math.round(Math.random()*1000);
            String nif= this.nif.getText().toString();
            String nombre=this.nombre.getText().toString();
            String apellidos=this.apellidos.getText().toString();
            String pass=this.claveSeguridad.getText().toString();
            String email=this.email.getText().toString();
            Cliente c=new Cliente(id,nif,nombre,apellidos,pass,email);

            mbo.registrar(c);
            System.out.println("Se ha registrado con exito ! "+c.toString());

        }
        if(v.getId()==this.btnCancelar.getId()){
            this.finish();

        }
    }
}
