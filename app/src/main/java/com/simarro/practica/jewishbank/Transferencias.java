package com.simarro.practica.jewishbank;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Transferencias extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    String [] listaCuentas = new String [] {"AL86751639367318444714198669","AL89515635252277023782748302","AL39153296222641598198140883","AL47907501989147671525950076"};
    String [] listaDivisas= new String[]{"€","$","£","\u20BF"};
    ArrayAdapter<String>adaptadorString=null;
    ArrayAdapter<String>adaptadorSpinner=null;
    ArrayAdapter<String>adaptadorDivisas=null;
    GridView gv=null;
    RadioButton radio1=null;
    RadioButton radio2=null;

    Spinner sp=null;
    Spinner spinerdivisas=null;
    Spinner spinnerDentro=null;
    TextView textoCuenta=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencias);
        gv=findViewById(R.id.cuentasGrid);
        adaptadorString=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaCuentas);
        adaptadorSpinner=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,this.listaCuentas);
        this.adaptadorDivisas=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,this.listaDivisas);
        gv.setAdapter(adaptadorString);
        gv.setOnItemClickListener(this);

        //Referencias...
        radio1=findViewById(R.id.radioCpropia);
        radio2=findViewById(R.id.radioCajena);
        sp=findViewById(R.id.spinnerDentro);
        spinerdivisas=findViewById(R.id.spinerDivisas);
        textoCuenta=findViewById(R.id.textCuenta);
        this.spinnerDentro=findViewById(R.id.spinnerDentro);


        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adaptadorSpinner);
        this.spinerdivisas.setAdapter(this.adaptadorDivisas);
        this.spinnerDentro.setAdapter(adaptadorSpinner);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Seleccionaste "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        if(v.getTag().toString().equalsIgnoreCase("radio1")){
            Toast.makeText(this,"le diste al 1",Toast.LENGTH_LONG).show();

            ViewGroup.LayoutParams params = this.sp.getLayoutParams();
            params.width= ActionBar.LayoutParams.MATCH_PARENT;
            params.height= ActionBar.LayoutParams.MATCH_PARENT;
            this.sp.setLayoutParams(params);
            this.sp.setVisibility(View.VISIBLE);

            ViewGroup.LayoutParams params2 = this.textoCuenta.getLayoutParams();
            params2.width= 1;
            params2.height= 1;
            this.textoCuenta.setLayoutParams(params2);
            this.textoCuenta.setVisibility(View.INVISIBLE);


        }

        if(v.getTag().toString().equalsIgnoreCase("radio2")){
            Toast.makeText(this,"le diste al 2",Toast.LENGTH_LONG).show();

            ViewGroup.LayoutParams params = this.textoCuenta.getLayoutParams();
            params.width= ActionBar.LayoutParams.MATCH_PARENT;
            params.height= ActionBar.LayoutParams.MATCH_PARENT;
            this.textoCuenta.setLayoutParams(params);
            this.textoCuenta.setVisibility(View.VISIBLE);

            ViewGroup.LayoutParams params2 = this.sp.getLayoutParams();
            params2.width= 1;
            params2.height= 1;
            this.sp.setLayoutParams(params2);
            this.sp.setVisibility(View.INVISIBLE);
        }

    }
}
