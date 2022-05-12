package com.sportdataapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportdataapi.sportdata.CountryResponse;
import com.sportdataapi.sportdata.LeagueResponse;
import com.sportdataapi.sportdata.SeasonResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {
    public static final String BASEURL = "https://app.sportdataapi.com/api/v1/soccer";
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final String APIKEY= "1f8177a0-ba72-11ec-b83e-09e34675ae35";

    public static String apiRequest(String url){
        final Request request = new Request.Builder()
                .url(BASEURL + url)
                .addHeader("apikey",APIKEY)
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

    static int getCountry_id() throws IOException {
        int country_id = 0;
        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data specify the country you would like to see ");
        String Name = tc.nextLine();
        HashMap<String, Integer> id = new HashMap<>();
        try {
            String url = BASEURL + "/countries?"  + "&continent";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper countryMapper = new ObjectMapper();
            CountryResponse countryResponse = countryMapper.readValue(responseBodyString, CountryResponse.class);
            for(int i = 0; i<countryResponse.getData().size();i++)
            {
                id.put(countryResponse.getData().get(i).getName(), countryResponse.getData().get(i).getCountry_id());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         if(id.get(Name) ==null) {
             System.out.println("Invalid country,Please enter a valid country");
         }
         else
             country_id = id.get(Name);

        return country_id;
    }

    static int getLeague_id() throws IOException{
        int league = 0;
        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data specify the League you would like to see ");
        String leagueName = tc.nextLine();
        HashMap<String,Integer> league_id = new HashMap<>();
        try{
            String url = BASEURL +"/leagues?" + APIKEY;
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper leagueMapper = new ObjectMapper();
            LeagueResponse leagueResponse = leagueMapper.readValue(responseBodyString, LeagueResponse.class);
            for(int i = 0; i<leagueResponse.getData().size();i++)
            {
                league_id.put(leagueResponse.getData().get(i).getName(),leagueResponse.getData().get(i).getLeague_id());
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }

        if(league_id.get(leagueName) ==null) {
            System.out.println("Invalid League,Please enter a valid League");
        }
        else
            league = league_id.get(leagueName);

        return league;
    }

    static int getSeason_id() throws IOException{
        int season =0;
        Scanner tc = new Scanner(System.in);
        System.out.println("To view the data specify the Season you would like to see ");
        String seasonName = tc.nextLine();

        HashMap<String,Integer> season_id = new HashMap<>();
        try{
            int league_id = Utils.getLeague_id();
            String url = BASEURL +  "/seasons?"  + "&league_id=" + league_id + "\"";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper seasonMapper = new ObjectMapper();
            SeasonResponse seasonResponse = seasonMapper.readValue(responseBodyString, SeasonResponse.class);
            for(int i = 0; i<seasonResponse.getData().size();i++)
            {
                season_id.put( seasonResponse.getData().get(i).getName(),seasonResponse.getData().get(i).getSeason_id());
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }

        if(season_id.get(seasonName) ==null) {
            System.out.println("Invalid Season,Please enter a valid Season");
        }
        else
            season = season_id.get(seasonName);
        return season;
    }

}
