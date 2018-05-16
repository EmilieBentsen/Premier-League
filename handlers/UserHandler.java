package handlers;

import models.*;
import java.util.*;

public class UserHandler extends ObjectHandler<User> 
{
      private static UserHandler instance;
      private ArrayList<User> users;
      
      private UserHandler()/*Metoden er til fordi vi gerne vil være sikker på at der kun er en instans af klassen. 
      Derfor har vi overskrevet default konstruktoren med en private konstruktor, som vi kalder i metoden getUerHandler, 
      i det tilfælde der ikke allerede findes en instans. Dette er en Singleton løsning. users ArrayList fyldes op med 
      obejkter lavet fra filen users.csv*/
      {
            users = getContent();
      }
      
      public static UserHandler getUserHandler()//metode der returnerer en instans af FootballerHandler
      {
            if(instance == null)//tjekker om der er lavet en instans af klassen
            {
                  UserHandler uh = new UserHandler();
                  instance = uh;
            }
            return instance;
      }
      
      public String getFilePath() //filen vi gemmer brugere i
      {
            return "user.csv";
      }
      
      public PersistentObjectHandler<User> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return new PersistentObjectHandler<User>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(User user)//PersistentObjectHandler kræver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return user.getID() + "," + user.getUsername() + "," + user.getPassword();
                       
                  }
      
                  public User objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]);//laver strings i arraylisten om til int
                        
                        
                        return new User(id, components[1], components[2]); //obretter er nyt object af User                    
                  }
            };
      }
      
      public boolean verifyAdmin(String username, String password) //metode til at verificere om en bruger findes
      {
            for(User i : users)
            {
                  if(i.getUsername().equals(username) && i.getPassword().equals(password))
                  {
                        return true;
                        
                  }
               
            }
            return false;
      }
}