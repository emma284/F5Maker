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
    private Vector<String> nombreGrupos = new Vector<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_grupos);

        lista = (ListView)findViewById(R.id.lista2);


        intent = getIntent();
        //tengo el mail del usuario que se loggeó:
        mailDeUsuario = intent.getExtras().getString("usuario");



        DatabaseReference usuarioRef2 = database.getReference("Grupo");
        usuarioRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                grupos.removeAll(grupos);
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Grupo grupo= s.getValue(Grupo.class);
                    grupos.add(grupo);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        nombreGrupos.clear();
        for(Grupo g : grupos){

            for(String s : g.getIntegrantes()){
                if(mailDeUsuario.equals(s)){
                    nombreGrupos.add(g.getNombre());
                }
            }
        }

       // String[] algo = {"grupo1","grupo2","grupo3","grupo5","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7","grupo4","grupo7"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nombreGrupos);

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
