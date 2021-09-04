package functional.stream.examples.brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import lombok.SneakyThrows;

public class HTTPConnectionUtil {
    @SneakyThrows
    public static int getResponseCode(String address) {
        return ((HttpURLConnection) (new URL(address)).openConnection()).getResponseCode();
    }
}