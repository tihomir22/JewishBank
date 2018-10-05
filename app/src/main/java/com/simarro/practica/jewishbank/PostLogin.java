package com.simarro.practica.jewishbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PostLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
        String nombre= getIntent().getStringExtra("user");
        String pass= getIntent().getStringExtra("pass");
        TextView tv=findViewById(R.id.nombre);
        TextView tv2=findViewById(R.id.pass);

        tv.setText(nombre);
        tv2.setText(pass);

    }

    public void cerrar(View view) {
        this.finish();
    }
}
