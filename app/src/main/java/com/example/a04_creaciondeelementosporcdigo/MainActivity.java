package com.example.a04_creaciondeelementosporcdigo;

import android.content.Intent;
import android.os.Bundle;

import com.example.a04_creaciondeelementosporcdigo.modelos.Alumno;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;


import com.example.a04_creaciondeelementosporcdigo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //1. Contenedor donde mostrar información -> Scroll con un Linear dentro

    //2. Lógica para pintar elementos -> printarElementos();

    //3. Conjunto de datos

    //4. Plantilla para mostrar los datos

    private ArrayList<Alumno> alumnosList;

    private ActivityResultLauncher<Intent> launcherCrearAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        alumnosList = new ArrayList<>();
        inicializaLaunchers();

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearAlumnos.launch(new Intent(MainActivity.this, AddAlumnoActivity.class));
            }
        });
    }

    private void inicializaLaunchers() {
        launcherCrearAlumnos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Alumno alumno = (Alumno) result.getData().getExtras().getSerializable("ALUMNO");
                                alumnosList.add(alumno);
                                pintarElementos();
                            }
                        }
                    }
                }
        );
    }

    private void pintarElementos() {
        binding.content.contenedor.removeAllViews();
        for (Alumno a : alumnosList){

            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View alumnoView = inflater.inflate(R.layout.alumno_model_view, null);

            //View alumnoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.alumno_model_view, null);
            TextView lbNombre = alumnoView.findViewById(R.id.lbNombreAlumnoView);
            TextView lbApellidos = alumnoView.findViewById(R.id.lbApellidosAlumnoView);
            TextView lbCiclo = alumnoView.findViewById(R.id.lbCicloAlumnoView);
            TextView lbNGrupo = alumnoView.findViewById(R.id.lbGrupoAlumnoView);

            lbNombre.setText(a.getNombre());
            lbApellidos.setText(a.getApellidos());
            lbCiclo.setText(a.getCiclo());
            lbNGrupo.setText(String.valueOf(a.getGroup()));
            binding.content.contenedor.addView(alumnoView);
        }
    }
}