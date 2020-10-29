package Popular.Easy.Array;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.sun.deploy.net.HttpResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class test {

    public static void main(String[] args) throws IOException {

//        List<String> strings = Arrays.asList("nb:mp:04f7efb828:ff6b5354dc1a4d58","nb:mp:04f7efb828:407ab39949a24f81","nb:mp:04f7efb828:3823bdcccd1c481d","nb:mp:04f7efb828:4bfa745d7a5240c0","nb:mp:04f7efb828:ad1dfd5d12124cf5","nb:mp:04f7efb828:b333044d953e41c8","nb:mp:04f7efb828:6254f778b668459d","nb:mp:04f7efb828:86f6e33391154ce4","nb:mp:04f7efb828:bb97c7e185904126","nb:mp:04f7efb828:ae71dc47422f4e7b","nb:mp:04f7efb828:c3ed4349cecb4743","nb:mp:04f7efb828:65197f0c516746e7","nb:mp:04f7efb828:907377ccd1c342ef","nb:mp:04f7efb828:d6bf081d655c499d","nb:mp:04f7efb828:1bab0953c6704e7f","nb:mp:04f7efb828:ba2a568b7c3148f7","nb:mp:04f7efb828:24f9879c72ff4f1d","nb:mp:04f7efb828:26647b2b5a954054","nb:mp:04f7efb828:n4npipdsyfoqq1a8","nb:mp:04f7efb828:83741e7cebf54f46","nb:mp:04f7efb828:2c9ac8a10e104182","nb:mp:04f7efb828:b2d964d40dee4a73","nb:mp:04f7efb828:5c62c25056644ef3","nb:mp:04f7efb828:bebdc9fecedf41d9","nb:mp:04f7efb828:dcbcc649285a4f00","nb:mp:04f7efb828:4712c0d127074745","nb:mp:04f7efb828:2f543ff03ba041b2","nb:mp:04f7efb828:2f14f38e63b44907","nb:mp:04f7efb828:4e91b17b255a48a1","nb:mp:04f7efb828:b3f3b615d1204c43","nb:mp:04f7efb828:45c94efa80734111","nb:mp:04f7efb828:e4c5959f35f6444c","nb:mp:04f7efb828:fa39e63467c94dca","nb:mp:04f7efb828:0ddde0ae31b84b4e","nb:mp:04f7efb828:47382a886c684ee0","nb:mp:04f7efb828:69490f5ceb7f4d42","nb:mp:04f7efb828:9c0e064fe1c94945","nb:mp:04f7efb828:cded67446bb74e66","nb:mp:04f7efb828:5ffd910af963447f","nb:mp:04f7efb828:440dc78e4697431f","nb:mp:04f7efb828:63426449afc7461d","nb:mp:04f7efb828:8e530620dbcc4a2a","nb:mp:04f7efb828:5f032d2236e64734","nb:mp:04f7efb828:2284400108504a00","nb:mp:04f7efb828:a4ee6ccbd6f2465c","nb:mp:04f7efb828:1b8e8b9a0dfc4ca5","nb:mp:04f7efb828:47d4201ec85e44c2","nb:mp:04f7efb828:247e5100019a4eb2","nb:mp:04f7efb828:ppnphdvy2ojy1yvv","nb:mp:04f7efb828:5e1c78befdd94f77","nb:mp:04f7efb828:49b52a8ad7de4e02","nb:mp:04f7efb828:3b517a834db14f14","nb:mp:04f7efb828:99f8604701e94017","nb:mp:04f7efb828:1f1733caa7a741bd","nb:mp:04f7efb828:84a2604c7e7c4aa9","nb:mp:04f7efb828:069cf27e01854617","nb:mp:04f7efb828:132f2bf68b934df8","nb:mp:04f7efb828:i4ova5z5fw2y99zb","nb:mp:04f7efb828:514b910633984990","nb:mp:04f7efb828:e22acd55a5f64597","nb:mp:04f7efb828:z3sep30s7jq3y72n","nb:mp:04f7efb828:0aa988cf724e40cf","nb:mp:04f7efb828:5037f07f2b514ae6","nb:mp:04f7efb828:132efc3f04a64d24","nb:mp:04f7efb828:10b3763539cc4b05","nb:mp:04f7efb828:382b6085cb78407a","nb:mp:04f7efb828:282659fb17c9431d","nb:mp:04f7efb828:312bc29f201a41eb","nb:mp:04f7efb828:151a47515f824a0b","nb:mp:04f7efb828:14b12470afeb4d30","nb:mp:04f7efb828:22778b01ea194660","nb:mp:04f7efb828:19ff4f990a554017","nb:mp:04f7efb828:5bc84311f7d343d3","nb:mp:04f7efb828:25c5e15f752f47f4","nb:mp:04f7efb828:2e932660eb1b4a7e","nb:mp:04f7efb828:437b3c54575347df","nb:mp:04f7efb828:21ecdaf2395d48de","nb:mp:04f7efb828:d3d718d67b3843d4","nb:mp:04f7efb828:tn3vdv1szuz71cnn","nb:mp:04f7efb828:d704bdeb111d45e0","nb:mp:04f7efb828:663aff22fd2741e0","nb:mp:04f7efb828:d6746658e75d4c49","nb:mp:04f7efb828:80e09639c4244f29","nb:mp:04f7efb828:2563218ddea848bf","nb:mp:04f7efb828:54da34a73b474a16","nb:mp:04f7efb828:5718e93450544690","nb:mp:04f7efb828:07784a4dfd4246dd","nb:mp:04f7efb828:494f1ce606c54c81","nb:mp:04f7efb828:ef23ecd656304b7e","nb:mp:04f7efb828:9c1e8943s76cpdsh","nb:mp:04f7efb828:fcb473b8a01e4d2a","nb:mp:04f7efb828:ab73c4f9262e4c80","nb:mp:04f7efb828:1da3598128dd4b3d","nb:mp:04f7efb828:cd631b8264c94e17","nb:mp:04f7efb828:8rj0ua4ewktxikti","nb:mp:04f7efb828:e87a13ae15cb4bb7","nb:mp:04f7efb828:dd49534fceba4f97","nb:mp:04f7efb828:45ee50e0a8704ff8","nb:mp:04f7efb828:608c1103a48f4310","nb:mp:04f7efb828:f485819b9bc7443c","nb:mp:04f7efb828:53ac305c99504c6e","nb:mp:04f7efb828:558837618b9f4de9","nb:mp:04f7efb828:6bcec608ec764e42","nb:mp:04f7efb828:de8a36f16a304542","nb:mp:04f7efb828:1890890aebe04eef","nb:mp:04f7efb828:0bfbf5983b5349f0","nb:mp:04f7efb828:6ecc44a520964c1f","nb:mp:04f7efb828:93e9cb4fecc1466d","nb:mp:04f7efb828:28c49578dfb84d5e","nb:mp:04f7efb828:24775c755c014b01","nb:mp:04f7efb828:6c092a8770874c3b","nb:mp:04f7efb828:0178eaa849e74395","nb:mp:04f7efb828:f81000f7cc0241a0","nb:mp:04f7efb828:2eda99e36b414b37","nb:mp:04f7efb828:38fda53dc24342b7","nb:mp:04f7efb828:559c505b81ff4e3d","nb:mp:04f7efb828:3d6bf65128984f2c","nb:mp:04f7efb828:9d5ccebf39aa40a8","nb:mp:04f7efb828:e7ce0e61f0924afb","nb:mp:04f7efb828:4cdabd10ef754669");
//
//        for(String ss: strings) {
//            URL urlObj = new URL("http://10.47.0.109/hugo/v3/offerParticipants/"+ss);
//            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
//            con.setRequestMethod("GET");
//            int responseCode = con.getResponseCode();
////        System.out.println("GET Response Code :: " + responseCode);
//            if (responseCode == HttpURLConnection.HTTP_OK) { // success
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        con.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                // print result
////            System.out.println(response.toString());
//                JSONObject obj = new JSONObject(response.toString());
//                String refId = obj.getJSONObject("listingClassification").getJSONObject("classifications").getJSONObject("PRIMARY").getJSONObject("entityCollection").getString("referenceId");
////                System.out.print(ss);
////                System.out.print(" - ");
//                System.out.print(refId);
//                System.out.print("\n");
////                        System.out.println(response.toString());
//            } else {
//                System.out.println("GET request not worked");
//            }
//        }

        List<String> strings2 = Arrays.asList("31368401","31368402","31368434","31368464","31368470","31368476","31368498","31368503","31368513","31368541","31368546","31368559","31368572","31368669","31368670","31368714","31368724","31368732","31368750","31368757","31368769","31368771","31368818","31368823","31368860","31368864","31368871","31368890","31368892","31368902","31368906","31368921","31368951","31368969","31368984","31368988","31369002","31369064","31369075","31369076","31369080","31369097","31369098","31369128","31369146","31369169","31369203","31369227","31369236","31369250","31369262","31369266","31369331","31369377","31369404","31369406","31369415","31369417","31369443","31369475","31369505","31369532","31369555","31369561","31369625","31369632","31369664","31369678","31369687","31369700","31369708","31369786","31369805","31369823","31369824","31369855","31369917","31369948","31369950","31369967","31370043","31370053","31370073","31370079","31370094","31370103","31370110","31370138","31370161","31370166","31370211","31370213","31370217","31370250","31370257","31370278","31370320","31370339","31370375","31370629","31370652","31370666","31370667","31370719","31370761","31370823","31370828","31370876","31370936","31370952","31370969","31370991","31371346","31371418","31371441","31371471","31371668","31372375","31372865","31373195");
        Unirest.setTimeouts(0, 0);
        for(String ss2: strings2){
            System.out.println(ss2);
            Unirest.setTimeouts(0, 0);
//            Unirest.post("http://10.47.1.225/victor/admin/rebuild/"+ss2)
//                    .header("Content-Type", "application/json")
//                    .body("{\n\t\"adminId\": 1\n}");

            Unirest.put("http://10.47.2.156/jobs/unsidelineJob/"+ss2);
        }








    }
}
