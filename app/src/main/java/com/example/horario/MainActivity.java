package com.example.horario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.horario.datos.Horario;
import com.example.horario.modelo.AdaptadorMaterias;
import com.example.horario.modelo.Materia;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Horario horario;
    private TextView dia_semana;
    private RecyclerView recyclerView;
    private Spinner spinner;
    private String[] dias;
    private Resources res;
    private String dia;
    private ArrayList<Materia> materias;
    private ArrayAdapter<String> spinner_adapter;
    private AdaptadorMaterias adaptadorMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horario = new Horario();
        res     = getResources();
        dia  = horario.getDiaSemana();
        dias = res.getStringArray( R.array.dias_semana );
        materias = horario.getMaterias( dia );

        dia_semana   = findViewById( R.id.dia_semana );
        spinner      = findViewById( R.id.spinner );
        recyclerView = findViewById( R.id.recyclerView );

        // Creamos el adaptador para el spinner.
        spinner_adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, dias );
        spinner_adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter( spinner_adapter );

        // Actualizamos el textView al dia que es.
        dia_semana.setText( dia );

        // Mostramos en el Spinner el dia mostrado
        spinner.setSelection( horario.getDiaSemana( dia ) );

        adaptadorMaterias = new AdaptadorMaterias( this, materias );
        adaptadorMaterias.setResources( getResources() );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setAdapter( adaptadorMaterias );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.menu_aceptar:
                Intent i = new Intent( this, DiaHorarioActivity.class );
                i.putExtra("dia", spinner.getSelectedItem().toString().toLowerCase(Locale.ROOT) );
                startActivity( i );
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }
}