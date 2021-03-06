package com.sportdataapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportdataapi.sportdata.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SportsData {

    //public static final Logger logger = Logger.getLogger(SportsData.class.getSimpleName());
    public static final String BASEURL = "https://app.sportdataapi.com/api/v1/soccer";
    public static final String APIKEY= "1f8177a0-ba72-11ec-b83e-09e34675ae35";

    public static void main(String[] args) {
        Boolean stillRunning = true;

        System.out.println("Welcome to the Sports data app");
        System.out.println("\t");
        System.out.println("This app allows you to view the leagues, countries and teams");
        System.out.println("\t");
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
                else if(data==8){
                    bookMakersRequest();
                }
                else if(data==9){
                    marketRequest();
                }
                else if(data==10){
                    venueRequest();
                }
                else if(data==11){
                    refereeRequest();
                }
                else if(data==12){
                    roundRequest();
                }
                else if(data==13){
                    stillRunning = false;
                }
                else {
                    System.out.println("Please specify a number 1-13 to choose what data you want to display ");
                    data = dataOptions(sc);
                }

                System.out.println("Would you like to check more data on the sports app?");
                System.out.println("Enter any integer to continue or 77 to end the program");
                if(sc.nextInt() == 77){
                    stillRunning = false;
                }
                else
                {
                    stillRunning = true;
                }
            }catch (InputMismatchException ex) {
                System.out.println("Invalid input! You have to enter a number");
            }
        }while(stillRunning);
        System.out.println("Thank you. You've successfully completed the program");
        System.out.println("\t");
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
        System.out.println("8.Bookmakers");
        System.out.println("9.Markets");
        System.out.println("10.Venues");
        System.out.println("11.Referees");
        System.out.println("12.Rounds");
        System.out.println("13.To end the program\t");
       data = sc.nextInt();
        return data;
    }

    private static void leagueRequest() {
        try{
            String url = BASEURL +"/leagues?" + APIKEY;
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper leagueMapper = new ObjectMapper();
            LeagueResponse leagueResponse = leagueMapper.readValue(responseBodyString, LeagueResponse.class);
            for(int i = 0; i<leagueResponse.getData().size();i++)
            {
                System.out.println("Name: " + leagueResponse.getData().get(i).getName());
                System.out.println("\t");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

   static void countryRequest() {
        try {
            String url = BASEURL + "/countries?" + "&continent";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper countryMapper = new ObjectMapper();
            CountryResponse countryResponse = countryMapper.readValue(responseBodyString, CountryResponse.class);
            for(int i = 0; i<countryResponse.getData().size();i++)
            {
                if(countryResponse.getData().get(i).getCountry_code() !=null) {
                    System.out.println("Name: " + countryResponse.getData().get(i).getName());
                    System.out.println("Continent: " + countryResponse.getData().get(i).getContinent());
                    System.out.println("\t");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void teamsRequest() {
        try {
            int country_id = Utils.getCountry_id();
            String url = BASEURL + "/teams?" +  "&country_id=" + country_id + "\"";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper teamMapper = new ObjectMapper();
            TeamsResponse teamResponse = teamMapper.readValue(responseBodyString, TeamsResponse.class);
            for(int i = 0; i<teamResponse.getData().size();i++)
            {
                System.out.println("Name: " + teamResponse.getData().get(i).getName());
                System.out.println("Short code: " + teamResponse.getData().get(i).getShort_code());
                System.out.println("\t");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void seasonRequest(){
       try{
           int league_id = Utils.getLeague_id();
           String url = BASEURL +  "/seasons?"  + "&league_id=" + league_id + "\"";
           String responseBodyString = Utils.apiRequest(url);
           ObjectMapper seasonMapper = new ObjectMapper();
           SeasonResponse seasonResponse = seasonMapper.readValue(responseBodyString, SeasonResponse.class);
           for(int i = 0; i<seasonResponse.getData().size();i++)
           {
               System.out.println("Name: " + seasonResponse.getData().get(i).getName());
               System.out.println("Start date: " + seasonResponse.getData().get(i).getStart_date());
               System.out.println("End date: " + seasonResponse.getData().get(i).getEnd_date());
               System.out.println("\t");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
    }

    private static void stageRequest(){
        try{
            int season_id = Utils.getSeason_id();
            String url =BASEURL + "/stages?"  + "&season_id=" + season_id + "\"";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper stageMapper = new ObjectMapper();
            StageResponse stageResponse = stageMapper.readValue(responseBodyString, StageResponse.class);
            for(int i = 0; i<stageResponse.getData().size();i++)
            {
                System.out.println("Name: " + stageResponse.getData().get(i).getName());
                System.out.println("\t");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    private static void playerRequest(){
        try{
            int country_id = Utils.getCountry_id();
            String url = BASEURL + "/players?" + "&country_id=" + country_id + "\"";
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper playerMapper = new ObjectMapper();
            PlayerResponse playerResponse = playerMapper.readValue(responseBodyString, PlayerResponse.class);
            for(int i = 0; i<playerResponse.getData().size();i++)
            {
                System.out.println("First name: " + playerResponse.getData().get(i).getFirstname());
                System.out.println("Last name: " + playerResponse.getData().get(i).getLastname());
                System.out.println("Age: " + playerResponse.getData().get(i).getAge());
                System.out.println("Weight: " + playerResponse.getData().get(i).getWeight());
                System.out.println("Height: " + playerResponse.getData().get(i).getHeight());
                System.out.println("\t");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

    static void bookMakersRequest(){
        try{
            String url = BASEURL +  "/bookmakers?" + APIKEY;
            String responseBodyString = Utils.apiRequest(url);
            ObjectMapper bookmakerMapper = new ObjectMapper();
            BookMakersResponse bookmakerResponse = bookmakerMapper.readValue(responseBodyString, BookMakersResponse.class);
            for(int i = 0; i<bookmakerResponse.getData().size();i++)
            {
                System.out.println("Name: " + bookmakerResponse.getData().get(i).getName());
                System.out.println("\t");
            }
        }  catch (IOException e)  {
            e.printStackTrace();
        }
    }

   private static void marketRequest(){
       try{
           String url =BASEURL +  "/markets?" + APIKEY ;
           String responseBodyString = Utils.apiRequest(url);
           ObjectMapper marketMapper = new ObjectMapper();
           MarketResponse marketResponse = marketMapper.readValue(responseBodyString, MarketResponse.class);
           for(int i = 0; i<marketResponse.getData().size();i++)
           {
               System.out.println("Name: " + marketResponse.getData().get(i).getName());
               System.out.println("\t");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void venueRequest(){
       try{
           int country_id = Utils.getCountry_id();
           String url = BASEURL + "/venues?"  + "&country_id=" + country_id;
           String responseBodyString = Utils.apiRequest(url);
           ObjectMapper venueMapper = new ObjectMapper();
           VenueResponse venueResponse = venueMapper.readValue(responseBodyString, VenueResponse.class);
           for(int i = 0; i<venueResponse.getData().size();i++)
           {
               System.out.println("Name: " + venueResponse.getData().get(i).getName());
               System.out.println("Capacity: " + venueResponse.getData().get(i).getCapacity());
               System.out.println("City: " + venueResponse.getData().get(i).getCity());
               System.out.println("\t");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void refereeRequest(){
       try{
           int country_id = Utils.getCountry_id();
           String url = BASEURL + "/referees?"  + "&country_id=" + country_id;
           String responseBodyString = Utils.apiRequest(url);
           ObjectMapper refereeMapper = new ObjectMapper();
           RefereeResponse refereeResponse = refereeMapper.readValue(responseBodyString, RefereeResponse.class);
           for(int i = 0; i<refereeResponse.getData().size();i++)
           {
               System.out.println("First Name: " + refereeResponse.getData().get(i).getFirstname());
               System.out.println("Last Name: " + refereeResponse.getData().get(i).getLastname());
               System.out.println("\t");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

   private static void roundRequest(){
       try{
           int season_id = Utils.getSeason_id();
           String url = BASEURL + "/rounds?"  + "&season_id=" + season_id+ "\"";
           String responseBodyString = Utils.apiRequest(url);
           ObjectMapper roundMapper = new ObjectMapper();
           RoundResponse roundResponse = roundMapper.readValue(responseBodyString, RoundResponse.class);
           for(int i = 0; i<roundResponse.getData().size();i++)
           {
               System.out.println("Name: " + roundResponse.getData().get(i).getName());
               System.out.println("Is current: " + roundResponse.getData().get(i).getIs_current());
               System.out.println("League: " + roundResponse.getData().get(i).getLeague_name());
               System.out.println("\t");
           }
       }  catch (IOException e)  {
           e.printStackTrace();
       }
   }

}
