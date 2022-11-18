package com.fjavmvazquez.preyres.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fjavmvazquez.preyres.R;
import com.fjavmvazquez.preyres.acerca.AcercaDe;
import com.fjavmvazquez.preyres.contacto.Contacto;
import com.fjavmvazquez.preyres.model.BancoPreguntas;
import com.fjavmvazquez.preyres.model.Preguntas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mButtonVerdad;
    private Button mButtonFalso;
    private ImageButton mButtonSiguiente;
    private TextView mTextViewPregunta;
    private ImageButton mButtonAnterior;
    private TextView mTextViewAcerca;
    private TextView mTextViewContacto;
    private Spinner mSpinnerCategorias;
    private int mPreguntaActual = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establecemos la comunicación entre la vista y el controlador
        mButtonVerdad = findViewById(R.id.btnVerdadero);
        mButtonFalso = findViewById(R.id.btnFalso);
        mTextViewPregunta = findViewById(R.id.txtPreguntas);
        mButtonSiguiente = findViewById(R.id.btnSiguiente);
        mButtonAnterior = findViewById(R.id.btnPrevio);
        mTextViewAcerca = findViewById(R.id.txtAcerca);
        mTextViewContacto = findViewById(R.id.txtContacto);
        mSpinnerCategorias = findViewById(R.id.spiCategoria);


        //Eventos onclick
        mButtonVerdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lanzamos Toast si es verdadero
                revisarRespuesta(true);
            }
        });
        //Eventos onclick
        mButtonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lanzamos Toast si es falso
                revisarRespuesta(false);
            }
        });

        mButtonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avanzar();
            }
        });

        mTextViewPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avanzar();
            }
        });

        mButtonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retroceder();
            }
        });

        mTextViewContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
            }
        });
        mTextViewAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });
        //Creamos un ArrayAdapter usando un string array y un layout por default
        ArrayAdapter<CharSequence> adapterCategorias = ArrayAdapter.createFromResource(MainActivity.this,R.array.categorias, android.R.layout.simple_spinner_item);
        //Especificamos el layout que se ocupará cuando la lista de opciones aparesca
        adapterCategorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       //Aplicamos el adapter al sppiner
        mSpinnerCategorias.setAdapter(adapterCategorias);

        mSpinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                option(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        actualizarPregunta();
    }

    private void option(int position){
        switch (position){
            case 1:
                break;
            case 2:
                display("Seleccionaste: ", position);

                break;
            case 3:
                display("Seleccionaste: ", position);

                break;
            case 4:
                display("Seleccionaste: ", position);

                break;
            default:
                break;
        }
    }

    //Metodo de notificaciones
    private void display(int id){
        //(FORMA SIMPLE) Toast.makeText(MainActivity.this,id,Toast.LENGTH_SHORT).show();
        //Forma extensa y personalizada el metodo setGravity no funciona para la API 30 de android en adelante
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
    }

    private void display(String msj, int id){
        //(FORMA SIMPLE) Toast.makeText(MainActivity.this,id,Toast.LENGTH_SHORT).show();
        //Forma extensa y personalizada el metodo setGravity no funciona para la API 30 de android en adelante
        Toast.makeText(this,msj+" "+id,Toast.LENGTH_SHORT).show();
    }

    private void actualizarPregunta() {
        int pregunta = BancoPreguntas.getPeliculas().get(mPreguntaActual).getPreguntaId();
        mTextViewPregunta.setText(pregunta);
    }

    private void avanzar(){
        mPreguntaActual = (mPreguntaActual + 1) % BancoPreguntas.getPeliculas().size();

        actualizarPregunta();
    }

    private void retroceder(){
        mPreguntaActual = (mPreguntaActual - 1 + BancoPreguntas.getPeliculas().size()) % BancoPreguntas.getPeliculas().size();
        actualizarPregunta();
    }

    private void revisarRespuesta(boolean useroption) {
        boolean respuestaVerdadera = BancoPreguntas.getPeliculas().get(mPreguntaActual).isRespuestaVerdadero();
        int mensajeResId = 0;
        if (useroption == respuestaVerdadera) {
            mensajeResId = R.string.correct_toast;
        } else {
            mensajeResId = R.string.incorrect_toast;
        }
        display(mensajeResId);
    }

}