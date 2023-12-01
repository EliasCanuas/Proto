package com.example.proto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class masaAdapter extends FirebaseRecyclerAdapter<masaModel, masaAdapter.MyViewHolder> {

    public masaAdapter(@NonNull FirebaseRecyclerOptions<masaModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull masaModel model) {
        holder.Dia.setText(model.getDia());
        holder.Tipo.setText(model.getTipo());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Dia, Tipo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Dia = itemView.findViewById(R.id.Mdiatext);
            Tipo = itemView.findViewById(R.id.Mtipotext);
        }
    }
}
