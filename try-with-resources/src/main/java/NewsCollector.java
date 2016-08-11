import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel Copaciu on 7/3/2016.
 * dani.copaciu@gmail.com
 */
public class NewsCollector {

    private NewsHttpClient newsHttpClient;

    public NewsCollector(NewsHttpClient newsHttpClient) {
        this.newsHttpClient = newsHttpClient;
    }

    private void writeToFile(String news) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("news.txt"))) {
            bufferedWriter.write(news);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeNewsToFile() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("q", NewsProperties.getProperty("http.news.query"));
        queryParams.put("tag", NewsProperties.getProperty("http.news.tag"));
        queryParams.put("api-key", NewsProperties.getProperty("http.news.key"));
        writeToFile(newsHttpClient.getNews(queryParams));
    }
}
