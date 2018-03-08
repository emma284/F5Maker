package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MisHorarios extends AppCompatActivity {

    //private GridView grilla;
    private GridView dias;
    private Button modificarHorarios;
    private ListView listaHorarios;
    private Adaptador adapter;
    private List<Fila> listaFilas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_horarios);

        //grilla = (GridView)findViewById(R.id.grillaHorarios);
        dias = (GridView)findViewById(R.id.tituloDias);


        //String[] algo = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91"};
        String[] algo2 = {"Hs","Do","Lu","Ma","Mi","Ju","Vi","Sa"};

        //grilla.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);

        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,algo);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,algo2);

        //grilla.setAdapter(adaptador);
        dias.setAdapter(adaptador2);

        //ArrayList<Adaptador> myList = new ArrayList<Adaptador>();
        //ArrayAdapter<Adaptador> adapter = new ArrayAdapter<Adaptador>(this, R.layout.activity_mis_horarios, myList);
        //grilla.setAdapter(adapter);

        listaHorarios = (ListView) findViewById(R.id.listViewHorarios);
        listaFilas = new ArrayList<>();

        Fila f0 = new Fila("12:00",true,true,false,false,false,false,false);
        Fila f1 = new Fila("13:00",false,false,false,false,false,false,false);
        Fila f2 = new Fila("14:00",false,false,false,false,false,false,false);
        Fila f3 = new Fila("15:00",false,false,false,false,false,false,false);
        Fila f4 = new Fila("16:00",false,false,false,false,false,false,false);
        Fila f5 = new Fila("17:00",false,false,false,false,false,false,false);
        Fila f6 = new Fila("18:00",false,false,false,false,false,false,false);
        Fila f7 = new Fila("19:00",false,false,false,false,false,false,false);
        Fila f8 = new Fila("20:00",false,false,false,false,false,false,false);
        Fila f9 = new Fila("21:00",false,false,false,false,false,false,false);
        Fila f10 = new Fila("22:00",false,false,false,false,false,false,false);
        Fila f11 = new Fila("23:00",false,false,false,false,false,false,false);
        Fila f12 = new Fila("00:00",false,false,false,false,false,false,false);


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


        adapter = new Adaptador(this, listaFilas);
        new Adaptador(MisHorarios.this, listaFilas);
        listaHorarios.setAdapter(adapter);

        modificarHorarios = (Button)findViewById(R.id.botonModificarHorarios);
        modificarHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Boolean> dom = new  ArrayList<Boolean>();
                ArrayList<Boolean> lun = new  ArrayList<Boolean>();
                ArrayList<Boolean> mar = new  ArrayList<Boolean>();
                ArrayList<Boolean> mie = new  ArrayList<Boolean>();
                ArrayList<Boolean> jue = new  ArrayList<Boolean>();
                ArrayList<Boolean> vie = new  ArrayList<Boolean>();
                ArrayList<Boolean> sab = new  ArrayList<Boolean>();


                //int len = grilla.getCount();
                //SparseBooleanArray checked = grilla.getCheckedItemPositions();
                /*
                for (int i = 0; i < len; i++) {
                    int mod = i%7;

                    switch (mod){
                        case 0:
                            dom.add(checked.get(i));
                            break;
                        case 1:
                            lun.add(checked.get(i));
                            break;
                        case 2:
                            mar.add(checked.get(i));
                            break;
                        case 3:
                            mie.add(checked.get(i));
                            break;
                        case 4:
                            jue.add(checked.get(i));
                            break;
                        case 5:
                            vie.add(checked.get(i));
                            break;
                        case 6:
                            sab.add(checked.get(i));
                            break;

                    }
                }*/
            }
        });



    }
}
