import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("---------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear un mensaje \n" +
                    "2. Listar Mensajes \n" +
                    "3. Editar Mensaje \n" +
                    "4. Eliminar Mensaje \n" +
                    "5. Salir");
            System.out.println("");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.editarMensaje();
                    break;
            }
        }while (opcion != 5);
    }
}