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
                  //output.printActiveFootballers(footballerList);
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
      
      public static String getString(ArrayList<String> options, String error)
      {
            while(true)
            {
                  String value = getString();
                  if(options.contains(value)) return value;
                  else System.out.println(error);
            }
      }
      
      public static String getString()
      {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
      }
}