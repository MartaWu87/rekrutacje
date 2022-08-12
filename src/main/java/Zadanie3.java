import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.net.URL;

public class Zadanie3 {

    /**
     * Z publicznego API: https://jsonplaceholder.typicode.com pobierz wszystkie zapisane posty znajdujące się pod adresem
     * https://jsonplaceholder.typicode.com/posts tak by po wywołaniu metody getPosts() można było wypisać wszystkie elementy w konsoli,
     * podobnie jak wypisuje je przeglądarka po wejściu w link.
     * <p>
     * Można skorzystać z dowolnych sposobów pobierania danych z API dostępnych dla języka Java.
     */
    public static void getPosts() throws IOException {
        var url = new URL("https://jsonplaceholder.typicode.com/posts");
        try (var in = url.openStream(); var parser = Json.createParser(in)) {
            parser.next();
            while (parser.hasNext()) {
                var event1 = parser.next();
                if (event1 == JsonParser.Event.START_OBJECT) {
                    while (parser.hasNext()) {
                        var event = parser.next();
                        if (event == JsonParser.Event.KEY_NAME) {
                            switch (parser.getString()) {
                                case "userId":
                                    parser.next();
                                    System.out.printf("userId: %d%n", parser.getInt());
                                    break;
                                case "id":
                                    parser.next();
                                    System.out.printf("id: %d%n", parser.getInt());
                                    break;
                                case "title":
                                    parser.next();
                                    System.out.printf("title: %s%n", parser.getString());
                                    break;
                                case "body":
                                    parser.next();
                                    System.out.printf("body: %s%n%n", parser.getString());
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getPosts();
    }

}