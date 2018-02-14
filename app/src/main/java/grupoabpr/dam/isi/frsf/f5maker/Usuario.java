package grupoabpr.dam.isi.frsf.f5maker;


public class Usuario {
    private String id;
    private String mail;
    private HorarioUsuario horario;

    @Override
    public String toString() {
        return "Usuario{" +
                "mail='" + mail + '\'' +
                '}';
    }

    public Usuario(String mail) {
        this.mail = mail;
    }
}
