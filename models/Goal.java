package models;

public class Goal implements Model
{
      private int goalID; //bruges til at identificere den enkelte fodboldspiller i forhold til m�l og kampe.
      private int goalMatchID; //bruges til at identificere hvilken kamp m�let er scoret i (skal vi have et kampobjekt i stedet?)
      private int goalScorer; //er et spiller id og bruges til at pare m�let med en enkel spiller
      private int goalMinuteScored; 
      private char goalType; // Er m�let scoret p� straffe, er det et selvm�l eller??
      private int goalAssistingPlayer; //bruges til at se hvem der har lagt op til m�let og er ogs� et spiller id.
      
      //Mangler metode til at generere ID baseret p� filindhold.
      
      // Konstruktor til ny oprettede Goals, hvor der skal autogenereres et goalID
      public Goal(int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalScorer = goalScorer;
            this.goalMatchID = goalMatchID;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      
      //kontsruktor til at oprette Goals der indl�ses fra fil
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
      
      public int getID()//Krav fra interfacet Model
      {
            return goalID;     
      }     
}