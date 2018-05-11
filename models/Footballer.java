package models;

public abstract class Footballer implements Model
{
      private int footballerID;
      private int footballerJersey; 
      private String footballerName;  
      private String footballerSalary; 
      private boolean footballerEmployed;
      
      //Constructor til Footballer
      public Footballer(int footballerID, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            this.footballerID = footballerID;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
            
      public int getID() //Implementering fra superclass.
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
      
      public String toString()
      {
            return footballerJersey + " " + footballerName + " " + footballerSalary + " " + footballerEmployed + " ";
      }

      public abstract String getFootballerPosition(); //Alle subclasses skal indeholde denne metode.
}