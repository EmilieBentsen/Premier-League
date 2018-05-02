public class Goal
{
      private int goalID;
      private int goalScorer;
      private int goalMinuteScored;
      private char goalType;
      private int goalAssistingPlayer;
      
      public goal(int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            this.goalScorer = goalScorer;
            this.goalMinuteScored = goalMinuteScored;
            this.goalType = goalType;
            this.goalAssistingPlayer = goalAssistingPlayer;
      }
      
      public int getGoalScorer()
      {
            return goalScorer;
      }
      
      public int getGoalMinuteScored()
      {
            return goalMinuteScored;
      }
      
      public char getGoalType()
      {
            return goalType;
      }
      
      public int getGoalAssistingPlayer()
      {
            return goalAssistingPlayer;
      }     
}