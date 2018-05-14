package menus;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class Input
{
      public int getInt(int min, int max)
      {
            while(true)
            {
                  int value = getInt();
                  if(value >= min && value <= max) return value;
                  else System.out.println("Valid numbers are in the range from " + " " + min + " - " + max);
            }
      }
      
      public int getInt()
      {
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt())
            {
                  input.nextLine();
                  System.out.println("You have to input a Number ");
            }
            return input.nextInt();
      }      
      
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
      
      public String getDate()
      {
            while(true)
            {
                  String line = getString();
                  if(line.equals("5"))
                  {
                        return "5";
                  } 
                  else if(line.equals("4"))
                  {
                        return "4";
                  }
                  else if(isLocalDate(line) == true)
                  {
                        return line;
                  }
                  else System.out.println("You did not type a correct date, the format is yyyy-mm-dd ");
            }
      }
      
      public boolean isLocalDate(String line)//virker ikke helt kræver noget finpusning
      {
            char c ='0';
            if(line.length() == 10)
            {
                  for(int i = 0; i < 4; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  c = line.charAt(4);
                  if(c == '-')
                  {}
                  else return false;
                  for(int i = 5; i < 7; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  c = line.charAt(7);
                  if(c == '-')
                  {}
                  else return false; 
                  for(int i = 8; i < 9; i++)
                  {
                        c = line.charAt(i);
                        if(Character.isDigit(c))
                        {}
                        else return false;
                  }
                  return true;
            }
            else return false;
      }
      
      public String getString()
      {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
      }
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
                  System.out.println("That was not one of the listed opponent ID's. Try again!");
            }
      }
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
                        System.out.println("Wrong input! Please type in H or A for Home/Away");
                        input = getString();
                  }
            }
            
      }
      public Match getMatchIDByList(ArrayList<Match> matches)
      {
                  while(true)
                  {
                        int input =getInt();
                        for(Match i : matches)
                        {
                              if (i.getID() == input)
                              {
                                    return i;
                              }
                         } 
                   }     
      }
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
                       
                  if(Character.toString(homeAway).equals("H"))
                  {
                        match.setMatchHomeGoals(homeTeamGoals);
                        return homeTeamGoals;
                  }
                  else if (Character.toString(homeAway).equals("A"))
                  {
                        match.setMatchAwayGoals(awayTeamGoals);
                        return awayTeamGoals;      
                  }
                  else 
                  {
                        System.out.println("Wrong input! ");
                        input = getString();
                  }
       
                  }
                  catch(Exception e)
                  {
                        System.out.println("Wrong input! ");
                        input = getString();
                        
                  }
                             
                 
                  
             
            }
      }
      
}