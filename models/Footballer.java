package models;

public abstract class Footballer
{
      private int footballerID; 
      private int footballerJersey; 
      private String footballerName; 
      private String footballerPosition; 
      private String footballerSalary; 
      private boolean footballerEmployed;
      
      public createFootballer(int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerPosition = footballerPosition;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
      
      public getFootballer(int footballerID, int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed )
      {
            this.footballerID = footballerID;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerPosition = footballerPosition;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
      
      public int getFootballerID()
      {
            return footballerID;
      }
      
      public int getFootballerJersey()
      {
            return footballerJersey;
      }
      
      public String getFootballerPosition()
      {
            return footballerPosition;
      }
      
      public String getFootballerSalary()
      {
            return footballerSalary;
      }
      
      public boolean getFootballerEmployed()
      {
            return footballerEmployed;
      }
}