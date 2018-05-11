package models;

public class Goal implements Model
{
      private int goalID; //M�lets unikke ID.
      private int goalMatchID; //Identificerer hvilken kamp m�let er scoret i.
      private int goalScorer; //Et spiller id, der bruges til at parre m�let med m�lscoreren
      private int goalMinuteScored;  //Minuttet m�let er scoret.
      private char goalType; //M�l kan v�re (R)egular, (P)enalty eller (O)wn goal
      private int goalAssistingPlayer; //Hvis m�let var et R m�l, kan det v�re et assist. Dette er et spillerID.
            
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