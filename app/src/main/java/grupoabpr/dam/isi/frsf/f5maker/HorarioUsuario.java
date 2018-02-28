package grupoabpr.dam.isi.frsf.f5maker;

import java.util.Vector;



public class HorarioUsuario {
    Vector<Vector<Boolean>> horario;

    public HorarioUsuario() {
        Vector aux = new Vector<Boolean>(12);
        for(int i=0;i<12;i++){
            aux.insertElementAt(false,i);
        }
        Vector matriz = new Vector<Vector<Boolean>>();
        for(int i=0;i<7;i++){
            matriz.add(aux);
        }
        this.horario = matriz;
    }
}
