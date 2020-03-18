package com.example.agendacontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BBDD){
        BBDD.execSQL("CREATE TABLE contactos(id_contacto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL, telefono TEXT NOT NULL, cargo TEXT NOT NULL," +
                "email  TEXT NOT NULL )");

        BBDD.execSQL("CREATE TABLE empresas(id_empresa INTEGER PRIMARY KEY AUTOINCREMENT," +
                "contactoId INTEGER NOT NULL, direccion TEXT NOT NULL, telefono TEXT NOT NULL," +
                "nombre TEXT NOT NULL, sector TEXT NOT NULL ,FOREIGN KEY (contactoId) REFERENCES contactos(id_contacto))");

        BBDD.execSQL("CREATE TABLE servicios(id_servicio INTEGER PRIMARY KEY AUTOINCREMENT," +
                "contactoEmpresa INTEGER NOT NULL, empresaId INTEGER NOT NULL, horas INTEGER NOT NULL," +
                "direccion TEXT NOT NULL, nombreCliente TEXT," +
                " FOREIGN KEY (contactoEmpresa) REFERENCES contactos(id_contacto), " +
                "FOREIGN KEY (empresaId) REFERENCES empresas(id_empresa))");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
