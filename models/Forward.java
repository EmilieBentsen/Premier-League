package models;

public class Forward extends Footballer
{
      public Forward (int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public Forward (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition()
      {
            return "FW";
      }
}