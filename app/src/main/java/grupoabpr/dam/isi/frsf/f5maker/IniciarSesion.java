package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

//import com.google.firebase.auth.FirebaseAuth;


public class IniciarSesion extends AppCompatActivity implements Serializable{

    private TextView inicio;
    private TextView registro;
    private Button iniciar;
    private Button registrar;
    private Intent intent;
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

        Boolean inicioValido;

        //Agregar lógica de validación de datos para iniciar sesión
        inicioValido = true;
        Boolean registroValido = true;
        //Agregar lógica de validación de registro
        registroValido = true;

        if(inicioValido){
            iniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //currentUser = new Usuario();
                    Intent intentInicio = new Intent(getApplicationContext(),MainActivity.class);
                   // intentInicio.putExtra("usuarioActual", (Serializable) currentUser);
                    startActivity(intentInicio);
                }
            });


        }

        else if(registroValido){
            registrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentRegistro = new Intent(getApplicationContext(),ActividadPrincipal.class);
                    startActivity(intentRegistro);
                }
            });
        }
    }
}
