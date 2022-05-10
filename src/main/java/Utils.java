import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;



public class Utils {

    public static String apiRequest(String url){
        final Request request = new Request.Builder()
                .url(url)
                .get().build();
        OkHttpClient client = new OkHttpClient();

        try {
            Response resp = client.newCall(request).execute();
            return resp.body().string();
        } catch (IOException e) {
           // logger.info("API Request Exception Message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }


    static JSONArray apiCall(StringBuilder readLine, URL urlForGetRequest1) throws IOException {
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest1.openConnection();
        conection.setRequestMethod("GET");
        conection.connect();
        int responseCode = conection.getResponseCode();

        if(responseCode !=200)
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        else
        {
            Scanner sc = new Scanner(urlForGetRequest1.openStream());
            while(sc.hasNext())
            {
                readLine.append(sc.nextLine());
            }
            sc.close();
        }

        JSONObject jobj = new JSONObject(readLine.toString());
        JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

        System.out.println("These are all the data you asked to view");
        System.out.println("\n");

        return jsonarr_1;
    }

    static int country_id() throws IOException {

        HashMap<String, Integer> id = new HashMap<>();

        String countryName;

        id.put("1",112);
        id.put("Albania",9);
        id.put("Algeria",10);
        id.put("Andorra",11);
        id.put("Angola",12);
        id.put("Argentina",13);
        id.put("Armenia",14);
        id.put("Australia",15);
        id.put("Austria",16);
        id.put("Azerbaijan",17);
        id.put("Bahrain",18);
        id.put("Bangladesh",19);
        id.put("Belarus",20);
        id.put("Belgium",21);
        id.put("Bolivia",22);
        id.put("Bosnia & Herzegovina",23);
        id.put("Botswana",24);
        id.put("Brazil",25);
        id.put("Bulgaria",26);
        id.put("Cambodia",27);
        id.put("Cameroon",28);
        id.put("Canada",29);
        id.put("Chile",30);
        id.put("China",31);
        id.put("Colombia",32);
        id.put("Congo",33);
        id.put("Costa Rica",34);
        id.put("Croatia",35);
        id.put("Cyprus",36);
        id.put("Czech Republic",37);
        id.put("Denmark",38);
        id.put("Ecuador",39);
        id.put("Egypt",40);
        id.put("El Salvador",41);
        id.put("England",42);
        id.put("Estonia",43);
        id.put("Faroe Islands",44);
        id.put("Finland",45);
        id.put("France",46);
        id.put("Georgia",47);
        id.put("Germany",48);
        id.put("Ghana",49);
        id.put("Gibraltar",50);
        id.put("Greece",51);
        id.put("Guatemala",52);
        id.put("Honduras",53);
        id.put("Hong Kong",54);
        id.put("Hungary",55);
        id.put("Iceland",56);
        id.put("India",57);
        id.put("Indonesia",58);
        id.put("Iran",59);
        id.put("Ireland",60);
        id.put("Israel",61);
        id.put("Italy",62);
        id.put("Ivory Coast",63);
        id.put("Jamaica",64);
        id.put("Japan",65);
        id.put("Jordan",66);
        id.put("Kazakhstan",67);
        id.put("Kenya",68);
        id.put("Kosovo",69);
        id.put("Kuwait",70);
        id.put("Latvia",71);
        id.put("Lebanon",72);
        id.put("Liechtenstein",73);
        id.put("Lithuania",74);
        id.put("Luxembourg",75);
        id.put("Malaysia",76);
        id.put("Malta",77);
        id.put("Mexico",78);
        id.put("Moldova",79);
        id.put("Montenegro",80);
        id.put("Morocco",81);
        id.put("Myanmar",82);
        id.put("Netherlands",83);
        id.put("New Zealand",84);
        id.put("Nicaragua",85);
        id.put("Nigeria",86);
        id.put("North Macedonia",87);
        id.put("Northern Ireland",88);
        id.put("Norway",89);
        id.put("Oman",90);
        id.put("Pakistan",91);
        id.put("Palestine",92);
        id.put("Panama",93);
        id.put("Paraguay",94);
        id.put("Peru",95);
        id.put("Philippines",96);
        id.put("Poland",97);
        id.put("Portugal",98);
        id.put("Qatar",99);
        id.put("Republic of Korea",100);
        id.put("Romania",101);
        id.put("Russia",102);
        id.put("Rwanda",103);
        id.put("San Marino",104);
        id.put("Saudi Arabia",105);
        id.put("Scotland",106);
        id.put("Senegal",107);
        id.put("Serbia",108);
        id.put("Singapore",109);
        id.put("Slovakia",110);
        id.put("Slovenia",111);
        id.put("South Africa",112);
        id.put("Spain",113);
        id.put("Sweden",114);
        id.put("Switzerland",115);
        id.put("Tanzania",116);
        id.put("Thailand",117);
        id.put("Trinidad and Tobago",118);
        id.put("Tunisia",119);
        id.put("Turkey",120);
        id.put("Uganda",121);
        id.put("Ukraine",122);
        id.put("United Arab Emirates",123);
        id.put("Uruguay",124);
        id.put("USA",125);
        id.put("Uzbekistan",126);
        id.put("Venezuela",127);
        id.put("Vietnam",128);
        id.put("Wales",129);
        id.put("Zambia",130);
        id.put("Zimbabwe",131);
        id.put("Ethiopia",132);

        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data on the default country press 1 or specify the country you would like to see ");
        countryName = tc.nextLine();

        return id.get(countryName);
    }
}
