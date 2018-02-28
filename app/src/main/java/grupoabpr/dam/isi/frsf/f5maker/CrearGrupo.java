package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CrearGrupo extends AppCompatActivity implements Serializable{

    private EditText nombreGrupo;
    private Button botonCrearGrupo;
    private ListView listaIntegrantes;
    private Usuario currentUser;
    private String stringNombreGrupo;
    private Grupo grupoACrear;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference grupoReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_grupo);

        nombreGrupo = (EditText)findViewById(R.id.editTextNombreGrupo);
        botonCrearGrupo = (Button)findViewById(R.id.buttonCrearGrupo);
        listaIntegrantes = (ListView)findViewById(R.id.listaIntegrantes);
        stringNombreGrupo = nombreGrupo.getText().toString();
        grupoReference = database.getReference("Grupo");

        botonCrearGrupo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                grupoACrear = new Grupo(stringNombreGrupo);
                Log.d("loquesea",stringNombreGrupo);
                Map<String,Object> childUpdate = new HashMap<>();

                childUpdate.put(grupoACrear.getId(),grupoACrear);
                //grupoReference.push().setValue(grupoACrear);
                grupoReference.updateChildren(childUpdate);
            }
        });
    }
}
