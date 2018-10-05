package com.simarro.practica.jewishbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
    }

    public void llamarLogin(View view) {
        startActivity(new Intent(BienvenidaActivity.this, Login.class));
    }

    public void salir(View view) {
        finish();
    }
}
