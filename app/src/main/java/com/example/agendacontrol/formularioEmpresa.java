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

public class formularioEmpresa extends AppCompatActivity {

    private Spinner spinner2;
    private EditText nombre,direccion,telefono,sector;
    private ArrayList<String> nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_empresa);

        nombre =(EditText)findViewById(R.id.et_nombreEmpresa);
        direccion=(EditText)findViewById(R.id.et_direccion);
        telefono=(EditText)findViewById(R.id.et_telefonoEmpresa);
        sector=(EditText)findViewById(R.id.et_sector);
        spinner2=(Spinner)findViewById(R.id.spinner2);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BBDD = admin.getWritableDatabase();

        Cursor fila = BBDD.rawQuery("SELECT nombre FROM contactos",null);
        nombres = new ArrayList<>();
        while(fila.moveToNext()){
            int i=0;
            nombres.add(fila.getString(i));
            i++;
        }

        ArrayAdapter <String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nombres);
        spinner2.setAdapter(adapter);
        BBDD.close();
    }

    public void insertarEmpresa(View view){

        String nombreEmpresa= nombre.getText().toString();
        Integer idContacto= spinner2.getSelectedItemPosition();
        String direccionEmpresa= direccion.getText().toString();
        String telefonoEmpresa = telefono.getText().toString();
        String sectorEmpresa = sector.getText().toString();
        String id=null;


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BBDD = admin.getWritableDatabase();

        if(!nombreEmpresa.isEmpty() && !direccionEmpresa.isEmpty() && !telefonoEmpresa.isEmpty() && !sectorEmpresa.isEmpty()){
            ContentValues valores = new ContentValues();
            valores.put("id_empresa",id);
            valores.put("contactoId",idContacto);
            valores.put("direcccion",direccionEmpresa);
            valores.put("telefono",telefonoEmpresa);
            valores.put("nombre",nombreEmpresa);
            valores.put("sector",sectorEmpresa);

            BBDD.insert("empresa",null,valores);
            nombre.setText("");
            direccion.setText("");
            telefono.setText("");
            sector.setText("");
            BBDD.close();
            Toast.makeText(this, "La empresa ha sido introducida", Toast.LENGTH_SHORT).show();

            Intent home = new Intent(this,homeActivity.class);
            startActivity(home);

        }else {
            Toast.makeText(this, "No pueden quedar campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancelar(View view){
        Intent cancelar = new Intent(this,homeActivity.class);
        startActivity(cancelar);
    }

}
