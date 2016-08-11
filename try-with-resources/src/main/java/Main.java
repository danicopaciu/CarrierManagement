/**
 * Created by Daniel Copaciu on 8/11/2016.
 * dani.copaciu@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        NewsHttpClient newsHttpClient = new NewsHttpClient();
        new NewsCollector(newsHttpClient).writeNewsToFile();
    }
}
