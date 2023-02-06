package com.example.horario.modelo;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horario.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdaptadorMaterias extends RecyclerView.Adapter<AdaptadorMaterias.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Materia> lista;
    private static Resources res;
    private int anim_delay;

    public AdaptadorMaterias( Context context, List<Materia> lista ) {
        this.lista = lista;
        inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        anim_delay = 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate( R.layout.elemento_lista, parent, false );
        Animation anim = AnimationUtils.loadAnimation( v.getContext(), R.anim.animacion_lista );

        anim_delay += 100;

        anim.setStartOffset( anim_delay );
        v.startAnimation( anim );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.personaliza( lista.get( position ) );
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    /**
     * @author Mendoza Castañeda José Ricardo.
     * */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, salon, hora;
        public ConstraintLayout layout_element;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById( R.id.nombre );
            salon  = itemView.findViewById( R.id.salon );
            hora   = itemView.findViewById( R.id.hora );
            layout_element = itemView.findViewById( R.id.layout_element );

        }

        public void personaliza( Materia materia ) {
            this.nombre.setText( materia.getNombre() );
            this.salon.setText( materia.getSalon() );
            this.hora.setText( materia.getHoraInicio() + " - " + materia.getHoraTermino() );

            int horaActual = Integer.parseInt( new SimpleDateFormat("hh").format( new Date() ));

            if( horaActual >= materia.getHoraInicio() && horaActual < materia.getHoraTermino() ){
                layout_element.setBackgroundResource( R.color.color_back );
                nombre.setTextColor( res.getColor( R.color.white ) );
                salon.setTextColor( res.getColor( R.color.white_dif ));
                hora.setTextColor( res.getColor( R.color.white ));
            }
        }
    }
    public void setResources( Resources res ) {
        this.res = res;
    }
}
