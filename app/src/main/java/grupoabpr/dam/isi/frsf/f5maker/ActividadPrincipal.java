package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActividadPrincipal extends AppCompatActivity {
    Button iniciarSesion;
    Button registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        iniciarSesion = (Button)findViewById(R.id.botonIniciarSesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio = new Intent (getApplicationContext(),IniciarSesion.class);
                inicio.putExtra("login",1);
                startActivity(inicio);
            }
        });

        registrarse = (Button)findViewById(R.id.botonRegistrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent (getApplicationContext(),IniciarSesion.class);
                registro.putExtra("login",2);
                startActivity(registro);
            }
        });

    }
}
