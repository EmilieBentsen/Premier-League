package models;
//Lasse: Har skrevet klasse.
public class Midfielder extends Footballer
{    
      //Constructor
      public Midfielder (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //Implementering
      {
            return "MF";
      }
}