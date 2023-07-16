import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader urlReader = new URLReader("https://diia.gov.ua/");
        char[] buffer = new char[1024];
        StringBuilder builder = new StringBuilder();

        int charsRead;
        while((charsRead = urlReader.read(buffer, 0, buffer.length)) != -1) {
            builder.append(buffer, 0, charsRead);
        }

        System.out.println(builder);

        FileWriter fileWriter = new FileWriter("index.html");
        fileWriter.write(builder.toString());
    }
}
