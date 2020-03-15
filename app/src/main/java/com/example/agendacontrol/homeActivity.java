package com.example.agendacontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView txtHome;
        ListView lista;
        List<String> listaServicios;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Colocar el icono del pico y la pala en el action bar
        // Solo visible cuando arranca la aplicacion , no se ve en el blue

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.logo);


        lista = findViewById(R.id.list_home);
        listaServicios = new ArrayList<>();
        listaServicios.add("Antena en sueca");
        listaServicios.add("Fibra en Valencia");
        listaServicios.add("Bordillo en Castellon");
        listaServicios.add("Pintura en Valencia");
        listaServicios.add("...");

        //Adaptador que definirá como se vera la lista

        ArrayAdapter adaptadorandroid = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listaServicios
        );

        // Vinculamos el adaptador a la lista que tiene que mostrar

        lista.setAdapter(adaptadorandroid);

        txtHome = findViewById(R.id.txt_home);
        txtHome.setText("Los trabajos de hoy");
    }
    // Metodo para que aparezca el menu overflow
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    // Metodo para asignar funciones a los items del menu
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.NuevaEmpresa ){
            Intent nuevaEmpresa = new Intent(this,formularioEmpresa.class);
                startActivity(nuevaEmpresa);
        }else if(id == R.id.NuevoContacto){
            Intent nuevoContacto = new Intent(this,formularioContacto.class);
                startActivity(nuevoContacto);
        }else if(id == R.id.NuevoServicio){
            Intent nuevoServicio = new Intent(this,formularioServicio.class);
                startActivity(nuevoServicio);
        }
        return super.onOptionsItemSelected(item);
    }
}
