package grupoabpr.dam.isi.frsf.f5maker;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class ArmarPartido extends AppCompatActivity implements Serializable {
    private Spinner spinnerDias;
    private Spinner spinerHoras;
    private Spinner spinnerGrupos;
    private Usuario currentUser;
    private Button jugar;

    private Vector<Grupo> grupos = new Vector<>();
    private ArrayList<String> nombreGrupos = new ArrayList<>();

    private ArrayAdapter<String> adaptador;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armar_partido);
        String [] dias = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String [] horarios = {"12","13","14","15","16","17","18","19","20","21","22","23","00"};
        spinnerDias = (Spinner)findViewById(R.id.spinner2);
        spinerHoras = (Spinner)findViewById(R.id.spinner3);
        spinnerGrupos = (Spinner)findViewById(R.id.spinnerGrupos);
        jugar = (Button)findViewById(R.id.buttonJugar);

        ArrayAdapter<String> adaptadorDias = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dias);
        ArrayAdapter<String> adaptadorHoras = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,horarios);
        spinnerDias.setAdapter(adaptadorDias);
        spinerHoras.setAdapter(adaptadorHoras);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            currentUser = (Usuario)extras.getSerializable("usuario");
        }


        DatabaseReference grupoRef = database.getReference("Grupo");
        grupoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                grupos.removeAll(grupos);
                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Grupo grupo= s.getValue(Grupo.class);
                    grupos.add(grupo);

                }
                nombreGrupos.removeAll(nombreGrupos);
                Log.d("etiqueta",String.valueOf(grupos.size()));
                for(Grupo g : grupos){

                    for(String s : g.getIntegrantes()){
                        if(currentUser.getMail().equals(s)){
                            nombreGrupos.add(g.getNombre());
                        }
                    }
                }
                adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nombreGrupos);
                spinnerGrupos.setAdapter(adaptador);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder mBuilder;
                NotificationManager mNotifyMgr =(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                int icono = R.drawable.soccer;
                Intent i=new Intent(getApplicationContext(), IniciarSesion.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, 0);

                mBuilder =new NotificationCompat.Builder(getApplicationContext())
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(icono)
                        .setContentTitle("F5-Maker")
                        .setContentText("Partido de "+ spinnerGrupos.getSelectedItem().toString() +" el "+spinnerDias.getSelectedItem().toString() + " a las " +spinerHoras.getSelectedItem().toString()+ " hs.")
                        .setVibrate(new long[] {100, 250, 100, 500})
                        .setAutoCancel(true);



                mNotifyMgr.notify(1, mBuilder.build());
            }
        });


    }
}
