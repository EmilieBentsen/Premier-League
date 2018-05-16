package handlers;
import models.Footballer;
import models.*;
import java.util.*;

public class FootballerHandler extends ObjectHandler<Footballer> //Vi arbejder med Footballer objects.
{
      private static FootballerHandler instance;
      private ArrayList<Footballer> footballers;
      
      private FootballerHandler() //Metoden er til fordi vi gerne vil være sikker på at der kun er en instans af klassen. Derfor har vi overskrevet default konstruktoren med en private konstruktor, som vi kalder i metoden getFootballerHandler, i det tilfælde der ikke allerede findes en instans. Dette er en Singleton løsning. Footballers ArrayList fyldes op med obejkter lavet fra filen footballer.csv
      {
            footballers = getContent(); //metode nedarvet fra ObjectHandler, der 
      }
      
      public static FootballerHandler getFootballerHandler() //metode der returnerer en instans af FootballerHandler
      {
            if(instance == null) //tjekker om der er lavet en instans af klassen 
            {
                  FootballerHandler fh = new FootballerHandler();
                  instance = fh;
            }
            return instance;
      }     

      public String getFilePath() //filen vi gemmer vores footballere i
      {
            return "footballer.csv";
      }
      
      public PersistentObjectHandler<Footballer> getHandler()//Returnerer en persistentObjectHandler med objectet Footballer
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
                        int id = Integer.parseInt(components[0]);
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
      
      public ArrayList<Footballer> getFootballerArray() //returnerer ArrayList footballers
      {
            return footballers;
      }
      
      public ArrayList<Footballer> getActiveFootballersArray() //Laver en liste af aktive spillere og returnerer det
      {
            ArrayList<Footballer> activeFootballers = new ArrayList<Footballer>();
            
            for(Footballer i : footballers)
            {
                  if(i.getFootballerEmployed() == true)
                  {
                       activeFootballers.add(i); 
                  }
            }
            return activeFootballers;
      }
      
      public ArrayList<Footballer> getOpponentFootballersArray() //Laver en liste af inaktive modstandere og returnerer den
      {
            ArrayList<Footballer> opponentFootballers = new ArrayList<Footballer>();
            
            for(Footballer i : footballers)
            {
                  if(i.getFootballerEmployed() == false)
                  {
                        opponentFootballers.add(i);
                  }
            }
            return opponentFootballers;
      }
      
      public void listFootballers() //printer liste med footballers, skal nok slettes
      {           
            for(Footballer i : footballers)
            {
                  System.out.println(i.getID() + " " + i.getFootballerJersey() + " " + i.getFootballerName() + " " 
                  + i.getFootballerPosition() + " " + i.getFootballerSalary() + " " + i.getFootballerEmployed());   
            }
      }
      
      public Footballer getFootballer(int id) //metode tager imod et footballerID og returnerer den spiller med matchende id
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
      
      public int getNewFootballerID()//Metode til at generere nyt footballerID. Metoden kalder getNewID metode i Objekthandler med Arraylist footballers der returnere nyt ID
      {
            int newID= getNewID(footballers);
            return newID;
      }
      
      public void deleteFootballer(int id) //Metode til at slette footballer. Metoden kalder deleteObject med ArrayList footballers og et footballerID. 
      {
            deleteObject(footballers, id);
      }
      
      public void updateObject(int footballerID, int footballerJersey, //Metode der opdatere oplysninger om footballer vha. set metoder
      String footballerName,String footballerSalary, boolean footballerEmployed)
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
      
      public void createObject(int footballerJersey, String fooballerName, String //metode til at oprette nye footballers
      footballerSalary, boolean footballerEmployed, String position)
      {
             switch(position) //switch case der kigger på position og opretter et nyt objekt 
             {
             case "GK":
                        footballers.add(new Goalkeeper(getNewFootballerID(), 
                                                            footballerJersey, 
                                                            fooballerName, 
                                                            footballerSalary, 
                                                            footballerEmployed));
                        save(footballers);
                        break;
             case "FW":
                        footballers.add(new Forward(getNewFootballerID(), 
                                                            footballerJersey, 
                                                            fooballerName, 
                                                            footballerSalary, 
                                                            footballerEmployed));
                        save(footballers);
                        break;
             case "DF":
                        footballers.add(new Defender(getNewFootballerID(), 
                                                            footballerJersey, 
                                                            fooballerName, 
                                                            footballerSalary, 
                                                            footballerEmployed));
                        save(footballers);
                        break;
             case "MF":
                        footballers.add(new Midfielder(getNewFootballerID(), 
                                                            footballerJersey, 
                                                            fooballerName, 
                                                            footballerSalary, 
                                                            footballerEmployed));
                        save(footballers);
                        break;
             case "MN":
                        footballers.add(new Manager(getNewFootballerID(), 
                                                            footballerJersey, 
                                                            fooballerName, 
                                                            footballerSalary, 
                                                            footballerEmployed));
                        save(footballers);
                        break;
             }
             
      }
}