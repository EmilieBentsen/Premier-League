package handlers;

import models.*;
import java.util.*;

public class UserHandler extends ObjectHandler<User> 
{
      private static UserHandler instance;
      private ArrayList<User> users;
      
      private UserHandler()
      {
            users = getContent();
      }
      
      public static UserHandler getUserHandler()
      {
            if(instance == null)
            {
                  UserHandler uh = new UserHandler();
                  instance = uh;
            }
            return instance;
      }
      
      public String getFilePath()
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
      
      public boolean verifyAdmin(String username, String password)
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