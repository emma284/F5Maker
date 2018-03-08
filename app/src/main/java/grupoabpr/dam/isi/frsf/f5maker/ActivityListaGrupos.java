package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class ActivityListaGrupos extends AppCompatActivity implements Serializable, View.OnClickListener  , RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener{
    private ListView lista;
    private Button crearGrupo;
    private Intent intent;
    private String mailDeUsuario;

    private Vector<Grupo> grupos = new Vector<>();
    private ArrayList<String> nombreGrupos = new ArrayList<>();


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_grupos);

        lista = (ListView)findViewById(R.id.lista2);

        intent = getIntent();
        //tengo el mail del usuario que se loggeó:
        mailDeUsuario = intent.getExtras().getString("usuario");



        DatabaseReference grupoRef = database.getReference("Grupo");
        grupoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                grupos.clear();
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Grupo grupo= s.getValue(Grupo.class);
                    grupos.add(grupo);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        nombreGrupos.removeAll(nombreGrupos);
        Log.d("etiqueta",String.valueOf(grupos.size()));
        for(Grupo g : grupos){

            for(String s : g.getIntegrantes()){
                if(mailDeUsuario.equals(s)){
                    nombreGrupos.add(g.getNombre());
                }
            }
        }

       String[] algo = {"grupo1","grupo2","grupo3","grupo5","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7"};

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,algo);

       // lista.setOnItemClickListener(this);
        //lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        lista.setAdapter(adaptador);


        crearGrupo = (Button)findViewById(R.id.botonCrearGrupo);
        crearGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCrearGrupo = new Intent (getApplicationContext(),CrearGrupo.class);
                intentCrearGrupo.putExtra("usuario",mailDeUsuario);
                startActivity(intentCrearGrupo);
            }
        });
        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = new String(adaptador.getItem(i));
                Intent intentGrupo = new Intent(getApplicationContext(),ActivityGrupo.class);
                intentGrupo.putExtra("nombreGrupo",seleccion);
                startActivity(intentGrupo);
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
