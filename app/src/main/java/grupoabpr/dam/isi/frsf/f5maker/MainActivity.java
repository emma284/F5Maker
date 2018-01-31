package grupoabpr.dam.isi.frsf.f5maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonGrupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonGrupos = (Button) findViewById(R.id.botonGrupos);
        //findViewById(R.id.botonGrupos).setOnClickListener((View.OnClickListener) this);
        botonGrupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grupo = new Intent (getApplicationContext(),ActivityListaGrupos.class);
                startActivity(grupo);
            }
        });

    }
}
