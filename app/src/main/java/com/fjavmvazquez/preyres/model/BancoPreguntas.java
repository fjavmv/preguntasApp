package com.fjavmvazquez.preyres.model;


import com.fjavmvazquez.preyres.R;
import java.util.ArrayList;

public class BancoPreguntas {

    public static ArrayList<Preguntas> getPeliculas(){
        ArrayList<Preguntas> pelicula = new ArrayList<>();
        pelicula.add(new Preguntas(R.string.question_1_p, false));
        pelicula.add(new Preguntas(R.string.question_2_p,false));
        pelicula.add(new Preguntas(R.string.question_3_p,true));
        pelicula.add(new Preguntas(R.string.question_4_p,true));
        return pelicula;
    }

    public static ArrayList<Preguntas> getSeries(){
        ArrayList<Preguntas> serie = new ArrayList<>();
        serie.add(new Preguntas(R.string.question_1_s, false));
        serie.add(new Preguntas(R.string.question_2_s, false));
        serie.add(new Preguntas(R.string.question_3_s, false));
        serie.add(new Preguntas(R.string.question_4_s, false));
        return serie;
    }


    public static ArrayList<Preguntas> getAnimes(){
        ArrayList<Preguntas> anime = new ArrayList<>();
        anime.add(new Preguntas(R.string.question_1_a, false));
        anime.add(new Preguntas(R.string.question_2_a, false));
        anime.add(new Preguntas(R.string.question_3_a, true));
        anime.add(new Preguntas(R.string.question_4_a, false));
        anime.add(new Preguntas(R.string.question_5_a, true));
        anime.add(new Preguntas(R.string.question_6_a, true));
        return anime;
    }

    public static ArrayList<Preguntas> getMusica(){
        ArrayList<Preguntas> musica = new ArrayList<>();
        musica.add(new Preguntas(R.string.question_1_m, false));
        musica.add(new Preguntas(R.string.question_2_m, false));
        musica.add(new Preguntas(R.string.question_3_m, false));
        musica.add(new Preguntas(R.string.question_4_m, false));
        return musica;
    }

}
