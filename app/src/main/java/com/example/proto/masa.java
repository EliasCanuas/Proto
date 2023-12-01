package com.example.proto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class masa extends AppCompatActivity {

    RecyclerView recyclerView;
    masaAdapter MasaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);

        recyclerView = findViewById(R.id.rvm);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<masaModel> options =
                new FirebaseRecyclerOptions.Builder<masaModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Masa"), masaModel.class)
                        .build();

        MasaAdapter = new masaAdapter(options);
        recyclerView.setAdapter(MasaAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MasaAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MasaAdapter.stopListening();
    }
}
