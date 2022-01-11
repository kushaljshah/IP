package LeetCode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

interface testInterface{
    public void test1();

    public void test2();

    public void test3();
}

public class test {

    public static void main(String[] args) throws IOException {
//        Set<String> ss = new HashSet<>();
//        Map<Integer, Integer> mm = new HashMap<>();

//        URL urlObj = new URL("http://10.47.0.109/hugo/v3/offerParticipants/nb:mp:0488bd8322:a1b3fdb1ff924c35");
//        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
//        int responseCode = httpCon.getResponseCode();

        System.out.println("Hello World!");

        test t = new test();

        String s = "cats";
        System.out.println(s.substring(0));
        System.out.println(s.substring(1));
        System.out.println(s.substring(2));
        System.out.println(s.substring(3));
        System.out.println(s.substring(4));
//
//        t.test1();
//        t.test2();
//        t.test3();



    }


}
