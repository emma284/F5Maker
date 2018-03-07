package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.Vector;



public class HorarioGrupo implements Serializable {

    Vector<Integer> d;
    Vector<Integer> l;
    Vector<Integer> m;
    Vector<Integer> x;
    Vector<Integer> j;
    Vector<Integer> v;
    Vector<Integer> s;

    public HorarioGrupo() {
        d.add(26);
        l.add(26);
        m.add(26);
        x.add(26);
        j.add(26);
        v.add(26);
        s.add(26);
    }



//    Vector<Vector<Integer>> horario;
//
//    public HorarioGrupo() {
//        Vector aux = new Vector<Integer>(12);
//        for(int i=0;i<12;i++){
//            aux.insertElementAt(0,i);
//        }
//        Vector matriz = new Vector<Vector<Integer>>();
//        for(int i=0;i<7;i++){
//            matriz.add(aux);
//        }
//        this.horario = matriz;
//    }
}
