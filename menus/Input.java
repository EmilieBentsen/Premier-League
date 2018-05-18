package menus;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;
import handlers.*;
import java.time.format.*;
import java.time.*;

public class Input
{
      Output output = new Output();
      public int getInt(int min, int max)
      {
            while(true)
            {
                  int value = getInt();//kalder getInt og gemmer den int der kommer tilbage i value 
                  if(value >= min && value <= max) return value;//sørger vi kun returnerer value hvis dens værdi er mellem min og max
                  else System.out.println("Valid numbers are in the range from " + " " + min + " - " + max);
            }
      }
      
      public int getInt()//sørger for vi får en int som input
      {
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt())
            {
                  input.nextLine();
                  System.out.println("You have to input a Number ");
            }
            return input.nextInt();
      }      
      
      //Erik Pilverdier
      //bruges til at vi kun kan vælge et trøjenummer der er i brug af en af fodboldspillerne
      public Footballer getFootballerByJersey(ArrayList<Footballer> footballerList)
      {
            int input;
            while (true)
            {
                  input = getInt();
                  for(Footballer i : footballerList)
                  {
                        if(input == i.getFootballerJersey())
                        {
                              return i;      
                        }
                  }
                  System.out.println("That was not one of the listed jersey numbers. Try again!");
            }
      }
      
      //Erik Pilverdier
      //samme som med fodboldspillerne, men her det kun de kampe der er i listen der kan vælges
      public Match getMatchByID (ArrayList<Match> matches)
      {
            int input;
            while (true)
            {
                  input = getInt();
                  for(Match i : matches)
                  {
                        if(input == i.getID())
                        {
                              return i;
                        }
                  }
                  System.out.println("That was not one of the listed matchID's. Try again!");            
            }
      }
      
      //Erik Pilverdier
      //da brugeren skal have mulighed for at gå tilbage gemmes input fra brugeren i en String og hvis den er "4" eller "5"
      //returneres det, ellers tjekker metoden om det er en LocalDate og hvis den er det returneres den 
      public LocalDate getDate() 
      {
            while(true)
            {
                  String line = getString();
                  if(isLocalDate(line) == true)
                  {
                        return LocalDate.parse(line);
                  }
                  else System.out.println("You did not type a correct date. (YYYY-MM-DD)");
            }
      }
      
      //Adam Birch
      public boolean isLocalDate(String line)
      {
            try
            {
                  LocalDate matchDate = LocalDate.parse(line);
            }
            catch(DateTimeParseException e)
            {
                  System.out.println("Date Format Error");
                  return false;
            }
            catch(NullPointerException e)
            {
                  System.out.println("Could not read format.");
                  return false;      
            }
      return true;
      }
      
      //tager en string ind via Scanner og returnerer den
      public String getString()
      {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
      }
      
      //Erik Pilverdier
      //tjekker om det indtastede ID findes i opponenlist
      public int getOpponentIDByList(ArrayList<Opponent> opponentList)
      {
            int input;
            while (true)
            {
                  input = getInt();
                  for(Opponent i : opponentList)
                  {
                        if(input == i.getID())
                        {
                              return i.getID();      
                        }
                  }
                  System.out.println("That was not one of the listed opponent ID's. Try again.");
            }
      }
      
      //Erik Pilverdier
      //tjekker om det indtastede id findes på listen og returnere en modstander
      public Opponent getOpponentByList(ArrayList<Opponent> opponentList)
      {
            int input;
            while (true)
            {
                  input = getInt();
                  for(Opponent i : opponentList)
                  {
                        if(input == i.getID())
                        {
                              return i;      
                        }
                  }
                  System.out.println("That was not one of the listed opponent ID's. Try again!");
            }
      }
      
      //Emilie Bentsen
      //Sørger for at input er enten H eller A.
      public char getHomeAway()
      {
            String input;
            while(true)
            {
                  input = getString();
                  if(input.equalsIgnoreCase("H") || input.equalsIgnoreCase("A"))
                  {
                       return input.charAt(0);
                  }
                  else
                  {
                        System.out.println("Wrong input. Please type in H or A for Home/Away");
                        input = getString();
                  }
            }
            
      }         
      
      //Emilie Bentsen, Adam Birch
      //Tager imod et resultat og splitter det i H/A goals, tjekker om kampen er ude eller hjemme og returnerer LP mål
      public int getResult(char homeAway, Match match)
      {
            String input;
            while(true)
            {
                  input = getString();
                  try
                  {
                        String [] components = input.split("-");
                        int homeTeamGoals = Integer.parseInt(components[0]);
                        int awayTeamGoals = Integer.parseInt(components[1]);
                        match.setMatchHomeGoals(homeTeamGoals);
                        match.setMatchAwayGoals(awayTeamGoals);
                        
                        
                        if(Character.toString(homeAway).equals("H"))
                        {
                              return homeTeamGoals;
                        }
                        else if (Character.toString(homeAway).equals("A"))
                        {
                              return awayTeamGoals;      
                        }
                        else 
                        {
                              System.out.println("Wrong input!");
                        }
             
                  }
                  catch(Exception e)
                  {
                        System.out.println("Wrong input! ");                        
                  }
            }
      }
      
      //Emilie Bentsen
      //Tjekker om footballerjersey er på listen af footballers
      public int getGoalscorer(ArrayList<Footballer> footballers)
      {
            int input;
            while(true)
            {
                  input = getInt();
                  for(Footballer i : footballers)
                  {
                        if(input == i.getFootballerJersey())
                        {
                              return input;
                        }
                  }
            } 
      } 
      
      //Emilie Bentsen
      //tager imod tiden et mål er scoret og tjekker at det er mindre end 100 og returner tiden
      public int getGoalMinuteScored()
      {
            int input;
            while(true)
            {
                  input = getInt();
                  if(input <= 100)
                  {
                        return input;
                  }
                  else
                  {
                        System.out.println("Wrong input! please type int minute of goal scored");
                        input = getInt();
                  }
            }
      }   
      
      //Emilie Bentsen
      //tager imod en måltype og tjekker om typen er enten R P eller O og returnerer typen
      public char getGoalType()
      {
            String input;
                  while(true)
                  {
                        input = getString();
                        if(input.equalsIgnoreCase("R") || input.equalsIgnoreCase("P") || input.equalsIgnoreCase("O") )
                        {
                              return input.charAt(0);
                        }
                        else
                        {
                              System.out.println("Wrong input! Please type in  R = 'Regular' P = 'Penalty' O = 'Own'");
                        }
                  }
            
      
      } 
      
      //Emilie Bentsen
      //tager imod et svar på om en modstander findes på listen ellers beder den brugeren indtaste modstanderen. Returnerer ID på modstander.
      public int getOpponentID() 
      {
            int ID;
            String input;
            while(true)
            {
                  input = getString();
                 
                        if(input.equalsIgnoreCase("Y"))
                        {
                        System.out.println("Please enter opponent ID from list");
                        ID = getInt();
                        return ID;
                        
                        }
                        else if(input.equalsIgnoreCase("N"))
                        {
                              AdminFootballerMenu afm = new AdminFootballerMenu();
                              afm.createFootballerMenu("team");
                              FootballerHandler fh = FootballerHandler.getFootballerHandler();
                              ArrayList<Footballer> footballers = fh.getFootballerArray();
                              ID = fh.getNewID(footballers)-1;
                              return ID;
                        
                        }
                        
                        System.out.println("Wrong input try again!");
            }
                 
      }
     
     
     //Adam Birch  
     //Tager imod en formation, deler den op i int og tjekker at den er på det korrekte format. Returnerer formationen 
     public String promptMatchFormation() 
     {
            Input input = new Input();
            int result = 0;
            while(true)
            {
                  result = 0;
                  String formation = input.getString();
                  String[] stringArrayLineup = formation.split("-");
                  int[] intArrayLineup = new int[stringArrayLineup.length];
                  try{
                        for (int i = 0; i < stringArrayLineup.length; i++) 
                        {
                              String numberAsString = stringArrayLineup[i];
                              intArrayLineup[i] = Integer.parseInt(numberAsString);
                              result = result + intArrayLineup[i];
                        }
                  }
                  catch(NumberFormatException e)
                  {
                        System.out.println("Invalid formation format.");
                        
                  }
                  if(result == 10)
                  {
                        System.out.println("Valid formation.");
                        return formation;
                  }
                  else
                  {
                        System.out.println("Invalid formation. You've got "+ (result + 1) +" players in your starting formation.");
                  }
            }
     }  
     
     //Adam Birch
     //Tager imod et lineup og splitter den i 11 jersey numre. Hvis result når op på 11 i for løkken returneres lineuppet
     public String getMatchLineup() 
     {
            Input input = new Input();
            while(true)
            {
                  int result = 0;
                  String lineup = input.getString();
                  String[] stringArrayLineup = lineup.split("-");
                  int[] intArrayLineup = new int[stringArrayLineup.length];
                  try{
                        for (int i = 0; i < stringArrayLineup.length; i++) 
                        {
                              String numberAsString = stringArrayLineup[i];
                              intArrayLineup[i] = Integer.parseInt(numberAsString);
                              result++;
                        }
                  }
                  catch(NumberFormatException e)
                  {
                        System.out.println("Invalid formation format.");
                  }
                  if(result == 11)
                  {
                        System.out.print("Valid lineup.");
                        return lineup;
                  }
                  else
                  {
                        System.out.print("Invalid lineup. You've got "+ (result) +" players in your starting formation, you need 11.");
                  }
            }   
     }
     
     //Emilie Bentsen
     //tager imod et svar på om et mål var assistede. Hvis ja indtastes ID på spiller hvis nej returneres ID = 00
     public int getAssistedFootballer(ArrayList<Footballer> footballers) 
      {
            int jersey;
            String input;
            while(true)
            {
                  input = getString();
                  
                  if(input.equalsIgnoreCase("Y"))
                  {
                        output.printActiveFootballers(footballers);
                        System.out.println("Please enter assisting footballers jersey number:");
                        jersey = getInt();
                        for(Footballer i : footballers)
                        {
                              if(jersey == i.getFootballerJersey())
                              {
                                    return i.getID();
                                    
                              }
                        }     
                  }
                  else if(input.equalsIgnoreCase("N"))
                  {
                        return 00;
                  }
                  else
                  {
                        System.out.println("Wrong input. (Y/N)");
                  }
            }
      }   
}