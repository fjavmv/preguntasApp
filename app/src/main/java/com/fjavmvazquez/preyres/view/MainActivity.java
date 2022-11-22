package com.fjavmvazquez.preyres.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fjavmvazquez.preyres.R;
import com.fjavmvazquez.preyres.acerca.AcercaDe;
import com.fjavmvazquez.preyres.contacto.Contacto;
import com.fjavmvazquez.preyres.model.BancoPreguntas;
import com.fjavmvazquez.preyres.model.Preguntas;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button mButtonVerdad;
    private Button mButtonFalso;
    private ImageButton mButtonSiguiente;
    private TextView mTextViewPregunta;
    private ImageButton mButtonAnterior;
    private ImageView mImageViewContacto;
    private ImageView mImageViewAcerca;
    private Spinner mSpinnerCategorias;
    private ImageView mImageViewReto;
    private  TextView mTextViewConteoTrue;
    private  TextView mTextViewConteoFalse;
    private int mPreguntaActual = 0;
    private ArrayList<Preguntas> mPreguntasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Permite ocultar el actionBar
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //inicializamos controles
        inicializarControles();
        //Eventos onclick
        mButtonVerdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPreguntasArrayList == null) {
                    display("Necesitas seleccionar primero una categoria...");
                } else {
                    int conteo = revisarRespuesta(true);
                    mTextViewConteoTrue.setText(String.valueOf(conteo));
                }
            }
        });
        //Eventos onclick
        mButtonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPreguntasArrayList == null) {
                    display("Necesitas seleccionar primero una categoria...");
                } else {
                    int conteo = revisarRespuesta(false);
                    mTextViewConteoFalse.setText(String.valueOf(conteo));
                }
            }
        });

        mButtonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPreguntasArrayList == null) {
                    display("Necesitas seleccionar primero una categoria...");
                } else {
                    avanzar();
                }
            }
        });

        mTextViewPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPreguntasArrayList == null) {
                    display("Necesitas seleccionar primero una categoria...");
                } else {
                    avanzar();
                }
            }
        });

        mButtonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPreguntasArrayList == null) {
                    display("Necesitas seleccionar primero una categoria...");
                } else {
                    retroceder();
                }
            }
        });

        mImageViewContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
            }
        });
        mImageViewAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });
        //Creamos un ArrayAdapter usando un string array y un layout por default
        ArrayAdapter<CharSequence> adapterCategorias = ArrayAdapter.createFromResource(MainActivity.this, R.array.categorias, android.R.layout.simple_spinner_item);
        //Especificamos el layout que se ocupará cuando la lista de opciones aparesca
        adapterCategorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Aplicamos el adapter al sppiner
        mSpinnerCategorias.setAdapter(adapterCategorias);
        mSpinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    mImageViewReto.setImageResource(R.drawable.decision);
                    mTextViewPregunta.setText("Selecciona una categoria...");
                    mPreguntasArrayList = null;
                } else {
                    mPreguntasArrayList = new ArrayList<>(option(position));
                    actualizarPregunta();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //View
    private void inicializarControles() {
        //Establecemos la comunicación entre la vista y el controlador
        mButtonVerdad = findViewById(R.id.btnVerdadero);
        mButtonFalso = findViewById(R.id.btnFalso);
        mTextViewPregunta = findViewById(R.id.txtPreguntas);
        mImageViewReto = findViewById(R.id.imgReto);
        mButtonSiguiente = findViewById(R.id.btnSiguiente);
        mButtonAnterior = findViewById(R.id.btnPrevio);
        mImageViewAcerca = findViewById(R.id.imgBAcerca);
        mImageViewContacto = findViewById(R.id.imgBContacto);
        mSpinnerCategorias = findViewById(R.id.spiCategoria);
        mTextViewConteoTrue = findViewById(R.id.txtPuntuacionTrue);
        mTextViewConteoFalse = findViewById(R.id.txtPuntuacionFalsa);
    }

    //controller
    private ArrayList<Preguntas> option(int position) {
        ArrayList<Preguntas> mPreguntasArray = new ArrayList<>();
        switch (position) {
            case 1:
                mPreguntasArray = new ArrayList<>(BancoPreguntas.getPeliculas());
                mImageViewReto.setImageResource(R.drawable.claqueta);

                break;
            case 2:
                mPreguntasArray = new ArrayList<>(BancoPreguntas.getSeries());
                mImageViewReto.setImageResource(R.drawable.serie);
                break;
            case 3:
                mPreguntasArray = new ArrayList<>(BancoPreguntas.getAnimes());
                mImageViewReto.setImageResource(R.drawable.anime);
                break;
            case 4:
                mPreguntasArray = new ArrayList<>(BancoPreguntas.getMusica());
                mImageViewReto.setImageResource(R.drawable.music);
                break;
            default:
                break;
        }
        return mPreguntasArray;
    }

    //Metodo de notificaciones
    private void display(int id) {
        //(FORMA SIMPLE) Toast.makeText(MainActivity.this,id,Toast.LENGTH_SHORT).show();
        //Forma extensa y personalizada el metodo setGravity no funciona para la API 30 de android en adelante
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    private void display(String msj) {
        //(FORMA SIMPLE) Toast.makeText(MainActivity.this,id,Toast.LENGTH_SHORT).show();
        //Forma extensa y personalizada el metodo setGravity no funciona para la API 30 de android en adelante
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
    }

    //controller
    private void actualizarPregunta() {
        int pregunta = mPreguntasArrayList.get(mPreguntaActual).getPreguntaId();
        mTextViewPregunta.setText(pregunta);
    }

    //controller
    private void avanzar() {
        mPreguntaActual = (mPreguntaActual + 1) % mPreguntasArrayList.size();
        actualizarPregunta();
    }

    //controller
    private void retroceder() {
        mPreguntaActual = (mPreguntaActual - 1 + mPreguntasArrayList.size()) % mPreguntasArrayList.size();
        actualizarPregunta();
    }

    //controller
    private int revisarRespuesta(boolean useroption) {
        boolean respuestaVerdadera = mPreguntasArrayList.get(mPreguntaActual).isRespuestaVerdadero();
        int mensajeResId;
        int valor = 0;
        if (useroption == respuestaVerdadera) {
            valor = contarAcierto(useroption);
            mensajeResId = R.string.correct_toast;
        } else {
            valor = contarFalse(useroption);
            mensajeResId = R.string.incorrect_toast;
        }
        display(mensajeResId);
        return valor;
    }

    private int contarAcierto(boolean respuestaVerdadera) {
        int contarTrue =0;
        if(respuestaVerdadera){
            contarTrue = contarTrue + 1;
        }
        return  contarTrue;
    }

    private int contarFalse(boolean respuestaFalsa) {
        int contarFalse =0;
        if (respuestaFalsa){
            contarFalse = contarFalse + 1;
        }
        return contarFalse;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}