package HT8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class MyScanner {
    private final BufferedReader in;
    private StringTokenizer stringTokenizer;

    public MyScanner(InputStream inputStream) {
        in = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int nextInt() throws Exception {
        try {
            String next = stringTokenizer.nextToken();
            return Integer.parseInt(next);
        } catch (NoSuchElementException | NullPointerException e) {
            String nextLine;
            nextLine = in.readLine();
            stringTokenizer = new StringTokenizer(nextLine, " ");
            return nextInt();
        }
    }

    public void close() throws IOException {
        in.close();
    }
}
