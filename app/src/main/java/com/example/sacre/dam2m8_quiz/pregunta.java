package com.example.sacre.dam2m8_quiz;

public class pregunta {

    private int preguntaId;
    private boolean respPregunta;
    private String resName;

    public pregunta(int idPreg, boolean resPreg,String drawName){
        preguntaId = idPreg;
        respPregunta = resPreg;
        resName = drawName;
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

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
}
