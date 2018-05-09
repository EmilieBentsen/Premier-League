package models;

public class Defender extends Footballer
{     
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