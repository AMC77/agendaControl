package com.example.agendacontrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText etPassword;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        etPassword = findViewById(R.id.et_contrasena);
        btnLogin.setOnClickListener(this);
        txtLogin = findViewById(R.id.txtPrimera);
    }

    //Metodo para guardar la contraseña del usuario en un objeto
    public void Guardar(String userContra){
        String contra = userContra;

        SharedPreferences userPass = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor obj_editor_pass = userPass.edit();
        obj_editor_pass.putString("pass",contra);
        obj_editor_pass.commit();

        Toast.makeText(this, "Contraseña guardada tiger", Toast.LENGTH_SHORT).show();

    }
    // Metodo para comprobar la contraseña que el usuario a guardado

    /*public void Comprueba(View view){
        String contra = etPassword.getText().toString();

        SharedPreferences userPass = getSharedPreferences("user",MODE_PRIVATE);
        String entradaPass = userPass.getString("pass","non");

        if(entradaPass == "non"){
            Guardar(contra);
        }else if(entradaPass.length()==0){
            Toast.makeText(this, "Contraseña no valida", Toast.LENGTH_SHORT).show();
        }else{

        }
    }*/

    @Override
    public void onClick(View v) {

        String pass = etPassword.getText().toString();
        Boolean correctPass = null;
        SharedPreferences obj_userPass = getSharedPreferences("user",MODE_PRIVATE);
        String contenido_obj_userPass = obj_userPass.getString("pass","non");

        if(contenido_obj_userPass == "non"){
            txtLogin.setText("Contraseña guardada");
            Guardar(pass);
            correctPass = true;
        }else if(contenido_obj_userPass.equals(pass)){
            correctPass = true;
        }else{
            correctPass = false;
        }

        if(correctPass){
            Intent intentLogin = new Intent(this,homeActivity.class);
            startActivity(intentLogin);
        }else {
            Toast.makeText(this,"La contraseña no es valida",Toast.LENGTH_SHORT).show();
        }
    }
}
