package models;


public class Forward extends Footballer
{
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