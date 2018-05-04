package models;

public class Goal implements Model
{
      private int goalID;
      private int goalMatchID;
      private int goalScorer;
      private int goalMinuteScored;
      private char goalType;
      private int goalAssistingPlayer;
      
      //Mangler metode til at generere ID baseret på filindhold.
      
      public Goal(int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalScorer = goalScorer;
            this.goalMatchID = goalMatchID;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      
      public Goal(int id, int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalID = id;
            this.goalScorer = goalScorer;
            this.goalMatchID = goalMatchID;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      public int getGoalScorer()
      {
            return goalScorer;
      }
      
      public void setGoalScorer(int goalScorer)
      {
            this.goalScorer = goalScorer;
      }
      
      public int getGoalMatchID()
      {
            return goalMatchID;
      }
      
      public void setgoalMatchID(int goalMatchID)
      {
            this.goalMatchID = goalMatchID;      
      }    
      
      public int getGoalMinuteScored()
      {
            return goalMinuteScored;
      }
      
      public void setGoalMinuteScored(int goalMinuteScored)
      {
            this.goalMinuteScored = goalMinuteScored;
      }
      
      
      public char getGoalType()
      {
            return goalType;
      }
      
      public void setGoalType(char goalType)
      {
            this.goalType = goalType;      
      }
      
      public int getGoalAssistingPlayer()
      {
            return goalAssistingPlayer;
      }
      
      public void setGoalAssistingPlayer(int goalAssistingPlayer)
      {
      this.goalAssistingPlayer = goalAssistingPlayer;
      }
      
      public int getID()
      {
            return goalID;     
      }     
}