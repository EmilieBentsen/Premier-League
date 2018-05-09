package models;

public class Manager extends Footballer
{
      
      //kontsruktor til at oprette managers der indlæses fra fil
      public Manager (int id, int footballerJersey, String footballerName,String footballerSalary, 
      boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //implementeringen af superklassen's metode
      {
            return "MN";
      }
}