package models.footballertypes;
import models.Footballer;

public class Forward extends Footballer
{
      // Konstruktor til ny oprettede Forwards, hvor der skal autogenereres et FootballerID
      public Forward (int footballerJersey, String footballerName, String footballerSalary, 
      boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      //kontsruktor til at oprette Forwards der indlæses fra fil
      public Forward (int id, int footballerJersey, String footballerName,String footballerSalary, 
      boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //implementeringen af superklassen's metode
      {
            return "FW";
      }
}