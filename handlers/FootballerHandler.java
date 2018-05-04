package handlers;
import models.*;
import java.util.*;

public class FootballerHandler extends ObjectHandler<Footballer> //specifocerer hvilken type objekter vi arbejder med i denne klasse
{
      private ArrayList<Footballer> footballers = getContent();
      
      public String getFilePath()
      {
            return "footballer.csv";
      }
      
      public PersistentObjectHandler<Footballer> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return new PersistentObjectHandler<Footballer>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(Footballer footballer)//PersistentObjectHandler kræver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return footballer.getID() + "," + footballer.getFootballerJersey() + "," + footballer.getFootballerName() + "," 
                        + footballer.getFootballerPosition() + "," + footballer.getFootballerSalary() + "," + footballer.getFootballerEmployed();
                  }
      
                  public Footballer objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]);//laver strings i arraylisten om til int.
                        int jerseyNumber = Integer.parseInt(components[1]);
                        boolean employed = Boolean.parseBoolean(components[5]);
                        
                        if(components[3].equals("GK")) //Ser på spillernes position og opretter dem som et Footballer object af den korrekte type
                        {
                              return new Goalkeeper(id, jerseyNumber, components[2], components[4], employed);
                        }
                        else if(components[3].equals("DF"))
                        {
                              return new Defender(id, jerseyNumber, components[2], components[4], employed);
                        }
                        else if(components[3].equals("MF"))
                        {
                              return new Midfielder(id, jerseyNumber, components[2], components[4], employed);
                        }
                        else if(components[3].equals("FW"))
                        {
                              return new Forward(id, jerseyNumber, components[2], components[4], employed);
                        }
                        else 
                        {
                              return new Manager(id, jerseyNumber, components[2], components[4], employed);
                        }
                  }
            };
      }
      
      public ArrayList getFootballerArray()
      {
            return footballers;
      }
      
      public void listFootballers()
      {           
            for(Footballer i : footballers)
            {
                  System.out.println(i.getID() + " " + i.getFootballerJersey() + " " + i.getFootballerName() + " " 
                  + i.getFootballerPosition() + " " + i.getFootballerSalary() + " " + i.getFootballerEmployed());   
            }
      }
      
      public void updateObject()
      {
      
      }
      
      public void createObject()
      {
            
      }
}