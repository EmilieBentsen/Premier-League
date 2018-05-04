package models.footballertypes;
import models.Footballer;

public class Manager extends Footballer
{
      public Manager (int footballerJersey, String footballerName, String footballerSalary, 
      boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public Manager (int id, int footballerJersey, String footballerName,String footballerSalary, 
      boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition()
      {
            return "MN";
      }
}