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

    }

    public static void editarMensaje(){

    }
}
