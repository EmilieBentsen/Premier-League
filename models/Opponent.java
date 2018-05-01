package models;

public class Opponent
{
      public int opponentID;
      public String opponentName;
      
      public Opponent(int opponentID, String opponentName)
      {
            this.opponentID = opponentID;
            this.opponentName = opponentName;
      }
      
      public void createOpponent(String opponentName)
      {
            this.opponentName = opponentName;
      }
      
      public String getOpponentName()
      {
            return opponentName;
      }
      
      public int getOpponentID()
      {
            return opponentID;
      }
      
      public String toString(Opponent o)
      {
            String details = o.getOpponentID()+ " " + o.getOpponentName();
            return details;
      }
}