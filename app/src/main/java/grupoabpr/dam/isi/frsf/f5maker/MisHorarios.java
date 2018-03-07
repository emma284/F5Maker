package grupoabpr.dam.isi.frsf.f5maker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;

public class MisHorarios extends AppCompatActivity {
    private GridView tablaHorarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_horarios);

        tablaHorarios = (GridView)findViewById(R.id.gridViewHorarioUsuario);

    }

}
