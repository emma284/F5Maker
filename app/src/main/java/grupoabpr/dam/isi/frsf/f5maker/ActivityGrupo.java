package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityGrupo extends AppCompatActivity implements Serializable {
        private TextView titulo;
        private ListView listaIntegrantes;
        private Grupo grupo;
        private ArrayAdapter<String> adaptador;
        private Button botonArmarPartido;
        private Button verHorario;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grupo);
            titulo = (TextView)findViewById(R.id.tituloActivityGrupo);
            listaIntegrantes = (ListView)findViewById(R.id.listViewIntegrantesGrupo);
            botonArmarPartido = (Button)findViewById(R.id.buttonArmarPartidoGrupo);
            verHorario = (Button)findViewById(R.id.buttonVerHorarios);
            //Recuperar grupo elegido y nombre del grupo
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                grupo = (Grupo)extras.getSerializable("nombreGrupo");
            }
            titulo.setText(grupo.getNombre());

            adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,grupo.getIntegrantes());
            listaIntegrantes.setAdapter(adaptador);


            


            verHorario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent grupo = new Intent (getApplicationContext(),NuestrosHorarios.class);
                    startActivity(grupo);
                }
            });

        }
}
