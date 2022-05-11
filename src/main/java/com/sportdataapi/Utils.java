package com.sportdataapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportdataapi.Request.CountryResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static com.sportdataapi.SportsData.APIHEADER;
import static com.sportdataapi.SportsData.BASEURL;

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

        HashMap<String, Integer> id = new HashMap<>();
        try {
            String url = BASEURL + "/countries?" + APIHEADER + "&continent";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper countryMapper = new ObjectMapper();
            CountryResponse countryResponse = countryMapper.readValue(responseBodyString, CountryResponse.class);
            for(int i = 0; i<countryResponse.getData().size();i++)
            {
                id.put(countryResponse.getData().get(i).getName(),countryResponse.getData().get(i).getCountry_id());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data specify the country you would like to see ");
        String Name = tc.nextLine();

        return id.get(Name);
    }
}
