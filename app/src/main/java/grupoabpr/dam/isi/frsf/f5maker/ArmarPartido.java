package grupoabpr.dam.isi.frsf.f5maker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.Serializable;

public class ArmarPartido extends AppCompatActivity implements Serializable {
    private Spinner spinnerDias;
    private Spinner spinerHoras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armar_partido);
        String [] dias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String [] horarios = {"12","13","14","15","16","17","18","19","20","21","22","23","00"};
        spinnerDias = (Spinner)findViewById(R.id.spinner2);
        spinerHoras = (Spinner)findViewById(R.id.spinner3);

        ArrayAdapter<String> adaptadorDias = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dias);
        ArrayAdapter<String> adaptadorHoras = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        spinnerDias.setAdapter(adaptadorDias);
        spinerHoras.setAdapter(adaptadorHoras);


    }
}
