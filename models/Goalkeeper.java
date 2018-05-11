package models;

public class Goalkeeper extends Footballer 
{
      //Constructor
      public Goalkeeper(int id, int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(id,footballerJersey,footballerName,footballerSalary,footballerEmployed);
      }
      
      public String getFootballerPosition() //Implementeringen
      {
            return "GK";
      }
}