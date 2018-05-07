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
      
      public void updateObject(int matchID, LocalDate matchDate, int matchOpponentID, char matchHomeOrAway, 
      int matchHomeGoals, int matchAwayGoals, String matchFormation, String matchLineup) //Metode til at opdatere kampe med id.
      {
            for(Match i : matches)
            {
                  if (i.getID() == matchID)
                  {
                        i.setMatchDate(matchDate);
                        i.setMatchOpponentID(matchOpponentID);
                        i.setMatchHomeOrAway(matchHomeOrAway);
                        i.setMatchHomeGoals(matchHomeGoals);
                        i.setMatchAwayGoals(matchAwayGoals);
                        i.setMatchFormation(matchFormation);
                        i.setMatchLineup(matchLineup);
                        save(matches);
                  }
            }
      }
      
      public void createObject(LocalDate matchDate, int matchOpponentID, //metode til at oprette kampe
      char matchHomeOrAway, int matchHomeGoals, int matchAwayGoals, String matchFormation, String matchLineup)
      {
             matches.add(new Match(getNewMatchID(), matchDate, matchOpponentID, matchHomeOrAway, matchHomeGoals, 
             matchAwayGoals, matchFormation, matchLineup));
             save(matches);
      }
          
      public ArrayList getMatchArray()// metode der returnerer et arraylist med kampe
      {
            return matches;
      }
      
      
      public void listMatches() //metode der printer en liste med objekter
      {           
            for(Match i : matches)
            {
                  System.out.println(i.getID() + " " + i.getMatchDate() + " " + i.getMatchOpponentID() + " " 
                  + i.getMatchHomeOrAway() + " " + i.getMatchHomeGoals() + " " + i.getMatchAwayGoals()+ " " + i.getMatchFormation()+ " " + i.getMatchLineup());   
            }
      }
      
      public void deleteMatch(int id)//Metoden sletter en match. Metoden kalder deleteObject i ObjectHandler med ArrayList matches og et matchID
      {
            deleteObject(matches, id);
      }
      
      public int getNewMatchID() //Metode der laver et nyt matchID. Metoden kalder getNewID med ArrayList matches
      {
            int newID= getNewID(matches);
            return newID;
      }
}