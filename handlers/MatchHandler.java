package handlers;
import models.*;
import java.util.*;

public class MatchHandler extends ObjectHandler<Match> 
{
      ArrayList<Match> matches = getContent();
      
      public String getFilePath()
      {
            return "match.csv";
      }
      
      public PersistentObjectHandler<Match> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return new PersistentObjectHandler<Match>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(Match match)//PersistentObjectHandler kræver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return match.getID() + "," + match.getMatchDate() + "," + match.getMatchOpponentID() + "," 
                        + match.getMatchHomeOrAway() + "," + match.getMatchHomeGoals() + "," + match.getMatchAwayGoals() + "," + getMatchFormation() + "," + getMatchLineup();
                  }
      
                  public Footballer objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]);//laver strings i arraylisten om til int.
                        int opponentID = Integer.parseInt(components[2]);
                        int homeGoals = Integer.parseInt(components[4]);
                        int awayGoals = Integer.parseInt(components[5]);
                        
                        return new Match(id, components[1], opponentID, components[3], homeGoals, awayGoals, components[6], components[7]); //obretter er nyt object af footballer                      
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