package models;
//Lasse: Har skrevet denne klasse.
public class Manager extends Footballer
{
      
      //Constructor
      public Manager (int id, int footballerJersey, String footballerName,String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //Implementering
      {
            return "MN";
      }
}