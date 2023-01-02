import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    public static void crearMensajeDB (Mensaje mensaje){
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?, ?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void leerMensajeDB(){
        Conexion dbConnect = new Conexion();

        try(Connection connection = dbConnect.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * from mensajes";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void borraMensajeDB(int id_mensaje){
        Conexion dbConnect = new Conexion();
        try(Connection connection = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje= ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El Mensaje fue borrado");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("El mensaje no pudo ser eliminado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){
        Conexion dbConnect = new Conexion();
        try(Connection connection = dbConnect.getConnection()){
            PreparedStatement ps = null;
            try {
                    String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                    ps = connection.prepareStatement(query);
                    ps.setString(1, mensaje.getMensaje());
                    ps.setInt(2, mensaje.getIdMensaje());
                    ps.executeUpdate();
                System.out.println("Mensaje actualizacon con éxito");
            } catch (SQLException e) {
                System.out.println("Mensaje no actualizado, ocurrió la siguiente excepción: ");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
