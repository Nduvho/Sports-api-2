import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class sportsData {

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
        System.out.println("1.leagues");
        System.out.println("2.countries");
        System.out.println("3.teams");
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
            String url = "https://app.sportdataapi.com/api/v1/soccer/leagues?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35";
            StringBuilder readLine = new StringBuilder();
            URL urlForGetRequest1 = new URL(url);
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("league: " + jsonobj_1.get("name"));
                System.out.println("code: " + jsonobj_1.get("league_id"));
                System.out.println("Country id: " + jsonobj_1.get("country_id"));
                System.out.println("\n");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    private static void countryRequest() {
        try{

            String url = "https://app.sportdataapi.com/api/v1/soccer/countries?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&continent";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("country: " + jsonobj_1.get("name"));
                System.out.println("Continent: " + jsonobj_1.get("continent"));
                System.out.println("Country code: " + jsonobj_1.get("country_code"));
                System.out.println("Country id: " + jsonobj_1.get("country_id"));
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void teamsRequest() {
        try {
            int country_id = utensils.country_id();

            String url = "https://app.sportdataapi.com/api/v1/soccer/teams?apikey=1f8177a0-ba72-11ec-b83e-09e34675ae35&country_id=" + country_id + "\"";
            URL urlForGetRequest1 = new URL(url);
            StringBuilder readLine = new StringBuilder();
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for (int i = 0; i < jsonarr_1.length(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("Team: " + jsonobj_1.get("name"));
                System.out.println("Code: " + jsonobj_1.get("short_code") );
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
           JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
               System.out.println("season: " + jsonobj_1.get("name"));
               System.out.println("League code: " + jsonobj_1.get("league_id"));
               System.out.println("State date: " + jsonobj_1.get("start_date"));
               System.out.println("End date: " + jsonobj_1.get("end_date"));
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
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("stage name: " + jsonobj_1.get("name"));
                System.out.println("stage id: " + jsonobj_1.get("stage_id"));
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
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("name: " + jsonobj_1.get("firstname"));
                System.out.println("surname: " + jsonobj_1.get("lastname"));
                System.out.println("Age: " + jsonobj_1.get("age"));
                System.out.println("id: " + jsonobj_1.get("player_id"));
                System.out.println("Weight: " + jsonobj_1.get("weight"));
                System.out.println("Height: " + jsonobj_1.get("height"));
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
            JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
            for(int i =0; i<jsonarr_1.length();i++){
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                System.out.println("Bookmakers: " + jsonobj_1.get("name"));
                System.out.println("id: " + jsonobj_1.get("bookmaker_id"));
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
           JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
               System.out.println("Market: " + jsonobj_1.get("name"));
               System.out.println("id: " + jsonobj_1.get("market_id"));
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
           JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
               System.out.println("Venue: " + jsonobj_1.get("name"));
               System.out.println("id: " + jsonobj_1.get("venue_id"));
               System.out.println("Capacity: " + jsonobj_1.get("capacity"));
               System.out.println("City: " + jsonobj_1.get("city"));
               System.out.println("Country id: " + jsonobj_1.get("country_id"));
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
           JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
               System.out.println("Referee: " + jsonobj_1.get("name"));
               System.out.println("id: " + jsonobj_1.get("id"));
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
           JSONArray jsonarr_1 = utensils.apiCall(readLine, urlForGetRequest1) ;
           for(int i =0; i<jsonarr_1.length();i++){
               JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
               System.out.println("Round: " + jsonobj_1.get("name"));
               System.out.println("id: " + jsonobj_1.get("round_id"));
               System.out.println("Season id: " + jsonobj_1.get("season_id"));
               System.out.println("League: " + jsonobj_1.get("league_name"));
               System.out.println("League id: " + jsonobj_1.get("league_id"));
               System.out.println("\n");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

}

