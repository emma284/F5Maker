package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button botonGrupos;
    private Button botonHorarios;
    private Button botonPartido;
    private Button botonEquipos;
    private Usuario currentUser;
    private Intent intent;
    private String mailDeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonGrupos = (Button) findViewById(R.id.botonGrupos);
        botonHorarios = (Button) findViewById(R.id.botonHorarios);
        botonPartido = (Button)findViewById(R.id.botonArmarPartido);
        botonEquipos = (Button)findViewById(R.id.botonSorteoEquipos);


        intent = getIntent();

       mailDeUsuario = intent.getExtras().getString("usuario");


        botonGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grupo = new Intent (getApplicationContext(),ActivityListaGrupos.class);
                grupo.putExtra("usuario",mailDeUsuario);
                startActivity(grupo);
            }
        });

        botonHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent horarios = new Intent (getApplicationContext(),MisHorarios.class);
                horarios.putExtra("usuario",mailDeUsuario);
                startActivity(horarios);
            }
        });

        botonPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent partido = new Intent (getApplicationContext(),ArmarPartido.class);
                partido.putExtra("usuario",mailDeUsuario);
                startActivity(partido);
            }
        });

        botonEquipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent equipos = new Intent (getApplicationContext(),SorteoEquipos.class);
                equipos.putExtra("usuario",mailDeUsuario);
                startActivity(equipos);
            }
        });

    }
}
