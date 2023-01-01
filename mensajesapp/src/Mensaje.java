public class Mensaje {
    int idMensaje;
    String mensaje;
    String autorMensaje;
    String fechaMensaje;

    public Mensaje(){

    }

    public Mensaje(String mensaje, String autor, String fecha){
        this.mensaje = mensaje;
        this.autorMensaje = autor;
        this.fechaMensaje = fecha;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutorMensaje() {
        return autorMensaje;
    }

    public void setAutorMensaje(String autorMensaje) {
        this.autorMensaje = autorMensaje;
    }

    public String getFechaaMensaje() {
        return fechaMensaje;
    }

    public void setFechaaMensaje(String fechaaMensaje) {
        this.fechaMensaje = fechaaMensaje;
    }
}
