package models;

public abstract class Footballer
{
      public int footballerID; 
      public int footballerJersey; 
      public String footballerName; 
      public String footballerPosition; 
      public String footballerSalary; 
      public boolean footballerEmployed;
      
      public createFootballer(int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
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