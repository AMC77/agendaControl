package com.example.agendacontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactosAdaptador extends RecyclerView.Adapter<ContactosAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre,telefono,cargo,email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.txt_nombre_contacto_tarjeta);
            telefono=(TextView)itemView.findViewById(R.id.txt_cargo_contacto_tarjeta);
            cargo=(TextView)itemView.findViewById(R.id.txt_telefono_contacto_tarjeta);
            email=(TextView)itemView.findViewById(R.id.txt_email_contacto_tarjeta);
        }
    }
    public List<ContactosModelo> contactosLista;
    public ContactosAdaptador(List<ContactosModelo> contactosLista) {
        this.contactosLista = contactosLista;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.codigo.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
