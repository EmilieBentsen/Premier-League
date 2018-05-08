package models;

public class Midfielder extends Footballer
{    
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