package handlers;
import models.*;
import java.util.*;
import java.time.LocalDate;

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
                        + match.getMatchHomeOrAway() + "," + match.getMatchHomeGoals() + "," + match.getMatchAwayGoals() + "," + match.getMatchFormation() + "," + match.getMatchLineup();
                  }
      
                  public Match objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]);//laver strings i arraylisten om til int.
                        LocalDate date = LocalDate.parse(components[1]);
                        int opponentID = Integer.parseInt(components[2]);
                        char homeOrAway = (components[3]).charAt(0);
                        int homeGoals = Integer.parseInt(components[4]);
                        int awayGoals = Integer.parseInt(components[5]);
                        
                        return new Match(id, date, opponentID, homeOrAway, homeGoals, awayGoals, components[6], components[7]); //obretter er nyt object af footballer                      
                  }
            };
      }
      
      public void updateObject(ArrayList<Match> matches, int matchID, LocalDate matchDate, int matchOpponentID, char matchHomeOrAway, int matchHomeGoals, int matchAwayGoals, String matchFormation, String matchLineUp)
      {
            for(Match i : matches)
            {
                  if (i.getID() == matchID)
                  {
                        matches.remove(i);
                        matches.add(new Match(matchID, matchDate, matchOpponentID, matchHomeOrAway, matchHomeGoals, matchAwayGoals, matchFormation, matchLineUp));
                        save(matches);
                  }
            }
      }
      
      public void createObject()
      {
            
      }
}