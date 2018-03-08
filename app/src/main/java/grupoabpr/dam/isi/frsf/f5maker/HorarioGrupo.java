package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;



public class HorarioGrupo implements Serializable {

    ArrayList<Integer> d;
    ArrayList<Integer> l;
    ArrayList<Integer> m;
    ArrayList<Integer> x;
    ArrayList<Integer> j;
    ArrayList<Integer> v;
    ArrayList<Integer> s;

    public HorarioGrupo() {
        d = new ArrayList<>();
        
        l = new ArrayList<>();
        m = new ArrayList<>();
        x = new ArrayList<>();
        j = new ArrayList<>();
        v = new ArrayList<>();
        s = new ArrayList<>();
        for(int i=0;i<13;i++) {
            d.add(0);
            l.add(0);
            m.add(0);
            x.add(0);
            j.add(0);
            v.add(0);
            s.add(0);
        }
    }



//    ArrayList<ArrayList<Integer>> horario;
//
//    public HorarioGrupo() {
//        Vector aux = new ArrayList<Integer>(12);
//        for(int i=0;i<12;i++){
//            aux.insertElementAt(0,i);
//        }
//        Vector matriz = new ArrayList<ArrayList<Integer>>();
//        for(int i=0;i<7;i++){
//            matriz.add(aux);
//        }
//        this.horario = matriz;
//    }
}
