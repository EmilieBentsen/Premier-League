package menus;

import handlers.*;
import models.*;
public class AdminMenu
{
      AdminMatchMenu adminMatchMenu = new AdminMatchMenu();
      AdminOpponentMenu adminOpponentMenu = new AdminOpponentMenu();
      AdminFootballerMenu adminFootballerMenu = new AdminFootballerMenu();
      
      Output output = new Output();
      Input input = new Input();
      public void login()
      {
              boolean validUser = false;
                  
              while(validUser == false)
              {    
      
                  output.promptUsername();
                  String username = input.getString();
              if (username.equalsIgnoreCase("exit"))
              {
                   MainMenu main = new MainMenu();
                   main.startMenu();
                   
              }
                  output.promptPassword();
                  String password = input.getString();
              if (password.equalsIgnoreCase("exit"))
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
                    else
                    {
                        output.invalidUser();
                    }
                    }
                   
      }
      public void adminMenu()
      {
            output.adminMenuUI();
            int choice = input.getInt(1, 5);
            
            switch(choice)
            {
                  case 1:
                              adminMatchMenu.adminMatchMenu();
                              break;
                  case 2:
                              adminFootballerMenu.adminFootballerMenu();
                              break;
                  case 3:
                              adminOpponentMenu.adminOpponentMenu();
                              break;
                  case 4:
                              MainMenu mm = new MainMenu();
                              mm.startMenu();
                              break;
            
            }
            
          /* Printer menu header (You'll never walk alone" box + Menu navn/overskift).
            Printer menu oversigt(1. Match, 2. Footballer, 3. Opponent).
            Kør input metode der får int i mellem 1 g 3.
            Kald undermenu metoder baseret på input.*/  
      }
}