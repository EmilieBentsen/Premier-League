package models;

public class Opponent
{
      private int opponentID;
      private String opponentName;
      private boolean opponentActive;
      private static int lastID;
      
      //Mangler metode til at generere ID baseret på filindhold.
      
      
      public Opponent(String opponentName, boolean opponentActive)
      {
            opponentID = lastID++;
            this.opponentName = opponentName;
            this.opponentActive = opponentActive;
      }
      //Mangler constructor der der tager i mod en String.
      
      public void setOpponentName(String opponentName)
      {
            this.opponentName = opponentName;
      }
      
      public void setOpponentActive(boolean opponentActive)
      {
            this.opponentActive = opponentActive;
      }
      
      public String getOpponentName()
      {
            return opponentName;
      }
      
      public int getID()
      {
            return opponentID;
      }
      
      public boolean getOpponentActive()
      {
            return opponentActive;
      }
      
      public String toString()
      {
            String details = this.getID()+ "," + this.getOpponentName() + "," + this.getOpponentActive();
            return details;
      }
}