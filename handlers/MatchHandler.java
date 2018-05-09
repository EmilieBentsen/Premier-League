package handlers;
import models.*;
import java.util.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatchHandler extends ObjectHandler<Match> 
{
      private ArrayList<Match> matches;
      private static MatchHandler instance;
      
      private MatchHandler()
      {
            matches = getContent();
      }
      
      public static MatchHandler getMatchHandler()
      {
            if(instance == null)
            {
                  MatchHandler mh = new MatchHandler();
                  instance = mh;
            }
            return instance;
      }
      
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
          
      public ArrayList getMatchArray()// metode der returnerer et arraylist med kampe. Efter indførsel af singleton løsning virker dette redundant.
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
      
      public boolean checkStringForItem(String source, String subItem){
         String pattern = "\\b"+subItem+"\\b"; //\\b sørger for du kun får match på 1, og ikke på 15, 16, 17 osv. På samme måde fanger den kun husene og ikke huse, ved indtastning af "husene".
         Pattern p=Pattern.compile(pattern); //Pattern laver det mønster vi leder efter. I dette tilfælde subItem.
         Matcher m=p.matcher(source); //Hvis mønsteret vi leder efter findes via Matcher returneres en boolean.
         return m.find();
         
         //En alternativ måde at skrive ovenstående på er Pattern.matches(pattern, source); 
      }
      
      public int cleanSheetsByFootballer(String footballerJersey)
      {
            int count = 0;
            for (Match i : matches)
            {          
                  if(i.getMatchFormation().equals("0-0-0"))
                  {
                        break;
                  }
                          
                  if (((i.getMatchHomeOrAway() == 'A' && i.getMatchHomeGoals() == 0) || (i.getMatchHomeOrAway() == 'H' && i.getMatchAwayGoals() == 0)) && !i.getMatchFormation().equals("0-0-0"))
                  {                        
                        if(checkStringForItem(i.getMatchLineup(), footballerJersey)) //Hvis spilleren var i opstillingen den dag
                        { 
                              count++;
                        }
                  }
            }
            return count;
      }
      
      public int matchesPlayedByFootballer(String footballerJersey)
      {
            int count = 0;
            for (Match i : matches)
            {                  
                                          
                  if(checkStringForItem(i.getMatchLineup(), footballerJersey)) //Hvis spilleren var i opstillingen den dag
                  { 
                        count++;
                  }
            }
            return count;
      }
      
      public int cleanSheetsByClub()
      {
            int count = 0;
            for (Match i : matches)
            {
                  if(i.getMatchFormation().equals("0-0-0"))
                  {
                        break;
                  }
                  
                  if ((i.getMatchHomeOrAway() == 'A' && i.getMatchHomeGoals() == 0) || (i.getMatchHomeOrAway() == 'H' && i.getMatchAwayGoals() == 0) && !i.getMatchFormation().equals("0-0-0"))
                  {
                        count++;
                  }
            }
            return count;
      }
      
      public int goalsConcededByClub()
      {
            int count = 0;
            for (Match i : matches)
            {
                  if(i.getMatchHomeOrAway() == 'H' && i.getMatchAwayGoals() > 0)
                  {
                        count += i.getMatchAwayGoals();
                  }      
                  else if(i.getMatchHomeOrAway() == 'A' && i.getMatchHomeGoals() > 0)
                  {
                        count += i.getMatchHomeGoals();
                  }
            }
            return count;
      }
      
      public String matchesPlayedWonDrawLostByClub()
      {
            int countPlayed = 0;
            int countWon = 0;
            int countDraw = 0;
            int countLost = 0;
            
            for (Match i : matches)
            {
                  if(i.getMatchFormation().equals("0-0-0"))
                  {
                        break;
                  }
                  else countPlayed++;
                  
                  if(i.getMatchHomeOrAway() == 'H' && i.getMatchHomeGoals() > i.getMatchAwayGoals() || i.getMatchHomeOrAway() == 'A' && i.getMatchHomeGoals() < i.getMatchAwayGoals())
                  {
                        countWon++;
                  }
                  else if(i.getMatchHomeGoals() == i.getMatchAwayGoals())
                  {
                        countDraw++;
                  }
                  else if(i.getMatchHomeOrAway() == 'H' && i.getMatchHomeGoals() < i.getMatchAwayGoals() || i.getMatchHomeOrAway() == 'A' && i.getMatchHomeGoals() > i.getMatchAwayGoals())
                  {
                        countLost++;
                  }
            }
            String count = countPlayed + "," + countWon + "," + countDraw + "," + countLost;
            return count;
      }
      
      public void deleteMatch(int id)
      {
            deleteObject(matches, id);
      }
      
      public int getNewMatchID()
      {
            int newID = getNewID(matches);
            return newID;
      }
      
      public ArrayList getMatchesPlayedInPeriod(LocalDate startDate, LocalDate endDate, int footballerJersey)
      {
            ArrayList<Match> matchesPlayedInPeriod = new ArrayList<Match>(); 
            ArrayList<Match> matchesInPeriod = matchesInPeriod(startDate, endDate);
            for(Match i : matchesInPeriod)
            {
                        String[] stringArrayLineup = i.getMatchLineup().split("-");
                        int[] intArrayLineup = new int[stringArrayLineup.length];
                        for (int j = 0; j < stringArrayLineup.length; j++) 
                        {
                        String numberAsString = stringArrayLineup[j];
                        intArrayLineup[j] = Integer.parseInt(numberAsString);
                        }
                        
                        for(int k : intArrayLineup)
                        {
                              if(k == footballerJersey)
                              {
                                   matchesPlayedInPeriod.add(new Match(i.getID(), i.getMatchDate(), i.getMatchOpponentID(), i.getMatchHomeOrAway(), i.getMatchHomeGoals(), 
                                   i.getMatchAwayGoals(), i.getMatchFormation(), i.getMatchLineup())); 
                              }
                        }
             } 
            
            return matchesPlayedInPeriod;
       }
           
      
      
      public ArrayList matchesInPeriod(LocalDate startDate, LocalDate endDate)
      {
            ArrayList<Match> matchesInPeriod = new ArrayList<Match>(); 
            for(Match i : matches)
            {
                  if(i.getMatchDate().isAfter(startDate)|| i.getMatchDate().isEqual(startDate) && i.getMatchDate().isBefore(endDate)|| i.getMatchDate().isEqual(endDate))
                  {
                                   matchesInPeriod.add(new Match(i.getID(), i.getMatchDate(), i.getMatchOpponentID(), i.getMatchHomeOrAway(), i.getMatchHomeGoals(), 
                                   i.getMatchAwayGoals(), i.getMatchFormation(), i.getMatchLineup())); 
                  }
            }
            return matchesInPeriod;
      } 
      
}