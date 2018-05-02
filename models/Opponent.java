package models;

public class Opponent
{
      private int opponentID;
      private String opponentName;
      private boolean opponentActive;
      
      public Opponent(int opponentID, String opponentName, boolean opponentActive)
      {
            this.opponentID = opponentID;
            this.opponentName = opponentName;
            this.opponentActive = opponentActive;
      }
      
      public void createOpponent(String opponentName, boolean opponentActive)
      {
            this.opponentName = opponentName;
            this.opponentActive = opponentActive;
      }
      
      public String getOpponentName()
      {
            return opponentName;
      }
      
      public int getOpponentID()
      {
            return opponentID;
      }
      
      public boolean getOpponentActive()
      {
            return opponentActive;
      }
      
      public String toString(Opponent o)
      {
            String details = o.getOpponentID()+ "," + o.getOpponentName() + "," + o.getOpponentActive();
            return details;
      }
}