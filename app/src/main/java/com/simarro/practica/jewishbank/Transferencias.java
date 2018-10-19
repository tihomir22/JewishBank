package com.simarro.practica.jewishbank;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Transferencias extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    String [] listaCuentas = new String [] {"AL86751639367318444714198669","AL89515635252277023782748302","AL39153296222641598198140883","AL47907501989147671525950076"};
    ArrayAdapter<String>adaptadorString=null;
    GridView gv=null;
    RadioButton radio1=null;
    RadioButton radio2=null;

    Spinner sp=null;
    TextView textoCuenta=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencias);
        gv=findViewById(R.id.cuentasGrid);
        adaptadorString=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaCuentas);
        gv.setAdapter(adaptadorString);
        gv.setOnItemClickListener(this);

        //Referencias...
        radio1=findViewById(R.id.radioCpropia);
        radio2=findViewById(R.id.radioCajena);
        sp=findViewById(R.id.spinner);
        textoCuenta=findViewById(R.id.textCuenta);


        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Seleccionaste "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        if(v.getTag().toString().equalsIgnoreCase("radio1")){
            ((ViewManager)sp.getParent()).removeView(sp);

        }

        if(v.getTag().toString().equalsIgnoreCase("radio2")){
            ((ViewManager)textoCuenta.getParent()).removeView(textoCuenta);
        }

    }
}
