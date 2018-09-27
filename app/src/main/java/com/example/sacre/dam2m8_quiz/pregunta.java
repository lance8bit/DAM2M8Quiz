package com.example.sacre.dam2m8_quiz;

public class pregunta {

    private int preguntaId;
    private boolean respPregunta;

    public pregunta(int idPreg, boolean resPreg){
        preguntaId = idPreg;
        respPregunta = resPreg;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public boolean isRespPregunta() {
        return respPregunta;
    }

    public void setRespPregunta(boolean respPregunta) {
        this.respPregunta = respPregunta;
    }
}
