package handlers;

import models.Opponent;
import handlers.FileHandler;
import java.util.Scanner;
import java.util.ArrayList;

public class OpponentHandler extends ObjectHandler<Opponent> //specifocerer hvilken type objekter vi arbejder med i denne klasse
{
      private static OpponentHandler instance;
      private ArrayList<Opponent> opponents; 
      
      public OpponentHandler()
      {
            opponents = getContent();
      }
      
      public static OpponentHandler getOpponentHandler()
      {
            if(instance == null)
            {
                  OpponentHandler oh = new OpponentHandler();
                  instance = oh;
            }
            return instance;
      }
      
      public String getFilePath()
      {
            return "opponent.csv";
      }
      
      public PersistentObjectHandler<Opponent> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return new PersistentObjectHandler<Opponent>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(Opponent o)//PersistentObjectHandler kræver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return o.getID() 
                        + "," + o.getOpponentName() 
                        + "," + o.getOpponentActive();
                  }
      
                  public Opponent objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]); //laver strings i arraylisten om til int.
                        String opponentName = components[1];
                        boolean active = Boolean.parseBoolean(components[2]);
                        
                        return new Opponent(id, opponentName, active); //obretter er nyt object af footballer                      
                  }
            };
      }
      
      public void listOpponents()//metode printer en liste med opponents
      {           
            for(Opponent i : opponents)
            {
                  System.out.println(i.getID() + " " + i.getOpponentName() + " " + i.getOpponentActive());   
            }
      }
      
      public void deleteOpponent(int id) //Metoden sletter en opponent. Metoden kalder deleteObject i ObjectHandler med ArrayList opponent og et opponentID
      {
            deleteObject(opponents, id);
      }
      
      public ArrayList getOpponentArray()//Metoden der returnerer et ArrayList opponents
      {
            return opponents;
      }
      
      public int getNewOpponentID()//metode til at generere nyt opponentID. Kalder metoden getNewID i ObjectHandler med ArrayList opponents
      {
            int newID= getNewID(opponents);
            return newID;
      }
      public void updateObject(int opponentID, String opponentName, boolean opponentActive) //Metode der opdatere en match vha. set metoder.
      {
            for(Opponent i : opponents)
            {
                  if (i.getID() == opponentID)
                  {
                        i.setOpponentName(opponentName);
                        i.setOpponentActive(opponentActive);
                        save(opponents);
                  }
            }
      }
      
      public void createObject(String opponentName, boolean opponentActive) //Metode til at oprette en ny opponent. Nyt opponentID bliver autogenereret
      {
             opponents.add(new Opponent(getNewOpponentID(), opponentName, opponentActive));
             save(opponents);
      }  
}