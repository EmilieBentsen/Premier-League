package models.footballertypes;
import models.Footballer;

public class Defender extends Footballer
{
      // Konstruktor til ny oprettede Defenders, hvor der skal autogenereres et FootballerID
      public Defender (int footballerJersey, String footballerName, String footballerSalary, 
      boolean footballerEmployed)
      {
            super(footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      //kontsruktor til at oprette Defenders der indlæses fra fil
      public Defender (int id, int footballerJersey, String footballerName,String footballerSalary, 
      boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //implementeringen af superklassen's metode
      {
            return "DF";
      }
}