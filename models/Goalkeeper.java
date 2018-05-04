package models;


public class Goalkeeper extends Footballer implements Model
{
      public Goalkeeper(int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey,footballerName,footballerPosition,footballerSalary,footballerEmployed);
      }
      
      public Goalkeeper(int id, int footballerJersey, String footballerName, String footballerPosition, String footballerSalary, boolean footballerEmployed)
      {
            super(id,footballerJersey,footballerName,footballerPosition,footballerSalary,footballerEmployed);
      }
      
      public String getFootballerPosition()
      {
            return "GK";
      }
}