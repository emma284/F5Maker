package grupoabpr.dam.isi.frsf.f5maker;

import java.util.Vector;



public class HorarioGrupo {


    Vector<Vector<Integer>> horario;

    public HorarioGrupo() {
        Vector aux = new Vector<Integer>(12);
        Vector matriz = new Vector<Vector<Integer>>();
        for(int i=0;i<7;i++){
            matriz.add(aux);
        }
        this.horario = matriz;
    }
}
