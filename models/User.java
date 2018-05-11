package models;

public class User implements Model
{
      private int userID;
      private String username;
      private String password;
      
      public User(int userID, String username, String password)
      {
            this.userID = userID;
            this.username = username;
            this.password = password;
      }
      
      public int getID()
      {
            return userID;
      }
      
      public String getUsername()
      {
            return username;
      }
      
      public String getPassword()
      {
            return password;
      }
}