package handlers;

import models.Opponent;
import handlers.FileHandler;
import java.util.Scanner;
import java.util.ArrayList;

public class OpponentHandler extends ObjectHandler<Opponent> //specifocerer hvilken type objekter vi arbejder med i denne klasse
{

      private ArrayList<Opponent> opponents = getContent();
      
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
      
      public void listOpponents()
      {           
            for(Opponent i : opponents)
            {
                  System.out.println(i.getID() + " " + i.getOpponentName() + " " + i.getOpponentActive());   
            }
      }
      
      public void deleteOpponent(int id)
      {
            deleteObject(opponents, id);
      }
      
      public ArrayList getOpponentArray()
      {
            return opponents;
      }
      
      public int getNewOpponentID()
      {
            int newID= getNewID(opponents);
            return newID;
      }
      public void updateObject()
      {
      
      }
      
      public void createObject()
      {
            
      }
}