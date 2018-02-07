package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

public class SorteoEquipos extends AppCompatActivity implements  View.OnClickListener  , RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener{

    private ListView lista;

    private ImageView imagen;

    private Button quitarJugador;
    private Button agregarJugador;
    private Button sortearEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteo_equipos);

        imagen = (ImageView)findViewById(R.id.imagenCancha1);

        lista = (ListView)findViewById(R.id.listaParticipantes);

        String[] algo = {"jugador 1","jugador 2","jugador 3","jugador 4","jugador 5","jugador 6","jugador 7","jugador 8","jugador 9","jugador 10"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,algo);

        lista.setAdapter(adaptador);

        quitarJugador = (Button)findViewById(R.id.botonQuitarJugador);
        quitarJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        agregarJugador = (Button)findViewById(R.id.botonAgregarJugador);
        agregarJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        sortearEquipos = (Button)findViewById(R.id.botonSortearEquiposYa);
        sortearEquipos.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              imagen.setImageResource(R.drawable.cancha21);
              //Intent intentCrearGrupo = new Intent (getApplicationContext(),CrearGrupo.class);
              //startActivity(intentCrearGrupo);
            }
        });



    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
