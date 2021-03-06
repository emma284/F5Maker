package grupoabpr.dam.isi.frsf.f5maker;


import java.io.Serializable;
import java.util.Vector;

public class Usuario implements Serializable{
    private String id;
    private String mail;
    private String contrasenia;
    private HorarioUsuario horario;



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public HorarioUsuario getHorario() {
        return horario;
    }

    public void setHorario(HorarioUsuario horario) {
        this.horario = horario;
    }


//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "id='" + id + '\'' +
//                ", mail='" + mail + '\'' +
//                ", contrasenia='" + contrasenia + '\'' +
//                ", horario=" + horario +
//                '}';
//    }

    public Usuario(){

    }

    public Usuario(String mail, String contrasenia, HorarioUsuario horario) {
        this.id = String.valueOf(mail.hashCode());
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.horario = new HorarioUsuario();
    }
}
