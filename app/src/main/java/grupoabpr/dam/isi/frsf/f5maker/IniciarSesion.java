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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
            Toast.makeText(getApplicationContext(),"Eligió iniciar",Toast.LENGTH_SHORT).show();
            inicio.setVisibility(View.VISIBLE);
            iniciar.setVisibility(View.VISIBLE);

        }
        else if(valorIntent == 2){
            Toast.makeText(getApplicationContext(),"Eligió registrar",Toast.LENGTH_SHORT).show();
            registro.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
        }

        final Boolean inicioValido;

        //Agregar lógica de validación de datos para iniciar sesión
        inicioValido = true;
        final Boolean registroValido;
        //Agregar lógica de validación de registro
        registroValido = true;


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inicioValido){
                    //currentUser = new Usuario();
                    Intent intentInicio = new Intent(getApplicationContext(), MainActivity.class);
                // intentInicio.putExtra("usuarioActual", (Serializable) currentUser);
                startActivity(intentInicio);
                }
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registroValido) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String stringEmail = email.getText().toString();
                    String stringPassword = password.getText().toString();

                    DatabaseReference usuarioRef = database.getReference("Usuario");//esto es la direccion de donde vas a guardar los usuarios, en tu caso seria usuarios

                    Map<String, Object> childUpdate = new HashMap<>();

                    childUpdate.put(stringEmail,stringPassword);//aca vas a poner la clave que podrias poner el id del usuario te recomiendo que hagas esta funcion nombre.hashcode() te da un numero dependiendo el nombre y en
//valor vas a poner el usuario q queres crear
                    usuarioRef.updateChildren(childUpdate);//aca vas agregar el usaurio a la base

                    Intent intentRegistro = new Intent(getApplicationContext(), ActividadPrincipal.class);
                    startActivity(intentRegistro);
                }
            }
        });
        }

}
