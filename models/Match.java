package models;
import java.time.*;
//Adam Birch
public class Match implements Model
{
      private int matchID; //Identificere den enkelte kamp.
      private LocalDate matchDate; //Object af LocalDate. https://docs.oracle.com/javase/10/docs/api/java/time/class-use/LocalDate.html
      private int matchOpponentID; //Identificere modstanderen af den enkelte kamp
      private char matchHomeOrAway; //(H)ome / (A)way
      private int matchHomeGoals;
      private int matchAwayGoals;
      private String matchFormation; //Opstillingens form. Format: X-Y-Z eller X-Y-Z-W
      private String matchLineup; //Startopstillingens spillere. Format: 1-2-3-4-5-6-7-8-9-10-11 Starter med målmand, fra venstre mod højre.
      
      //Constructor
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
      
      public int getID() //Krav fra superclass.
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