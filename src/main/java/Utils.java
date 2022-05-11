import Request.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
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

    static int country_id() throws IOException {

        Country country = new Country();
        String countryName = country.getName();
        int country_id = country.getCountry_id();

        HashMap<String, Integer> id = new HashMap<>();


        id.put(countryName,country_id);

        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data specify the country you would like to see ");
        String Name = tc.nextLine();

        Name = countryName;

            return id.get(countryName);
    }
}
