package models;

public abstract class Footballer implements Model
{
      private int footballerID; //bruges til at identificere den enkelte fodboldspiller i forhold til mål og kampe.
      private int footballerJersey; 
      private String footballerName;  
      private String footballerSalary; 
      private boolean footballerEmployed;
      private int lastID;       
      
      // Konstruktor til ny oprettede Footballers, hvor der skal autogenereres et FootballerID
      public Footballer(int footballerJersey, String footballerName, String footballerSalary, 
      boolean footballerEmployed)
      {
            lastID = 
            this.footballerID = lastID++;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
      
      //kontsruktor til Footballers der indlæses fra fil
      public Footballer(int id, int footballerJersey, String footballerName,String footballerSalary, 
      boolean footballerEmployed)
      {
            this.footballerID = id;
            this.footballerJersey = footballerJersey;
            this.footballerName = footballerName;
            this.footballerSalary = footballerSalary;
            this.footballerEmployed = footballerEmployed;
      }
            
      public int getID()//Kræves af interfacet Model
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

      public abstract String getFootballerPosition(); // alle supclasses skal overskrive denne metode
}