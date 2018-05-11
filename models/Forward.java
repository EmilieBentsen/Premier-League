package models;

public class Forward extends Footballer
{
      //Constructor til en forward/angriber
      public Forward (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //Implementering fra superclass.
      {
            return "FW";
      }
}