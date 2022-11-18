package com.fjavmvazquez.preyres.model;

import android.widget.ArrayAdapter;

import com.fjavmvazquez.preyres.R;

import java.util.ArrayList;

public class BancoPreguntas {

    public static ArrayList<Preguntas> getPeliculas(){
        ArrayList<Preguntas> pPeliculas = new ArrayList<>();
        pPeliculas.add(new Preguntas(R.string.preguntas_dos, false));
        pPeliculas.add(new Preguntas(R.string.preguntas_tre,false));
        pPeliculas.add(new Preguntas(R.string.preguntas_cuatro,true));
        pPeliculas.add(new Preguntas(R.string.preguntas_cinco,true));
        return pPeliculas;
    }



    public static Preguntas [] pSeries = {
            new Preguntas(R.string.preguntas_s1,true),
            new Preguntas(R.string.preguntas_s2, false),
            new Preguntas(R.string.preguntas_s3,false),
            new Preguntas(R.string.preguntas_s4,true),
            new Preguntas(R.string.preguntas_s5,true),
            //Aqui pueden haber más preguntas....... Algo así...... :)
    };

    public static Preguntas [] pAnimes = {
            new Preguntas(R.string.preguntas_uno,true),
            new Preguntas(R.string.preguntas_dos, false),
            new Preguntas(R.string.preguntas_tre,false),
            new Preguntas(R.string.preguntas_cuatro,true),
            new Preguntas(R.string.preguntas_cinco,true),
            //Aqui pueden haber más preguntas....... Algo así...... :)
    };

    public static Preguntas [] pMusica = {
            new Preguntas(R.string.preguntas_uno,true),
            new Preguntas(R.string.preguntas_dos, false),
            new Preguntas(R.string.preguntas_tre,false),
            new Preguntas(R.string.preguntas_cuatro,true),
            new Preguntas(R.string.preguntas_cinco,true),
            //Aqui pueden haber más preguntas....... Algo así...... :)
    };


}
