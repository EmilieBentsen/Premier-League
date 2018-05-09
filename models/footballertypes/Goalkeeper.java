package models.footballertypes;
import models.Footballer;

public class Goalkeeper extends Footballer 
{
      // Konstruktor til ny oprettede Goalkeepers, hvor der skal autogenereres et FootballerID
      public Goalkeeper(int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(footballerJersey,footballerName,footballerSalary,footballerEmployed);
      }
      
      //kontsruktor til at oprette Goalkeepers der indlæses fra fil
      public Goalkeeper(int id, int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(id,footballerJersey,footballerName,footballerSalary,footballerEmployed);
      }
      
      public String getFootballerPosition() //implementeringen af superklassen's metode
      {
            return "GK";
      }
}