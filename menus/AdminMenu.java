package menus;

import handlers.*;
import models.*;
public class AdminMenu
{
      Output output = new Output();
      Input input = new Input();
      public void login()
      {
            /* Printer menu header (You'll never walk alone" box + Menu navn/overskift).
            Printer menu oversigt(1. Match, 2. Footballer, 3. Opponent).
            Kør input metode der får int i mellem 1 g 3.
            Kald undermenu metoder baseret på input.*/
              boolean validUser = false;
                  
              while(validUser == false)
              {    
            
              output.promptUsername();
              String username = input.getString();
              if (username.equals("exit"))
              {
                   MainMenu main = new MainMenu();
                   main.startMenu();
                   
              }
              output.promptPassword();
              String password = input.getString();
              if (password.equals("exit"))
              {
                   MainMenu main = new MainMenu();
                   main.startMenu();
                   
              }
              UserHandler uh = UserHandler.getUserHandler();
              validUser = uh.verifyAdmin(username, password);
              
              if(validUser == true)
              {
                  adminMenu();
              }
              
              }
      }
      public void adminMenu()
      {
            
      }
}