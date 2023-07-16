import java.io.*;
import java.net.URL;

public class URLReader extends Reader {
    private final BufferedReader bufferedReader;

    public URLReader(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return this.bufferedReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        this.bufferedReader.close();
    }
}
