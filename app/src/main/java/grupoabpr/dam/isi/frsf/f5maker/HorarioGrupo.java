package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.Vector;



public class HorarioGrupo implements Serializable {


    Vector<Vector<Integer>> horario;

    public HorarioGrupo() {
        Vector aux = new Vector<Integer>(12);
        for(int i=0;i<12;i++){
            aux.insertElementAt(0,i);
        }
        Vector matriz = new Vector<Vector<Integer>>();
        for(int i=0;i<7;i++){
            matriz.add(aux);
        }
        this.horario = matriz;
    }
}
