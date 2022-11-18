package com.fjavmvazquez.preyres.model;

public class Preguntas {

    private int mPreguntaId;
    private  boolean mRespuestaVerdadero;

    public Preguntas(){

    }
    public Preguntas(int mPreguntaId, boolean mRespuestaVerdadero){
        this.mPreguntaId = mPreguntaId;
        this.mRespuestaVerdadero = mRespuestaVerdadero;
    }

    public void setPreguntaId(int preguntaId) {
        mPreguntaId = preguntaId;
    }

    public int getPreguntaId() {
        return mPreguntaId;
    }

    public void setRespuestaVerdadero(boolean respuestaVerdadero) {
        mRespuestaVerdadero = respuestaVerdadero;
    }

    public boolean isRespuestaVerdadero() {
        return mRespuestaVerdadero;
    }
}
