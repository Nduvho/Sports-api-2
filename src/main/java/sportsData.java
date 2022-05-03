import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class sportsData {

    public static void main(String[] args) throws IOException {
        Boolean stillRunning = true;

        System.out.println("Welcome to the Sports data app");
        System.out.println("\n");
        System.out.println("This app allows you to view the leagues, countries and teams");
        System.out.println("\n");

        do{

            Scanner sc =new Scanner(System.in);
            int data;

            System.out.println("To view the list of different data press");
            System.out.println("1.(for leagues)");
            System.out.println("2.(for countries)");
            System.out.println("3.(for teams)");
            System.out.println("4.(for Seasons)");
            System.out.println("5.(for Stages)");
            System.out.println("6.(for Matches)");
            System.out.println("7.(for Players)");
            System.out.println("8.(for Top Scorers)");
            System.out.println("9.(for Bookmakers)");
            System.out.println("10.(for Markets)");
            System.out.println("11.(for Venues)");
            System.out.println("12.(for Referees)");
            System.out.println("13.(for Rounds)\n");

            data =sc.nextInt();

            if( data<1|| data>13){
                System.out.println("Please specify a number 1-13 to choose what data you want to display ");
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
            else if(data==4){
                seasonRequest();
            }
            else if (data==5){
                stageRequest();
            }
            else if(data==7){
                playerRequest();
            }
            else if(data==9){
                bookMakersRequest();
            }
            else if(data==10){
                marketRequest();
            }
            else if(data==11){
                venueRequest();
            }
            else if(data==12){
                refereeRequest();
            }
            else if(data==13){
                roundRequest();
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

        try{
            String url = "https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";
            StringBuilder readLine = new StringBuilder();
            URL urlForGetRequest1 = new URL(url);


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
            System.out.println("These are all the leagues you can view data from");
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                System.out.println("The league name is: " + jsonobj_1.get("name"));
                System.out.println("League code of: " + jsonobj_1.get("league_id"));
                System.out.println("The country id is: " + jsonobj_1.get("country_id"));
                System.out.println("\n");
            }

        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    private static void countryRequest() throws IOException{

        try{
            String url = "https://app.sportdataapi.com/api/v1/soccer/countries?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&continent";
            URL urlForGetRequest = new URL(url);

            StringBuilder readLine = new StringBuilder();
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
                    readLine.append(sc.nextLine());
                }
                sc.close();
            }
            JSONObject jobj = new JSONObject(readLine.toString());
            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");
            System.out.println("These are all the countries you can view data from");
            System.out.println("\n");

            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                System.out.println("The country name is: " + jsonobj_1.get("name"));
                System.out.println("The continent of: " + jsonobj_1.get("continent"));
                System.out.println("Country code of: " + jsonobj_1.get("country_id"));
                System.out.println("Country id of : " + jsonobj_1.get("country_code"));
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void teamsRequest() throws IOException{

        HashMap<String, Integer> id = new HashMap<>();
        String info;
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

        System.out.println("To view the teams on the default country press 1 or specify the league you would like to see ");
        info = tc.nextLine();
        int country_id= id.get(info);

        try {
            String url = "https://app.sportdataapi.com/api/v1/soccer/teams?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=" + country_id + "\"";
            URL urlForGetRequest = new URL(url);

            StringBuilder readLine = new StringBuilder();
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int responseCode = conection.getResponseCode();

            if (responseCode != 200)
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            else {
                Scanner sc = new Scanner(urlForGetRequest.openStream());
                while (sc.hasNext()) {
                    readLine.append(sc.nextLine());
                }
                sc.close();
            }
            JSONObject jobj = new JSONObject(readLine.toString());
            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");
            System.out.println("These are all the teams from " + info);
            System.out.println("\n");
            for (int i = 0; i < jsonarr_1.length(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("The team name is " + jsonobj_1.get("name"));
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void seasonRequest(){
       try{
           String url = "https://app.sportdataapi.com/api/v1/soccer/seasons?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&league_id=314";

           URL urlForGetRequest1 = new URL(url);

           StringBuilder readLine = new StringBuilder();
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
           System.out.println("These are all the leagues you can view data from");
           System.out.println("\n");
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

               System.out.println("The season name is: " + jsonobj_1.get("name"));
               System.out.println("League code of: " + jsonobj_1.get("league_id"));
               System.out.println("The state date: " + jsonobj_1.get("start_date"));
               System.out.println("The end date: " + jsonobj_1.get("end_date"));
               System.out.println("\n");
           }

       }  catch (IOException e)  {
           e.printStackTrace();
       }
    }

    private static void stageRequest(){
        try{
            String url = "https://app.sportdataapi.com/api/v1/soccer/stages?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&season_id=3";

            URL urlForGetRequest1 = new URL(url);

            StringBuilder readLine = new StringBuilder();
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
            System.out.println("These are all the leagues you can view data from");
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                System.out.println("The stage name is: " + jsonobj_1.get("name"));
                System.out.println("The stage id: " + jsonobj_1.get("stage_id"));
                System.out.println("\n");
            }

        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    private static void playerRequest(){
        try{
            String url = "https://app.sportdataapi.com/api/v1/soccer/players?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=48&max_age=19";

            URL urlForGetRequest1 = new URL(url);

            StringBuilder readLine = new StringBuilder();
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
            System.out.println("These are all the the players you can view data from");
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                System.out.println("The player name is: " + jsonobj_1.get("firstname"));
                System.out.println("The player surname is: " + jsonobj_1.get("lastname"));
                System.out.println("The player age is: " + jsonobj_1.get("age"));
                System.out.println("The player id is: " + jsonobj_1.get("player_id"));
                System.out.println("The player weight is: " + jsonobj_1.get("weight"));
                System.out.println("The player height is: " + jsonobj_1.get("height"));
                System.out.println("\n");
            }

        }  catch (IOException e)  {
            e.printStackTrace();
        }

    }

    static void bookMakersRequest(){
        try{
            String url = "https://app.sportdataapi.com/api/v1/soccer/bookmakers?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";

            URL urlForGetRequest1 = new URL(url);

            StringBuilder readLine = new StringBuilder();
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
            System.out.println("These are all the the bookmakers you can view data from");
            System.out.println("\n");
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

                System.out.println("The bookmakers name is: " + jsonobj_1.get("name"));
                System.out.println("The bookmakers id is: " + jsonobj_1.get("bookmaker_id"));

                System.out.println("\n");
            }

        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

   private static void marketRequest(){
       try{
           String url = "https://app.sportdataapi.com/api/v1/soccer/markets?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";

           URL urlForGetRequest1 = new URL(url);

           StringBuilder readLine = new StringBuilder();
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
           System.out.println("These are all the the Markets you can view data from");
           System.out.println("\n");
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

               System.out.println("The Market name is: " + jsonobj_1.get("name"));
               System.out.println("The Market id is: " + jsonobj_1.get("market_id"));

               System.out.println("\n");
           }

       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void venueRequest(){
       try{
           String url = "https://app.sportdataapi.com/api/v1/soccer/venues?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=48";

           URL urlForGetRequest1 = new URL(url);

           StringBuilder readLine = new StringBuilder();
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
           System.out.println("These are all the the Markets you can view data from");
           System.out.println("\n");
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

               System.out.println("The venue name is: " + jsonobj_1.get("name"));
               System.out.println("The venue id is: " + jsonobj_1.get("venue_id"));
               System.out.println("The capacity is: " + jsonobj_1.get("capacity"));
               System.out.println("The city is: " + jsonobj_1.get("city"));
               System.out.println("The coountry is is: " + jsonobj_1.get("country_id"));

               System.out.println("\n");
           }

       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }


   private static void refereeRequest(){

       try{
           String url = "https://app.sportdataapi.com/api/v1/soccer/referees?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=81";

           URL urlForGetRequest1 = new URL(url);

           StringBuilder readLine = new StringBuilder();
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
           System.out.println("These are all the referees you can view data from");
           System.out.println("\n");
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

               System.out.println("The referee name is: " + jsonobj_1.get("name"));
               System.out.println("The referee id is: " + jsonobj_1.get("id"));
               System.out.println("\n");
           }

       }  catch (IOException e)  {
           e.printStackTrace();
       }

   }

   private static void roundRequest(){
       try{
           String url = "https://app.sportdataapi.com/api/v1/soccer/rounds?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&season_id=503";

           URL urlForGetRequest1 = new URL(url);

           StringBuilder readLine = new StringBuilder();
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
           System.out.println("These are all the referees you can view data from");
           System.out.println("\n");
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

               System.out.println("The round name is: " + jsonobj_1.get("name"));
               System.out.println("The round id is: " + jsonobj_1.get("round_id"));
               System.out.println("The season id is: " + jsonobj_1.get("season_id"));
               System.out.println("The season id is: " + jsonobj_1.get("league_name"));
               System.out.println("The season id is: " + jsonobj_1.get("league_id"));

               System.out.println("\n");
           }

       }  catch (IOException e)  {
           e.printStackTrace();
       }

   }

}

