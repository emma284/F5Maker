package grupoabpr.dam.isi.frsf.f5maker;

import java.util.Vector;


public class Grupo {
    private String id;
    //private Usuario administrador;
    private String nombre;
    //private HorarioGrupo horario;
    //private Vector<Usuario> integrantes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Grupo(String nombre) {
        this.id = String.valueOf(nombre.hashCode());
        this.nombre = nombre;
    }

    public Grupo() {

    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
