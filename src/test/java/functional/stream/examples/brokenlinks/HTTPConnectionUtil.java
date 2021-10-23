package functional.stream.examples.brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import lombok.SneakyThrows;

public class HTTPConnectionUtil {
    @SneakyThrows
    public static int getResponseCode(String address) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(address).openConnection();
        httpURLConnection.setConnectTimeout(8000);
        return httpURLConnection.getResponseCode();
    }
}