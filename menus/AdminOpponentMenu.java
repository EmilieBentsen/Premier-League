package menus;
//Lasse: Skrev pseudokode.
import handlers.*;
import models.*;
import java.util.ArrayList;

public class AdminOpponentMenu
{
      Output output = new Output();
      Input input = new Input();      
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
      
      public void adminOpponentMenu() //menu til at administrerer modstandere
      {
            output.adminOpponentMenu(); 
            int choice = input.getInt(1,3);
            switch(choice)
            {
                  case 1 :    updateOpponentMenu(); //opdater modstander menu
                              break;
                              
                  case 2 :    createNewOpponentMenu(); //opret modstander menu
                              break; 
                              
                  case 3 :    MainMenu mainMenu = new MainMenu(); //Tilbage til main menu
                              mainMenu.startMenu();
                              break;             
            }
      }
      
      public void updateOpponentMenu() //menu til at opdatere en modstander
      {
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray(); //f�r et liste af modstandere
            output.printOpponentList(opponents); //printer liste
            output.promptOpponent(); //beder om ID p� modstander der �nskes opdateret          
            Opponent chosenOpponent = input.getOpponentByList(opponents);
            
            output.printOpponentName(chosenOpponent); //Printer navnet p� modstanderen med ID'et
            output.promptOpponentName(); //beder om det nye navn p� modstanderen
            String newOpponentName = input.getString();
            chosenOpponent.setOpponentName(newOpponentName); //s�tter detn nye navn p� modstanderen
                       
            output.promptOpponentActice(); //Sp�rger om modstanderen er aktiv
            int active = input.getInt(1,2);
            
            if(active == 1)
            {
                  chosenOpponent.setOpponentActive(true); //s�tter opponent til aktiv
            }
            else
            {
                  chosenOpponent.setOpponentActive(false); //s�tter opponent til inaktiv
            }

            output.confirmationOnUpdateOpponent(chosenOpponent); //bekr�ftelse p� at modstanderen er blevet opdateret
            int endMenu = input.getInt(3,3);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();
      }
      
      public void createNewOpponentMenu() //menu til at oprette en ny modstander
      {
            output.promptOpponentNameCreateNewOpponent(); //beder om modstanderens navn
            String opponentName = input.getString();
            output.promptOpponentActice(); //Sp�rger om klubben er aktiv
            int isActive = input.getInt(1,2);
            boolean active = true;
            
            if(isActive == 1)
            {
                  active =true;
            }
            else
            {
                  active = false;
            }
            opponentHandler.createObject(opponentName, active); //opretter ny opponent 
            output.confirmationOnCreateOpponent(opponentName, active); //bekr�ftelse p� at modstander er oprettet
            input.getInt(3,3);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();           
      }
}