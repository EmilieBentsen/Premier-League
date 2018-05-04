package models;


public class Goalkeeper extends Footballer 
{
      public Goalkeeper(int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey,footballerName,footballerSalary,footballerEmployed);
      }
      
      public Goalkeeper(int id, int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(id,footballerJersey,footballerName,footballerSalary,footballerEmployed);
      }
      
      public String getFootballerPosition()
      {
            return "GK";
      }
}