package com.example.agendacontrol;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class formularioServicio extends AppCompatActivity {

    private EditText direccion,nombreCliente,horas;
    private Spinner nombrEmpresa,nombreContacto;
    private ArrayList<String>nombres;
    private ArrayList<String>empresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_servicio);

        direccion =(EditText)findViewById(R.id.et_direccion_cliente);
        horas = (EditText)findViewById(R.id.et_horas);
        nombreCliente = (EditText)findViewById(R.id.et_nombre_cliente);
        nombrEmpresa = (Spinner)findViewById(R.id.spinnerEmpresa);
        nombreContacto = (Spinner)findViewById(R.id.spinnerContacto);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BBDD = admin.getWritableDatabase();

        Cursor filasEmpresas = BBDD.rawQuery("SELECT nombre FROM empresas",null);
        empresas = new ArrayList<>();
        while(filasEmpresas.moveToNext()){
            int i=0;
            empresas.add(filasEmpresas.getString(i));
            i++;
        }

        Cursor filasContactos = BBDD.rawQuery("SELECT nombre FROM contactos",null);
        nombres = new ArrayList<>();
        while(filasContactos.moveToNext()){
            int i = 0;
            nombres.add(filasContactos.getString(i));
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empresas);
        nombrEmpresa.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nombres);
        nombreContacto.setAdapter(adapter2);
        BBDD.close();
    }

    public void insertarServicio(View view){

        Integer Empresa = nombrEmpresa.getSelectedItemPosition();
        Integer Contacto = nombreContacto.getSelectedItemPosition();
        String direccionCliente = direccion.getText().toString();
        String horas_string = horas.getText().toString();
        Integer horas_int = Integer.parseInt(horas_string);
        String nombre = nombreCliente.getText().toString();
        Integer id= null;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BBDD = admin.getWritableDatabase();

        if(!direccionCliente.isEmpty() && horas_int>0 && !nombre.isEmpty()){
            ContentValues datos = new ContentValues();
            datos.put("id_servicio",id);
            datos.put("contactoEmpresa",Contacto);
            datos.put("empresaId",Empresa);
            datos.put("horas",horas_int);
            datos.put("direccion",direccionCliente);
            datos.put("nombeCliente",nombre);

            BBDD.insert("servicios",null,datos);
            BBDD.close();


            direccion.setText("");
            horas.setText("");
            nombreCliente.setText("");

            Toast.makeText(this, "Servicio introducido", Toast.LENGTH_SHORT).show();

            Intent home = new Intent(this,homeActivity.class);
            startActivity(home);
        }
    }

    public void cancelar(View view){
        Intent cancelar = new Intent(this,homeActivity.class);
    }
}
