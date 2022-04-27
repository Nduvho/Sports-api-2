import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class sportsData {


    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException {
        //System.out.print("hello");
        Boolean stillRunning = true;

        System.out.println("Welcome to the Sports data app");
        System.out.println("\n");
        System.out.println("This app allows you to view the leagues, countries and teams");
        System.out.println("\n");



        do{




            Scanner sc =new Scanner(System.in);

            int data;

            String data_id;
            String league, country, team;


            System.out.println("To view the list of different data press 1.(leagues) \t 2.(countries) \t  3.(teams) ");
            data =sc.nextInt();


            if( data<1|| data>3){
                System.out.println("Please specify a number 1-3 to choose what data you want to display ");
                System.out.println("To view data type in 1.(leagues) \t 2.(countries) \t  3.(teams) ");
                data = sc.nextInt();
            }


            if (data==1)  {


                leagueRequest();

            }

            else if(data==2) {

                countryRequest();
            }
            else if(data==3) {

                teamsRequest();
            }
            System.out.println("\n\n");
            System.out.println("Would you like to check more data on the sports app");
            System.out.println("1.(Yes) \t Or any other integer to close the program");
            if(sc.nextInt() != 1){
                stillRunning = false;
            }


        }while(stillRunning);

        System.out.println("Thank you. You've successfully completed the program");
        System.out.println("\n");
        System.out.println("You may close the session");

    }





    private static void leagueRequest() throws IOException {
        String pattern ="##.##";
        DecimalFormat f = new DecimalFormat(pattern);

        try{
            String apikey = "1f8177a0-ba72-11ec-b83e-09e34675ae35";

            String url = "https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";



            URL urlForGetRequest = new URL(url);

            String readLine = "";
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int responseCode = conection.getResponseCode();

            if(responseCode !=200)
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            else
            {
                Scanner sc = new Scanner(urlForGetRequest.openStream());
                while(sc.hasNext())
                {
                    readLine +=  sc.nextLine();

                }

                //  System.out.println("\nJSON data in string format");
                //  System.out.println(readLine);
                sc.close();

            }
            JSONObject jobj = new JSONObject(readLine.toString());

            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

            // System.out.println(jsonarr_1);
            System.out.println("These are all the leagues you can view data from");
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                // JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("data");

                System.out.println("The league name is (" + jsonobj_1.get("name") + ") with a league code of (" + jsonobj_1.get("league_id") +
                        ") and the country id of (" + jsonobj_1.get("country_id") +")");

            }



        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }



    private static void countryRequest() throws IOException{

        String pattern ="##.##";
        DecimalFormat f = new DecimalFormat(pattern);

        try{
            String apikey = "1f8177a0-ba72-11ec-b83e-09e34675ae35";

            String url = "https://app.sportdataapi.com/api/v1/soccer/countries?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&continent";



            URL urlForGetRequest = new URL(url);

            String readLine = "";
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int responseCode = conection.getResponseCode();

            if(responseCode !=200)
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            else
            {
                Scanner sc = new Scanner(urlForGetRequest.openStream());
                while(sc.hasNext())
                {
                    readLine +=  sc.nextLine();

                }

                //  System.out.println("\nJSON data in string format");
                //  System.out.println(readLine);
                sc.close();

            }
            JSONObject jobj = new JSONObject(readLine.toString());

            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

            Scanner tc = new Scanner(System.in);
            String info = "";

            // System.out.println(jsonarr_1);
            System.out.println("These are all the countries you can view data from");
            System.out.println("\n");

            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                // JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("data");

                System.out.println("The country name is (" + jsonobj_1.get("name") +") of the continent of (" + jsonobj_1.get("continent")+")" +
                        " which has a country code of (" + jsonobj_1.get("country_id") + ") and a country id of (" + jsonobj_1.get("country_code") + ")");

            }



        } catch (IOException e){

            e.printStackTrace();

        }


    }


    private static void teamsRequest() throws IOException{

        String pattern ="##.##";
        DecimalFormat f = new DecimalFormat(pattern);

        try{
            String apikey = "1f8177a0-ba72-11ec-b83e-09e34675ae35";

            String url = "https://app.sportdataapi.com/api/v1/soccer/teams?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=48";



            URL urlForGetRequest = new URL(url);

            String readLine = "";
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int responseCode = conection.getResponseCode();

            if(responseCode !=200)
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            else
            {
                Scanner sc = new Scanner(urlForGetRequest.openStream());
                while(sc.hasNext())
                {
                    readLine +=  sc.nextLine();

                }

                //  System.out.println("\nJSON data in string format");
                //  System.out.println(readLine);
                sc.close();

            }
            JSONObject jobj = new JSONObject(readLine.toString());

            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

            Scanner tc = new Scanner(System.in);
            String info = "";
            System.out.println("To view the teams on the default country press 1 or specify the league you would like to see ");
            info = tc.nextLine();

            // System.out.println(jsonarr_1);
            System.out.println("These are all the teams from " + info);
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                // JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("data");

                System.out.println("The team name is " + jsonobj_1.get("name") + "from");

            }



        } catch (IOException e){

            e.printStackTrace();

        }
    }



}

