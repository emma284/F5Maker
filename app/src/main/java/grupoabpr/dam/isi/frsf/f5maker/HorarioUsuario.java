package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.Vector;



public class HorarioUsuario implements Serializable {

    Vector<Integer> d;
    Vector<Integer> l;
    Vector<Integer> m;
    Vector<Integer> x;
    Vector<Integer> j;
    Vector<Integer> v;
    Vector<Integer> s;

    public HorarioUsuario() {
        d.add(26);
        l.add(26);
        m.add(26);
        x.add(26);
        j.add(26);
        v.add(26);
        s.add(26);
    }

//    public HorarioUsuario(int a) {
//        if (a == 1) {
//            Vector aux = new Vector<Boolean>();
//
//            //Vector matriz = new Vector<Vector<Boolean>>();
//
//            for(int i=0;i<7;i++){
//                aux.removeAll(aux);
//                for(int j=0;j<12;j++){
//                    aux.add(false);
//                }
//                this.horario.add(aux);
//            }
//        }
//    }
}
