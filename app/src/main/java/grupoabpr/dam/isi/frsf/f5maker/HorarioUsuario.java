package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.Vector;



public class HorarioUsuario implements Serializable {
    Vector<Vector<Boolean>> horario;

    public HorarioUsuario() {

    }

    public HorarioUsuario(int a) {
        if (a == 1) {
            Vector aux = new Vector<Boolean>();

            //Vector matriz = new Vector<Vector<Boolean>>();

            for(int i=0;i<7;i++){
                aux.removeAll(aux);
                for(int j=0;j<12;j++){
                    aux.add(false);
                }
                this.horario.add(aux);
            }
        }
    }
}
