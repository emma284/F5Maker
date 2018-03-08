package grupoabpr.dam.isi.frsf.f5maker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CrearGrupo extends AppCompatActivity implements Serializable{
    private EditText integrante;
    private EditText nombreGrupo;
    private Button botonCrearGrupo;
    private Button botonAgregarIntegrante;
    private ListView listaIntegrantes;
    private Usuario currentUser;
    private Grupo grupoACrear;
    private Intent intent;
    private Vector<Usuario> usuarios = new Vector<>();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference grupoReference;
    private Vector<String> mails = new Vector<>();
    private String mailDeUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grupo);

        intent = getIntent();

        mailDeUsuario = intent.getExtras().getString("usuario");
        mails.add(mailDeUsuario);

        DatabaseReference usuarioRef2 = database.getReference("Usuario");
        usuarioRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarios.removeAll(usuarios);
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Usuario usuario = s.getValue(Usuario.class);
                    usuarios.add(usuario);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        integrante = (EditText) findViewById(R.id.editTextIntegrante);
        botonAgregarIntegrante = (Button) findViewById(R.id.buttonAgregarUsuarioGrupo);
        nombreGrupo = (EditText) findViewById(R.id.editTextNombreGrupoCrear);
        botonCrearGrupo = (Button) findViewById(R.id.buttonCrearGrupo);
        listaIntegrantes = (ListView) findViewById(R.id.listaIntegrantes);

        grupoReference = database.getReference("Grupo");

        botonCrearGrupo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String stringNombreGrupo = nombreGrupo.getText().toString();
                if(stringNombreGrupo.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingrese un nombre para su grupo",Toast.LENGTH_SHORT);
                }
                else{
                    HorarioGrupo horario = new HorarioGrupo();
                    ArrayList<String> integrantes = new ArrayList<>();
                    integrantes.addAll(mails);
                    grupoACrear = new Grupo(stringNombreGrupo,mailDeUsuario,horario,integrantes);

                    Map<String, Object> childUpdate = new HashMap<>();

                    childUpdate.put(grupoACrear.getId(), grupoACrear);

                    grupoReference.updateChildren(childUpdate);
                }
            }
        });

        botonAgregarIntegrante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoIntegrante = integrante.getText().toString();
                ArrayAdapter<String> adaptador;
                if(existeUsuario(textoIntegrante)){
                    if(!mails.contains(textoIntegrante))
                    {   mails.add(textoIntegrante);
                        adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,mails);
                        listaIntegrantes.setAdapter(adaptador);}
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario no existente",Toast.LENGTH_SHORT);
                }
            }
        });
    }

    Boolean existeUsuario(String a){
        for(Usuario u : usuarios){
            if(u.getMail().equals(a)){
                return true;
            }
        }
        return false;
    }
}
