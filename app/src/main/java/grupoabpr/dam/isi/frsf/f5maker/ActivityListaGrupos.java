package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

public class ActivityListaGrupos extends AppCompatActivity implements  View.OnClickListener  , RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener{
    private ListView lista;
    private Button crearGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_grupos);

        lista = (ListView)findViewById(R.id.lista2);

        String[] algo = {"grupo1","grupo2","grupo3","grupo5","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,algo);

       // lista.setOnItemClickListener(this);
        //lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        lista.setAdapter(adaptador);


        crearGrupo = (Button)findViewById(R.id.botonCrearGrupo);
        crearGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCrearGrupo = new Intent (getApplicationContext(),CrearGrupo.class);
                startActivity(intentCrearGrupo);
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
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

    }
}
