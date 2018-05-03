public class Goal
{
      private int goalID;
      private int goalScorer;
      private int goalMinuteScored;
      private char goalType;
      private int goalAssistingPlayer;
      
      //Mangler metode til at generere ID baseret på filindhold.
      
      public Goal(int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalScorer = goalScorer;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      //Mangler constructor der der tager i mod en String.
      
      public int getGoalScorer()
      {
            return goalScorer;
      }
      
      public void setGoalScorer(int goalScorer)
      {
            this.goalScorer = goalScorer;
      }
      
      public int getGoalMinuteScored()
      {
            return goalMinuteScored;
      }
      
      public int setGoalMinuteScored(int goalMinuteScored)
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
}