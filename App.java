import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GutendexBookSearch {

    private static final String BASE_URL = "https://gutendex.com/books";
    private static final Gson gson = new Gson();
    private static final Set<String> searchedBooks = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al buscador de libros en español de Gutendex");
        System.out.println("Ingrese el código de idioma (ES, EN, FR, PT):");
        String languageCode = scanner.nextLine().toUpperCase();

        try {
            searchBooksByLanguage(languageCode);

        } catch (IOException e) {
            System.err.println("Error al realizar la búsqueda: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void searchBooksByLanguage(String languageCode) throws IOException {
        URL url = new URL(BASE_URL + "?languages=" + languageCode);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Error al realizar la solicitud HTTP: " + conn.getResponseCode());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JsonArray booksArray = gson.fromJson(response.toString(), JsonArray.class);

        if (booksArray.size() == 0) {
            System.out.println("No se encontraron libros en el idioma especificado (" + languageCode + ").");
        } else {
            System.out.println("Libros encontrados:");
            for (JsonElement element : booksArray) {
                JsonObject bookObject = element.getAsJsonObject();
                String title = bookObject.get("title").getAsString();

                if (!searchedBooks.contains(title)) {
                    searchedBooks.add(title);
                    displayBookDetails(bookObject);
                    System.out.println("----------------------------------");
                } else {
                    System.out.println("Este libro ya ha sido buscado anteriormente.");
                }
            }
        }

        conn.disconnect();
    }

    private static void displayBookDetails(JsonObject bookObject) {
        String title = bookObject.get("title").getAsString();
        JsonArray authors = bookObject.getAsJsonArray("authors");

        System.out.println("Título: " + title);

        if (authors.size() > 0) {
            System.out.print("Autores: ");
            for (JsonElement authorElement : authors) {
                String authorName = authorElement.getAsJsonObject().get("name").getAsString();
                System.out.print(authorName + ", ");
            }
            System.out.println();
        }

        // Aquí puedes añadir más detalles como fecha de publicación, género, etc.
    }
}
