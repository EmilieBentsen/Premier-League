package menus;
// Lasse: Skrev pseudokode.
import handlers.*;
import models.*;
public class AdminMenu
{
      AdminMatchMenu adminMatchMenu = new AdminMatchMenu();
      AdminOpponentMenu adminOpponentMenu = new AdminOpponentMenu();
      AdminFootballerMenu adminFootballerMenu = new AdminFootballerMenu();
      Output output = new Output();
      Input input = new Input();
      UserHandler uh = UserHandler.getUserHandler();
      
      //Emilie Bentsen, Lasse Gustafson
      public void login() //Login metode der beder admin indtaste brugernavn og password og validerer om det er gyldigt login
      {
              boolean validUser = false;
                  
              while(validUser == false)
              {    
            
                    output.promptUsername(); //beder om brugernavn
                    String username = input.getString();
                    if (username.equalsIgnoreCase("exit"))
                    {
                         MainMenu main = new MainMenu(); //hvis admin vil tilbage til main menu indtastes exit
                         main.startMenu();
                         
                    }
                        output.promptPassword(); //beder om password
                        String password = input.getString();
                    if (password.equalsIgnoreCase("exit")) //hvis admin vil tilbage til main menu indtastes exit
                    {
                         MainMenu main = new MainMenu();
                         main.startMenu();
                         
                    }
                    validUser = uh.verifyAdmin(username, password); //tjekker om admin login oplysninger kan valideres 
                          
                    if(validUser == true)
                    {
                        
                          adminMenu();
                    }
                    else
                    {
                          output.invalidUser(); //Giver besked om at brugernavn eller password ikke findes
                    }
            }
      }
      
      //Emilie Bentsen
      public void adminMenu() //menu for admin brugere
      {
            output.adminMenuUI();
            int choice = input.getInt(1, 5);
            
            switch(choice)
            {
                  case 1:
                              adminMatchMenu.adminMatchMenu(); //Admin match menu
                              break;
                  case 2:
                              adminFootballerMenu.adminFootballerMenu(); //Admin footballer menu
                              break;
                  case 3:
                              adminOpponentMenu.adminOpponentMenu(); //admin modstander menu
                              break;
                  case 4:
                              MainMenu mm = new MainMenu(); //tilbage til main mennu
                              mm.startMenu();
                              break;
            }
      }
}