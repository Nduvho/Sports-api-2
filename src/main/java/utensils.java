import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class utensils {
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
}
