import java.util.Scanner;

public class MensajeService{
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Autor del mensaje");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajeDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje(){
        MensajeDAO.leerMensajeDB();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje que desea borrar");
        int id_mensaje = sc.nextInt();

        MensajeDAO.borraMensajeDB(id_mensaje);
    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Indica el ID del mensaje que deseas editar");
        int idMensaje = sc.nextInt();

        Mensaje actualización = new Mensaje();
        actualización.setIdMensaje(idMensaje);
        actualización.setMensaje(mensaje);

        MensajeDAO.actualizarMensajeDB(actualización);
    }
}
