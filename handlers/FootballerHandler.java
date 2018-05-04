package handlers;
import models.*;
import java.util.*;


public class FootballerHandler extends ObjectHandler<Footballer> //specifocerer hvilken type objekter vi arbejder med i denne klasse
{

      ArrayList<Footballer> footballers = getContent();
      
      public String getFilePath()
      {
            return "footballer.txt";
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
                        
                        return new Footballer(id, jerseyNumber, components[2], components[3], components[4], employed); //obretter er nyt object af footballer                      
                  }
            };
      }
      
      public void updateObject()
      {
      
      }
      
      public void createObject()
      {
            
      }
}