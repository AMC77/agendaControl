package com.example.agendacontrol;

public class ContactosModelo {
    private String nombre,telefono,cargo,email;

    public ContactosModelo(String nombre, String telefono, String cargo, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cargo = cargo;
        this.email = email;
    }

    public ContactosModelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
