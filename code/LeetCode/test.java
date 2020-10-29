import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {

    public static void main(String[] args) throws IOException {
//        Set<String> ss = new HashSet<>();
//        Map<Integer, Integer> mm = new HashMap<>();

        URL urlObj = new URL("http://10.47.0.109/hugo/v3/offerParticipants/nb:mp:0488bd8322:a1b3fdb1ff924c35");
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
        int responseCode = httpCon.getResponseCode();




    }

}
