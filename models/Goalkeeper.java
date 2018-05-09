package models;

public class Goalkeeper extends Footballer 
{
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