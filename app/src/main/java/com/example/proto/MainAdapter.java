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

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        holder.Dia.setText(model.getDia());
        holder.Tipo.setText(model.getTipo());

        Glide.with(holder.imagen.getContext())
                .load(model.getIMG())
                .placeholder(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.imagen);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    class  myViewHolder extends RecyclerView.ViewHolder{
        TextView Dia,Tipo;
        ImageView imagen;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            Dia = (TextView) itemView.findViewById(R.id.diatext);
            Tipo = (TextView) itemView.findViewById(R.id.tipotext);
            imagen = itemView.findViewById(R.id.imagen);
        }
    }
}
