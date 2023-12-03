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
public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    // Constructor del adaptador que recibe los datos de Firebase.
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    // Método para establecer los datos en cada elemento de la lista.
    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        // Establece el texto en los TextView correspondientes.
        holder.Dia.setText(model.getDia());
        holder.Tipo.setText(model.getTipo());

        // Carga la imagen.
        Glide.with(holder.imagen.getContext()).load(model.getIMG()).placeholder(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark).error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imagen);
    }

    // Método llamado al crear un nuevo elemento de la lista.
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Muestra la vista del elemento de la lista.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    // Clase interna que representa cada elemento de la lista.
    class myViewHolder extends RecyclerView.ViewHolder {
        TextView Dia, Tipo;
        ImageView imagen;

        // Constructor que inicializa las vistas dentro del elemento de la lista.
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            Dia = (TextView) itemView.findViewById(R.id.diatext);
            Tipo = (TextView) itemView.findViewById(R.id.tipotext);
            imagen = itemView.findViewById(R.id.imagen);
        }
    }
}

