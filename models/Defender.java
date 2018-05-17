package models;
//Lasse: Har skrevet denne klasse.
public class Defender extends Footballer
{     
      //Constructor til en defender
      public Defender (int id, int footballerJersey, String footballerName, String footballerSalary, boolean footballerEmployed)
      {
            super(id, footballerJersey, footballerName, footballerSalary, footballerEmployed);
      }
      
      public String getFootballerPosition() //Implementering fra superclass.
      {
            return "DF";
      }
}