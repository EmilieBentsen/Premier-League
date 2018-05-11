package models;

public class Goal implements Model
{
      private int goalID; //Målets id, bruges til at identificere den enkelte fodboldspiller i forhold til mål og kampe.
      private int goalMatchID; //bruges til at identificere hvilken kamp målet er scoret i (skal vi have et kampobjekt i stedet?)
      private int goalScorer; //er et spiller id og bruges til at pare målet med en enkel spiller
      private int goalMinuteScored; 
      private char goalType; // Er målet scoret på straffe, er det et selvmål eller??
      private int goalAssistingPlayer; //bruges til at se hvem der har lagt op til målet og er også et spiller id.
            
      //kontsruktor til at oprette Goals der indlæses fra fil
      public Goal(int goalID, int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalID = goalID;
            this.goalMatchID = goalMatchID;
            this.goalScorer = goalScorer;
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
      
      public void setGoalMatchID(int goalMatchID)
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
      
      public String getGoalTypeToString()
      {
            if(goalType == 'R')
            {
                  return "In play";
            }
            else if(goalType == 'p')
            {
                  return "penalty";            
            }
            else if(goalType == 'O')
            {
                  return "Own goal";
            }
            return null;
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
      
      public int getID()//Krav fra interfacet Model
      {
            return goalID;     
      }     
}