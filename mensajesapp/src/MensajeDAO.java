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

    public static void borraMensajeDB(){

    }

    public static void actualizarMensajeDB(){

    }
}
