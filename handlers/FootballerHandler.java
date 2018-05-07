package handlers;
import models.Footballer;
import models.footballertypes.*;
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
                        String name = components[2];
                        String salary = components[4];
                        boolean employed = Boolean.parseBoolean(components[5]);
                        
                        if(components[3].equals("GK")) //Ser på spillernes position og opretter dem som et Footballer object af den korrekte type
                        {
                              return new Goalkeeper(id, jerseyNumber, name, salary, employed);
                        }
                        else if(components[3].equals("DF"))
                        {
                              return new Defender(id, jerseyNumber, name, salary, employed);
                        }
                        else if(components[3].equals("MF"))
                        {
                              return new Midfielder(id, jerseyNumber, name, salary, employed);
                        }
                        else if(components[3].equals("FW"))
                        {
                              return new Forward(id, jerseyNumber, name, salary, employed);
                        }
                        else 
                        {
                              return new Manager(id, jerseyNumber, name, salary, employed);
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
      
      public Footballer getFootballer(int id)
      {
            for(Footballer i : footballers)
            {
                  if(i.getID() == id)
                  {
                        return i;
                  }
            }
            return null;
      }
      
      public int getNewFootballerID()
      {
            int newID= getNewID(footballers);
            return newID;
      }
      
      public void deleteFootballer(int id)
      {
            deleteObject(footballers, id);
      }
      
      public void updateObject(int footballerID, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            for(Footballer i : footballers)
            {
                  if (i.getID() == footballerID)
                  {
                        i.setFootballerJersey(footballerJersey);
                        i.setFootballerName(footballerName);
                        i.setFootballerSalary(footballerSalary);
                        i.setFootballerEmployed(footballerEmployed);
                        save(footballers);
                  }
            }
      }   
      
      public void createObject(int footballerJersey, String fooballerName, String footballerSalary, boolean footballerEmployed, String position)
      {
             switch(position)
             {
             case "GK":
                        footballers.add(new Goalkeeper(getNewFootballerID(), footballerJersey, fooballerName, footballerSalary, footballerEmployed));
                        save(footballers);
             case "FW":
                        footballers.add(new Forward(getNewFootballerID(), footballerJersey, fooballerName, footballerSalary, footballerEmployed));
                        save(footballers);
             case "DF":
                        footballers.add(new Defender(getNewFootballerID(), footballerJersey, fooballerName, footballerSalary, footballerEmployed));
                        save(footballers);
             case "MF":
                        footballers.add(new Midfielder(getNewFootballerID(), footballerJersey, fooballerName, footballerSalary, footballerEmployed));
                        save(footballers);
             case "MN":
                        footballers.add(new Manager(getNewFootballerID(), footballerJersey, fooballerName, footballerSalary, footballerEmployed));
                        save(footballers);
             }
             
      }
}