package models.footballertypes;
import models.Footballer;

public class Midfielder extends Footballer
{
      // Konstruktor til ny oprettede Midfielders, hvor der skal autogenereres et FootballerID
      public Midfielder (int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      //kontsruktor til at oprette Midfielders der indlæses fra fil
      public Midfielder (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //implementeringen af superklassen's metode
      {
            return "MF";
      }
}