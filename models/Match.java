package models;
import java.time.*;

public class Match implements Model
{
      private int matchID; //bruges til at identificere den enkelte kamp.
      private LocalDate matchDate; //opbjekt af LocalDate, dato-system af typen (åååå-mm-dd)
      private int matchOpponentID; //bruges til at identificere modstanderen af den enkelte kamp
      private char matchHomeOrAway; //H for hjemme A for ude
      private int matchHomeGoals; //antal mål scoret af hjemmeholdet
      private int matchAwayGoals; //antal mål scoret af udeholdet
      private String matchFormation; //talkombination der beskriver den spillede formation f.eks. 4-4-2
      private String matchLineup; //liste over de liverpoll spillere deer spillede kampen, sat i formation
      
      // Kontruktor til at oprette Match'es der læses fra fil
      public Match(int matchID, LocalDate matchDate, int matchOpponentID, char matchHomeOrAway, int matchHomeGoals, int matchAwayGoals, String matchFormation, String matchLineup)
      {
            this.matchID = matchID;
            this.matchDate = matchDate;
            this.matchOpponentID = matchOpponentID;
            this.matchHomeOrAway = matchHomeOrAway;
            this.matchHomeGoals = matchHomeGoals;
            this.matchAwayGoals = matchAwayGoals;
            this.matchFormation = matchFormation;
            this.matchLineup = matchLineup;
      }
      
      public int getID()//krav fra interfacet Model
      {
            return matchID;
      }
      
      public LocalDate getMatchDate()
      {
            return matchDate;
      }
      
      public int getMatchOpponentID()
      {
            return matchOpponentID;
      }
      
      public char getMatchHomeOrAway()
      {
            return matchHomeOrAway;
      }
      
      public int getMatchHomeGoals()
      {
            return matchHomeGoals;
      }
      
      public int getMatchAwayGoals()
      {
            return matchAwayGoals;
      }
      
      public String getMatchFormation()
      {
            return matchFormation;
      }
      
      public String getMatchLineup()
      {
            return matchLineup;
      }
      
      public void setMatchDate(LocalDate matchDate)
      {
            this.matchDate = matchDate;
      }
      
      public void setMatchOpponentID(int matchOpponentID)
      {
            this.matchOpponentID = matchOpponentID;
      }
      
      public void setMatchHomeOrAway(char matchHomeOrAway)
      {
            this.matchHomeOrAway = matchHomeOrAway;      
      }
      
      public void setMatchHomeGoals(int matchHomeGoals)
      {
            this.matchHomeGoals = matchHomeGoals;
      }
      
      public void setMatchAwayGoals(int matchAwayGoals)
      {
            this.matchAwayGoals = matchAwayGoals;
      }
      
      public void setMatchFormation(String matchFormation)
      {
            this.matchFormation = matchFormation;
      }
      
      public void setMatchLineup(String matchLineup)
      {
            this.matchLineup = matchLineup;
      }      
}