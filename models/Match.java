package models;
import java.time.*;

public class Match implements Model
{
      private int lastID;
      private int matchID;
      private LocalDate matchDate;
      private int matchOpponentID;
      private char matchHomeOrAway;
      private int matchHomeGoals;
      private int matchAwayGoals;
      private String matchFormation;
      private String matchLineup;
      
      
      public Match(LocalDate matchDate, int matchOpponentID, char matchHomeOrAway, int matchHomeGoals, int matchAwayGoals, String matchFormation, String matchLineup)
      {
            matchID = lastID++;
            this.matchDate = matchDate;
            this.matchOpponentID = matchOpponentID;
            this.matchHomeOrAway = matchHomeOrAway;
            this.matchHomeGoals = matchHomeGoals;
            this.matchAwayGoals = matchAwayGoals;
            this.matchFormation = matchFormation;
            this.matchLineup = matchLineup;
      }
      //mangler metode og konstruktor der generere ID baseret på filindhold.
      
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
      
      public int getID()
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
      
      public void setMatchDate()
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