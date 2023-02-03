package com.example.horario.modelo;

public class Materia {
    private String nombre;
    private final int horaInicio;
    private final int horaTermino;
    private String salon;

    public Materia(String nombre, int horaInicio, int horaTermino, String salon ) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.salon = salon;
    }
    public Materia( String nombre, int horaInicio, String salon ) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaTermino = horaInicio + 1;
        this.salon = salon;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @apiNote
     * Retorna la hora en que inicia la clase
     * */
    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraTermino() {
        return horaTermino;
    }
}
