package com.example.myapplication;

public class Pregunta {
    private String id;
    private String NuevaPregunta;

    public Pregunta() {
    }

    public Pregunta(String id, String pregunta) {
        this.id = id;
        this.NuevaPregunta = NuevaPregunta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNuevaPregunta() {
        return NuevaPregunta;
    }

    public void setNuevaPregunta(String NuevaPregunta) {
        this.NuevaPregunta = NuevaPregunta;
    }
}
