package models;
import java.time.*;

public class Match
{
      public int matchID;
      public LocalDate matchDate;
      public int matchOpponentID;
      public char matchHomeOrAway;
      public int matchHomeGoals;
      public int matchAwayGoals;
      public String matchFormation;
      public String matchLineup;
      
      public createMatch(public LocalDate matchDate, public int matchOpponentID, public char matchHomeOrAway, public int matchHomeGoals, public int matchAwayGoals, public String matchFormation, public String matchLineup)
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
      
      public int getMatchID()
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
}