package grupoabpr.dam.isi.frsf.f5maker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class ArmarPartido extends AppCompatActivity {
    private Spinner spinnerDias;
    private Spinner spinerHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armar_partido);

        spinnerDias = (Spinner)findViewById(R.id.spinner2);
        spinerHoras = (Spinner)findViewById(R.id.spinner3);


    }
}
