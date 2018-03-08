package grupoabpr.dam.isi.frsf.f5maker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Grupo implements Serializable{


    private String id;
    private String administrador;
    private String nombre;
    private HorarioGrupo horario;
    private ArrayList<String> integrantes;

    public ArrayList<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<String> integrantes) {
        this.integrantes = integrantes;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public HorarioGrupo getHorario() {
        return horario;
    }

    public void setHorario(HorarioGrupo horario) {
        this.horario = horario;
    }

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



    public Grupo(String nombre,String administrador,HorarioGrupo horario,ArrayList<String> integrantes) {
        this.id = String.valueOf(nombre.hashCode());
        this.nombre = nombre;
        this.administrador = administrador;
        this.horario = horario;
        this.integrantes = new ArrayList<>();
        this.integrantes.addAll(integrantes);
    }

    public Grupo() {

    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id='" + id + '\'' +
                ", administrador='" + administrador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horario=" + horario +
                ", integrantes=" + integrantes +
                '}';
    }

}
