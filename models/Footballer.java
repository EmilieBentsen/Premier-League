package models;

public class Footballer
{
      private int footballerID; 
      private int footballerJersey; 
      private String footballerName; 
      private String footballerPosition; 
      private String footballerSalary; 
      private boolean footballerEmployed;
      private static int lastID;
      
      //Mangler metode til at generere ID baseret på filindhold.
      
      public Footballer(int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
            this.footballerID = lastID++;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerPosition = footballerPosition;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
      
      public Footballer(int id, int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
            this.footballerID = id;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerPosition = footballerPosition;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
      
      public int getID()
      {
            return footballerID;
      }
      
      public int getFootballerJersey()
      {
            return footballerJersey;
      }
      
      public void setFootballerJersey(int footballerJersey)
      {
            this.footballerJersey = footballerJersey;
      }
      
      public String getFootballerName()
      {
            return footballerName;
      }
      
      public void setFootballerName(String footballerName)
      {
            this.footballerName = footballerName;
      }
      
      public String getFootballerPosition()
      {
            return footballerPosition;
      }
      
      public void setFootballerPosition(String footballerPosition)
      {
            this.footballerPosition = footballerPosition;
      }
      
      public String getFootballerSalary()
      {
            return footballerSalary;
      }
      
      public void setFootballerSalary(String footballerSalary)
      {
            this.footballerSalary = footballerSalary;
      }
      
      public boolean getFootballerEmployed()
      {
            return footballerEmployed;
      }
      
      public void setFootballerEmployed(boolean footballerEmployed)
      {
            this.footballerEmployed = footballerEmployed;
      }
}