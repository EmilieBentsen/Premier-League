package models;

public class Midfielder extends Footballer
{
      public Midfielder (int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public Midfielder (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition()
      {
            return "MF";
      }

}