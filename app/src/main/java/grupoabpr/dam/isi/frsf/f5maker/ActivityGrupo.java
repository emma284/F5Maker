package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityGrupo extends AppCompatActivity {
        private TextView titulo;
        private Intent intent;
        private String nombreGrupo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grupo);
            titulo = (TextView)findViewById(R.id.tituloActivityGrupo);
            intent = getIntent();

            nombreGrupo = intent.getExtras().getString("nombreGrupo");
            titulo.setText(nombreGrupo);
        }
}
