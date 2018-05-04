package models;

public class Opponent implements Model
{
      private int opponentID;//bruges til at identificere den enkelte modstaner.
      private String opponentName;
      private boolean opponentActive; //Vi sletter ikke modstandere, hvis et hold rykker ned og derfor ikke møder liverpool sættes de til false
      private static int lastID; // bruges til at autogenere ID til nyoprettede Hold
      
      //Mangler metode til at generere ID baseret på filindhold.
      
      // Konstruktor til ny oprettede Opponents, hvor der skal autogenereres et opponentID
      public Opponent(String opponentName, boolean opponentActive)
      {
            opponentID = lastID++;
            this.opponentName = opponentName;
            this.opponentActive = opponentActive;
      }
      
      // Kontruktor til at oprette Opponents der læses fra fil
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
      
      public int getID() // Krav fra interfacet Model
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