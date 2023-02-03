package com.example.horario;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horario.datos.Horario;
import com.example.horario.modelo.AdaptadorMaterias;
import com.example.horario.modelo.Materia;

import java.util.ArrayList;

public class DiaHorarioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorMaterias adapter;
    private ArrayList<Materia> materias;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_dia_horario );

        Bundle extras = getIntent().getExtras();
        String dia = extras.getString("dia", "lunes");
        Horario h = new Horario();
        materias = h.getMaterias( dia );

        adapter = new AdaptadorMaterias( this, materias );
        recyclerView = findViewById( R.id.recycler_view );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setAdapter( adapter );
    }
}
