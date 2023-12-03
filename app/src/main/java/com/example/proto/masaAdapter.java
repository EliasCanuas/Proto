package com.example.proto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// Adaptador personalizado para el RecyclerView.
public class masaAdapter extends FirebaseRecyclerAdapter<masaModel, masaAdapter.MyViewHolder> {

    // Constructor del adaptador que recibe los datos de Firebase.
    public masaAdapter(@NonNull FirebaseRecyclerOptions<masaModel> options) {
        super(options);
    }

    // Método para establecer los datos en cada elemento de la lista.
    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull masaModel model) {
        // Establece el texto en los TextView correspondientes.
        holder.Dia.setText(model.getDia());
        holder.Tipo.setText(model.getTipo());

        // Carga la imagen.
        Glide.with(holder.imagen.getContext()).load(model.getIMG()).placeholder(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark).error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imagen);
    }

    // Método llamado al crear un nuevo elemento de la lista.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    // Clase interna que representa cada elemento de la lista.
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Dia, Tipo;
        ImageView imagen;

        // Constructor que inicializa las vistas dentro del elemento de la lista.
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Dia = itemView.findViewById(R.id.Mdiatext);
            Tipo = itemView.findViewById(R.id.Mtipotext);
            imagen = itemView.findViewById(R.id.imagen);
        }
    }
}
