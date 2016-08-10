import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Daniel Copaciu on 7/3/2016.
 * dani.copaciu@gmail.com
 */
public class NewsHttpClient {

    public String getNews(Map<String, String> queryParams) {
        try {
            return sendGet(queryParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sendGet(Map<String, String> queryParams) throws IOException {

        URL obj = getUrl(queryParams);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }

    private URL getUrl(Map<String, String> queryParams) throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder address = new StringBuilder();
        address.append(NewsProperties.getProperty("http.news.address"));
        if (queryParams != null && queryParams.size() > 0) {
            address.append("?");
            int count = 0;
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
                address.append(queryParam.getKey());
                address.append("=");
                address.append(URLEncoder.encode(queryParam.getValue(), "UTF-8"));
                count++;
                if (count < queryParams.size()) {
                    address.append("&");
                }
            }
        }
        return new URL(address.toString());
    }
}
