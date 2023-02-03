package com.example.horario.datos;

import com.example.horario.modelo.Materia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Horario {

    private Date time;
    private String dia;
    private ArrayList<Materia> materias;

    public Horario() {
        this.time = new Date();
        this.dia = getDiaSemana();

        materias = new ArrayList<Materia>();
    }
    public String getDiaSemana() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format( time );
    }
    public int getDiaSemana( String name ) {
        switch ( name ) {
            case "lunes": return 0;
            case "martes": return 1;
            case "miércoles": return 2;
            case "jueves": return 3;
            case "viernes": return 4;
            default: return 0;
        }
    }
    public ArrayList<Materia> getMaterias( String dia ) {
        switch ( dia ) {
            case "lunes":

                materias.add( new Materia("Laboratorio de Programacion de Sistemas", 7, 9, "LAB PROG 2" ));
                materias.add( new Materia("Probabilidad y Estadistica", 9, "A - 14" ) );
                materias.add( new Materia("Animacion Tridimensional", 10, 12, "LAB PROG A" ));
                materias.add( new Materia("Quimica IV", 12, "A - 14" ) );
                materias.add( new Materia("Laboratorio Ingles VI", 1, "LAB 1 INGLES" ) );
                materias.add( new Materia("Ingles VI", 2, "A - 14" ) );

                break;
            case "martes":

                materias.add( new Materia("Fisica IV LAB", 7, 9, "LAB FISICA"));
                materias.add( new Materia("Probabilidad y Estadistica", 9, "A - 14" ) );
                materias.add( new Materia("Aplicaciones Multimedia", 10, 12,"LAB GRAF") );
                materias.add( new Materia("Fisica IV", 12, "A - 14") );
                materias.add( new Materia("Ingles VI", 1, 3, "A - 14") );

                break;
            case "miércoles":

                materias.add( new Materia("Orientación Juvenil y Profesional IV", 7, 9, "A - 14"));
                materias.add( new Materia("Probabilidad y Estadistica", 9, "A - 14" ) );
                materias.add( new Materia("Programación de Sistemas", 10, "A - 14") );
                materias.add( new Materia("Animación Tridimensional", 11, "LAB PROG A") );
                materias.add( new Materia("Quimica IV", 12, "A - 3") );
                materias.add( new Materia("LAB QUIMICA IV", 1, 3, "LAB QUIMICA") );

                break;
            case "jueves":

                materias.add( new Materia("LAB. Programacion de Sistemas", 7, 9, "LAB PROG 2"));
                materias.add( new Materia("Probabilidad y Estadistica", 9, "A - 14" ) );
                materias.add( new Materia("Seguridad Informatica", 10, 12, "LAB PROG 1") );
                materias.add( new Materia("Animación Tridimensional", 12, "LAB PROG A") );
                materias.add( new Materia("Ingles VI LAB.", 1, "LAB PROY") );
                materias.add( new Materia("Ingles VI", 2, "A - 14") );

                break;
            case "viernes":

                materias.add( new Materia("Aplicaciones Multimedia", 7, 9, "LAB GRAF"));
                materias.add( new Materia("Probabilidad y Estadistica", 9, "A - 14" ) );
                materias.add( new Materia("Animación Tridimensional", 10, "LAB PROG A") );
                materias.add( new Materia("Seguridad Informatica", 11, "LAB PROG 2") );
                materias.add( new Materia("Fisica IV", 12, 2, "A - 14") );

                break;
        }
        return materias;
    }

}
