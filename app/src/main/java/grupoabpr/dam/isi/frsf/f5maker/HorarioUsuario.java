package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class HorarioUsuario implements Serializable {

    ArrayList<Boolean> domingo;
    ArrayList<Boolean> lunes;
    ArrayList<Boolean> martes;
    ArrayList<Boolean> miercoles;
    ArrayList<Boolean> jueves;
    ArrayList<Boolean> viernes;
    ArrayList<Boolean> sabado;

    public HorarioUsuario() {
        domingo=new ArrayList<>();
        lunes=new ArrayList<>();
        martes=new ArrayList<>();
        miercoles=new ArrayList<>();
        jueves=new ArrayList<>();
        viernes=new ArrayList<>();
        sabado=new ArrayList<>();
        for(int i=0;i<13;i++) {
            domingo.add(false);

            lunes.add(false);

            martes.add(false);

            miercoles.add(false);

            jueves.add(false);

            viernes.add(false);

            sabado.add(false);
        }
        
    }

}
