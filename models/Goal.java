package models;

public class Goal implements Model
{
      private int goalID; //Målets unikke ID.
      private int goalMatchID; //Identificerer hvilken kamp målet er scoret i.
      private int goalScorer; //Et spiller id, der bruges til at parre målet med målscoreren
      private int goalMinuteScored;  //Minuttet målet er scoret.
      private char goalType; //Mål kan være (R)egular, (P)enalty eller (O)wn goal
      private int goalAssistingPlayer; //Hvis målet var et R mål, kan det være et assist. Dette er et spillerID.
            
      //Constructor
      public Goal(int goalID, int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalID = goalID;
            this.goalMatchID = goalMatchID;
            this.goalScorer = goalScorer;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      
      public int getID()//Implementering fra superclass.
      {
            return goalID;     
      }
      
      public int getGoalScorer()
      {
            return goalScorer;
      }
      
      public int getGoalMatchID()
      {
            return goalMatchID;
      }

      public String getGoalTypeToString()
      {
            if(goalType == 'R')
            {
                  return "From play.";
            }
            else if(goalType == 'p')
            {
                  return "Penalty.";            
            }
            else if(goalType == 'O')
            {
                  return "Own Goal.";
            }
            return null;
      }

      public int getGoalMinuteScored()
      {
            return goalMinuteScored;
      }

      public int getGoalAssistingPlayer()
      {
            return goalAssistingPlayer;
      }
                                    
      public void setGoalScorer(int goalScorer)
      {
            this.goalScorer = goalScorer;
      }

      public void setGoalMatchID(int goalMatchID)
      {
            this.goalMatchID = goalMatchID;      
      }    
      
      public void setGoalMinuteScored(int goalMinuteScored)
      {
            this.goalMinuteScored = goalMinuteScored;
      }

      public void setGoalType(char goalType)
      {
            this.goalType = goalType;      
      }
            
      public void setGoalAssistingPlayer(int goalAssistingPlayer)
      {
      this.goalAssistingPlayer = goalAssistingPlayer;
      }
}