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


            System.out.println("To view the list of different data press (for leagues) \t 2(for countries) \t  3(for teams) ");
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

                System.out.println("The country name is (" + jsonobj_1.get("name") +") of the continent of (" + jsonobj_1.get("continent")+")"); //+" which has a country code of (" + jsonobj_1.get("country_id") + ") and a country id of (" + jsonobj_1.get("country_code") + ")");

            }



        } catch (IOException e){

            e.printStackTrace();

        }


    }


    private static void teamsRequest() throws IOException{

        HashMap<String, Integer> id = new HashMap<String, Integer>();
        String info = "";
        // add codes
        id.put("1",112);
        id.put("Albania",9);
        id.put("Algeria",10);
        id.put("Andorra",11);
        id.put("Angola",12);
        id.put("Argentina",13);
        id.put("Armenia",14);
        id.put("Argentina",15);
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

        String pattern ="##.##";
        DecimalFormat f = new DecimalFormat(pattern);

        Scanner tc = new Scanner(System.in);

        System.out.println("To view the teams on the default country press 1 or specify the league you would like to see ");
        info = tc.nextLine();

        int country_id= id.get(info);

      //  int id1 = Integer.parseInt(id.get(info));

        try {


            String apikey = "1f8177a0-ba72-11ec-b83e-09e34675ae35";

            String url = "https://app.sportdataapi.com/api/v1/soccer/teams?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=" + country_id + "\"";


            URL urlForGetRequest = new URL(url);

            String readLine = "";
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int responseCode = conection.getResponseCode();

            if (responseCode != 200)
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            else {
                Scanner sc = new Scanner(urlForGetRequest.openStream());
                while (sc.hasNext()) {
                    readLine += sc.nextLine();

                }

                //  System.out.println("\nJSON data in string format");
                //  System.out.println(readLine);
                sc.close();

            }
            JSONObject jobj = new JSONObject(readLine.toString());

            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");


            // System.out.println(jsonarr_1);
            System.out.println("These are all the teams from " + info);
            System.out.println("\n");
            for (int i = 0; i < jsonarr_1.length(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                // JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("data");

                System.out.println("The team name is " + jsonobj_1.get("name"));

            }


        } catch (IOException e){

            e.printStackTrace();

        }
    }



}

