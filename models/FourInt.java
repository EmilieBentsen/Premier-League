package models;

public class FourInt
{
      private int played;
      private int won;
      private int draw;
      private int lost;
      
      public FourInt(int played, int won, int draw, int lost)
      {
            this.played = played;
            this.won = won;
            this.draw = draw;
            this.lost = lost;
      }
      
      public int getPlayed()
      {
            return played;
      }
      public int getWon()
      {
            return won;
      }
      
      public int getDraw()
      {
            return draw;
      }
      
      public int getLost()
      {
            return lost;
      }
}