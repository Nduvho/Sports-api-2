import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SportsData {

    private static final String namespace = "https://app.sportdataapi.com/api/v1/soccer";
    private static final String api_key = "apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";

    public static void main(String[] args) {
        Boolean stillRunning = true;

        System.out.println("Welcome to the Sports data app");
        System.out.println("\n");
        System.out.println("This app allows you to view the leagues, countries and teams");
        System.out.println("\n");
        do{
            Scanner sc =new Scanner(System.in);
            System.out.println("To view the list of different data enter");
            try {
                int data = dataOptions(sc);
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
                else {
                    System.out.println("Please specify a number 1-13 to choose what data you want to display ");
                    data = dataOptions(sc);
                }

                System.out.println("Would you like to check more data on the sports app?");
                System.out.println("Enter 1 to view more data or any other integer to end the program");
                if(sc.nextInt() != 1){
                    stillRunning = false;
                }
            }catch (InputMismatchException ex) {
                System.out.println("Invalid input! You have to enter a number");
            }

        }while(stillRunning);
        System.out.println("Thank you. You've successfully completed the program");
        System.out.println("\n");
        System.out.println("You may close the session");
    }

    private static int dataOptions(Scanner sc) {
        int data;
        System.out.println("1.Leagues");
        System.out.println("2.Countries");
        System.out.println("3.Teams");
        System.out.println("4.Seasons");
        System.out.println("5.Stages");
        System.out.println("6.Matches");
        System.out.println("7.Players");
        System.out.println("8.Top Scorers");
        System.out.println("9.Bookmakers");
        System.out.println("10.Markets");
        System.out.println("11.Venues");
        System.out.println("12.Referees");
        System.out.println("13.Rounds\n");
       data = sc.nextInt();
        return data;
    }

    private static void leagueRequest() {
        try{
            String url = namespace+"/leagues?" + api_key;
            StringBuilder readLine = new StringBuilder();
            URL urlForGetRequest1 = new URL(url);
            JSONArray league_array = Utils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<league_array.length();i++){
                JSONObject league = (JSONObject) league_array.get(i);
                System.out.println("league: " + league.get("name"));
                System.out.println("code: " + league.get("league_id"));
                System.out.println("Country id: " + league.get("country_id"));
                System.out.println("\n");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    static int countryRequest() {
        JSONObject country = null;
        try {
            String url = namespace + "/countries?" + api_key + "&continent";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray country_array = Utils.apiCall(readLine, urlForGetRequest1);
            for (int i = 0; i < country_array.length(); i++) {
                country = (JSONObject) country_array.get(i);
                System.out.println("country: " + country.get("name"));
                System.out.println("Continent: " + country.get("continent"));
                System.out.println("Country code: " + country.get("country_code"));
                System.out.println("Country id: " + country.get("country_id"));
                System.out.println("\n");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return (int) country.get("country_id");
    }

    private static void teamsRequest() {
        try {
            int country_id = Utils.country_id();
            String url = namespace + "/teams?" + api_key +  "&country_id=" + country_id + "\"";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray teams_array = Utils.apiCall(readLine, urlForGetRequest1) ;
            for (int i = 0; i < teams_array.length(); i++) {
                JSONObject teams = (JSONObject) teams_array.get(i);
                System.out.println("Team: " + teams.get("name"));
                System.out.println("Code: " + teams.get("short_code") );
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void seasonRequest(){
       try{
           String url = namespace +  "/seasons?" + api_key + "&league_id=314";
           URL urlForGetRequest1 = new URL(url);
           StringBuilder readLine = new StringBuilder();
           JSONArray season_array = Utils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<season_array.length();i++){
               JSONObject season = (JSONObject) season_array.get(i);
               System.out.println("season: " + season.get("name"));
               System.out.println("League code: " + season.get("league_id"));
               System.out.println("State date: " + season.get("start_date"));
               System.out.println("End date: " + season.get("end_date"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
    }

    private static void stageRequest(){
        try{
            String url =namespace + "/stages?" + api_key + "&season_id=3";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray stage_array = Utils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<stage_array.length();i++){
                JSONObject stage = (JSONObject) stage_array.get(i);
                System.out.println("stage name: " + stage.get("name"));
                System.out.println("stage id: " + stage.get("stage_id"));
                System.out.println("\n");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    private static void playerRequest(){
        try{
            int country_id = Utils.country_id();
            String url = namespace + "/players?" + api_key + "&country_id=" + country_id + "\"";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray player_request = Utils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<player_request.length();i++){
                JSONObject player = (JSONObject) player_request.get(i);
                System.out.println("name: " + player.get("firstname"));
                System.out.println("surname: " + player.get("lastname"));
                System.out.println("Age: " + player.get("age"));
                System.out.println("id: " + player.get("player_id"));
                System.out.println("Weight: " + player.get("weight"));
                System.out.println("Height: " + player.get("height"));
                System.out.println("\n");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    static void bookMakersRequest(){
        try{
            String url = namespace +  "/bookmakers?" + api_key;
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray bookmakers_array = Utils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<bookmakers_array.length();i++){
                JSONObject bookmakers = (JSONObject) bookmakers_array.get(i);
                System.out.println("Bookmakers: " + bookmakers.get("name"));
                System.out.println("id: " + bookmakers.get("bookmaker_id"));
                System.out.println("\n");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

   private static void marketRequest(){
       try{
           String url =namespace +  "/markets?" + api_key;
           URL urlForGetRequest1 = new URL(url);
           StringBuilder readLine = new StringBuilder();
           JSONArray market_array = Utils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<market_array.length();i++){
               JSONObject market = (JSONObject) market_array.get(i);
               System.out.println("Market: " + market.get("name"));
               System.out.println("id: " + market.get("market_id"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void venueRequest(){
       try{
           int country_id = Utils.country_id();
           String url = namespace + "/venues?" +api_key + "&country_id=" + country_id;
           URL urlForGetRequest1 = new URL(url);
           StringBuilder readLine = new StringBuilder();
           JSONArray venue_array = Utils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<venue_array.length();i++){
               JSONObject venue = (JSONObject) venue_array.get(i);
               System.out.println("Venue: " + venue.get("name"));
               System.out.println("id: " + venue.get("venue_id"));
               System.out.println("Capacity: " + venue.get("capacity"));
               System.out.println("City: " + venue.get("city"));
               System.out.println("Country id: " + venue.get("country_id"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void refereeRequest(){
       try{
           int country_id = Utils.country_id();
           String url = namespace + "/referees?" + api_key + "&country_id=" + country_id;
           URL urlForGetRequest1 = new URL(url);
           StringBuilder readLine = new StringBuilder();
           JSONArray referee_array = Utils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<referee_array.length();i++){
               JSONObject referee = (JSONObject) referee_array.get(i);
               System.out.println("Referee: " + referee.get("name"));
               System.out.println("id: " + referee.get("id"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void roundRequest(){
       try{
           String url = namespace + "/rounds?" + api_key + "&season_id=503";
           URL urlForGetRequest1 = new URL(url);
           StringBuilder readLine = new StringBuilder();
           
           JSONArray round_array = Utils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<round_array.length();i++){
               JSONObject round = (JSONObject) round_array.get(i);
               System.out.println("Round: " + round.get("name"));
               System.out.println("id: " + round.get("round_id"));
               System.out.println("Season id: " + round.get("season_id"));
               System.out.println("League: " + round.get("league_name"));
               System.out.println("League id: " + round.get("league_id"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

}

