package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//import com.google.firebase.auth.FirebaseAuth;


public class IniciarSesion extends AppCompatActivity implements Serializable{

    private TextView inicio;
    private TextView registro;
    private Button iniciar;
    private Button registrar;
    private Intent intent;
    private EditText email;
    private EditText password;

    private int valorIntent;
    private Usuario currentUser;
    //private FirebaseAuth mAuth;


    private Boolean bandera = false;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        inicio = (TextView)findViewById(R.id.tituloIniciarSesion);
        registro = (TextView)findViewById(R.id.tituloRegistrarse);
        iniciar = (Button)findViewById(R.id.botonIniciarSesion2);
        registrar = (Button)findViewById(R.id.botonRegistrarse2);
        registro.setVisibility(View.GONE);
        registrar.setVisibility(View.GONE);
        inicio.setVisibility(View.GONE);
        iniciar.setVisibility(View.GONE);

        email = (EditText)findViewById(R.id.editTextEmail1);
        password = (EditText)findViewById(R.id.editTextPassword);

        //mAuth = FirebaseAuth.getInstance();

        intent = getIntent();

        valorIntent = intent.getExtras().getInt("login");

        if(valorIntent == 1){

            inicio.setVisibility(View.VISIBLE);
            iniciar.setVisibility(View.VISIBLE);

        }
        else if(valorIntent == 2){

            registro.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
        }




        iniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (1==1/*existeUsuario(email.getText().toString())*/) {

                    Intent intentInicio = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intentInicio);
                    finish();
                }
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!existeUsuario(email.getText().toString())) {
                    String stringEmail = email.getText().toString();
                    String stringPassword = password.getText().toString();

                    DatabaseReference usuarioRef = database.getReference("Usuario");

                    currentUser = new Usuario(stringEmail,stringPassword);

                    Map<String, Object> childUpdate = new HashMap<>();


                    childUpdate.put(currentUser.getId(),currentUser);
                    usuarioRef.updateChildren(childUpdate);

                    Intent intentRegistro = new Intent(getApplicationContext(), ActividadPrincipal.class);
                    startActivity(intentRegistro);
                    finish();
                }
            }
        });
        }


    Boolean existeUsuario(final String stringEmail){
        bandera = false;
        DatabaseReference usuarioRef = database.getReference("Usuario");
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Usuario usuario = s.getValue(Usuario.class);
                    if(usuario.getMail().toString().equals(stringEmail) && !bandera){
                        bandera = true;
                        //currentUser=usuario;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return bandera;
    }
}
