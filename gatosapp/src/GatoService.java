import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GatoService {
    public static void verGatos() throws IOException {
        //1. Vamos a traer los gatos de la API
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        /*MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");*/
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        //2. Quitar el primer y último carácter (corchetes)
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        //3. objeto de la clase Gson
        Gson gson = new Gson();

        Gato gatos = gson.fromJson(elJson, Gato.class);

        //redimensionar la imagen
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(image);

            if (fondoGato.getIconWidth() > 800){
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }

            String menu = "opciones\n" +
                    "1. Ver otra imagen de otro gato\n" +
                    "2. Favorito\n" +
                    "3. Volver\n";
            String botones[] = {"Ver otra imagen", "Favorito", "Volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);

            int seleccion = -1;
            for (int i = 0; i < seleccion; i++) {
                if (opcion.equals(botones[i])){
                    seleccion = i;
                }
                switch (seleccion){
                    case 0:
                        verGatos();
                        break;
                    case 1:
                        favoritoGato(gatos);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void favoritoGato(Gato gato){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\" : \""+gato.getId()+"\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.apiKey)
                    .build();
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void verFavorito(String apikey) {
        
    }
}
