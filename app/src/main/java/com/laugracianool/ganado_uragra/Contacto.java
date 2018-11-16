package com.laugracianool.ganado_uragra;

public class Contacto {
    private String id;
    private String nombre, telefono, correo, finca;

    public Contacto(){
    }
    public Contacto (String id, String nombre, String telefono, String correo, String finca){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.finca = finca;
    }

}

