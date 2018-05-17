package models;
//Lasse: Har skrevet dele af koden.
public class Opponent implements Model
{
      private int opponentID;
      private String opponentName;
      private boolean opponentActive; //Er modstanderen i Premier League?

      //Constructor
      public Opponent(int id, String opponentName, boolean opponentActive)
      {
            this.opponentID = id;
            this.opponentName = opponentName;
            this.opponentActive = opponentActive;
      }
      
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
      
      public int getID() //Krav fra interfacet Model
      {
            return opponentID;
      }
      
      public boolean getOpponentActive()
      {
            return opponentActive;
      }
      
      @Override
      public String toString()
      {
            String details = this.getID()+ "," + this.getOpponentName() + "," + this.getOpponentActive();
            return details;
      }
}