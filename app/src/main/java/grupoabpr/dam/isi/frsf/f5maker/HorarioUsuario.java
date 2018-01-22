package grupoabpr.dam.isi.frsf.f5maker;

import java.util.Vector;



public class HorarioUsuario {
    Vector<Vector<Boolean>> horario;

    public HorarioUsuario() {
        Vector aux = new Vector<Boolean>(12);
        Vector matriz = new Vector<Vector<Boolean>>();
        for(int i=0;i<7;i++){
            matriz.add(aux);
        }
        this.horario = matriz;
    }
}
