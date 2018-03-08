package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NuestrosHorarios extends AppCompatActivity {

    //private GridView grilla;
    private GridView dias;
    //private Button modificarHorarios;
    private ListView listaHorarios;
    private Adaptador2 adapter;
    private List<Fila2> listaFilas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestros_horarios);

        dias = (GridView)findViewById(R.id.tituloDias);

        String[] algo2 = {"Hs","Do","Lu","Ma","Mi","Ju","Vi","Sa"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,algo2);

        dias.setAdapter(adaptador);

        listaHorarios = (ListView) findViewById(R.id.listViewHorarios2);
        listaFilas = new ArrayList<>();

        Fila2 f0 = new Fila2("12:00",1,3,5,5,4,5,6);
        Fila2 f1 = new Fila2("13:00",1,3,5,5,4,5,6);
        Fila2 f2 = new Fila2("14:00",1,3,5,5,4,5,6);
        Fila2 f3 = new Fila2("15:00",1,3,5,5,4,5,6);
        Fila2 f4 = new Fila2("16:00",1,3,5,5,4,5,6);
        Fila2 f5 = new Fila2("17:00",1,3,5,5,4,5,6);
        Fila2 f6 = new Fila2("18:00",1,3,5,5,4,5,6);
        Fila2 f7 = new Fila2("19:00",1,3,5,5,4,5,6);
        Fila2 f8 = new Fila2("20:00",1,3,5,5,4,5,6);
        Fila2 f9 = new Fila2("21:00",1,3,5,5,4,5,6);
        Fila2 f10 = new Fila2("22:00",1,3,5,5,4,5,6);
        Fila2 f11 = new Fila2("23:00",1,3,5,5,4,5,6);
        Fila2 f12 = new Fila2("00:00",1,3,5,5,4,5,6);


        listaFilas.add(f0);
        listaFilas.add(f1);
        listaFilas.add(f2);
        listaFilas.add(f3);
        listaFilas.add(f4);
        listaFilas.add(f5);
        listaFilas.add(f6);
        listaFilas.add(f7);
        listaFilas.add(f8);
        listaFilas.add(f9);
        listaFilas.add(f10);
        listaFilas.add(f11);
        listaFilas.add(f12);


        adapter = new Adaptador2(this, listaFilas);
        new Adaptador2(NuestrosHorarios.this, listaFilas);
        listaHorarios.setAdapter(adapter);





    }
}
