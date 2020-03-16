package com.example.agendacontrol;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class formularioContacto extends AppCompatActivity {

    private EditText nombre,telefono,cargo,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        nombre = (EditText)findViewById(R.id.et_nombre_contacto);
        telefono = (EditText)findViewById(R.id.et_telefono_contacto);
        cargo = (EditText)findViewById(R.id.et_cargo_contacto);
        correo = (EditText)findViewById(R.id.et_correo_contacto);
    }

    public void Entrada(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BBDD = admin.getWritableDatabase();

        String nombre_contacto = nombre.getText().toString();
        String telefono_contacto = telefono.getText().toString();
        String cargo_contacto = cargo.getText().toString();
        String correo_contacto = correo.getText().toString();
        Integer id=null;

        if(!nombre_contacto.isEmpty() && !telefono_contacto.isEmpty() && !cargo_contacto.isEmpty() && !correo_contacto.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("id_contacto",id);
            registro.put("nombre",nombre_contacto);
            registro.put("telefono",telefono_contacto);
            registro.put("cargo",cargo_contacto);
            registro.put("email",correo_contacto);

            BBDD.insert("contactos",null,registro);

            //Cerrar base de datos y limpiar los campos
            BBDD.close();
            nombre.setText("");
            telefono.setText("");
            cargo.setText("");
            correo.setText("");
            Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
            Intent home = new Intent(this,homeActivity.class);
            startActivity(home);

        }else{
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //Boton cancelar
    public void Cancelar(View v){
        Intent cancelar = new Intent(this,homeActivity.class);
        startActivity(cancelar);
    }
}
