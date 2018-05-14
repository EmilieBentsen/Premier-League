package menus;

import handlers.*;
import models.*;
import java.util.ArrayList;

public class AdminOpponentMenu
{
      Output output = new Output();
      Input input = new Input();
      
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
      
      public void adminOpponentMenu()
      {
            output.adminOpponentMenu();
            int choice = input.getInt(1,2);
            switch(choice)
            {
                  case 1 :    updateOpponentMenu();
                              break;
                              
                  case 2 :    createNewOpponentMenu();
                              break; 
                              
                  case 3 :    MainMenu mainMenu = new MainMenu();
                              mainMenu.startMenu();
                              break;             
            }
      }
      
      public void updateOpponentMenu()
      {
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printOpponentList(opponents);
            output.promptOpponent();           
            Opponent chosenOpponent = input.getOpponentByList(opponents);
            
            output.printOpponentName(chosenOpponent);
            output.promptOpponentName();
            String newOpponentName = input.getString();
            chosenOpponent.setOpponentName(newOpponentName);
                       
            output.promptOpponentActice();
            int active = input.getInt(1,2);
            
            if(active == 1)
            {
                  chosenOpponent.setOpponentActive(true);
            }
            else
            {
                  chosenOpponent.setOpponentActive(false);
            }

            output.confirmationOnUpdateOpponent(chosenOpponent);
<<<<<<< HEAD
            int endMenu = input.getInt(5,5);
=======
            int endMenu = input.getInt(3,3);
>>>>>>> 13b1d8f3ca988e98701b8fecf9f51ffead01bcec
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();
      }
      
      public void createNewOpponentMenu()
      {
            output.inputOpponentName();
            String opponentName = input.getString();
            output.promptOpponentActice();
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
            opponentHandler.createObject(opponentName, active);
            output.confirmationOnCreateOpponent(opponentName, active);
<<<<<<< HEAD
            input.getInt(5,5);
=======
            input.getInt(3,3);
>>>>>>> 13b1d8f3ca988e98701b8fecf9f51ffead01bcec
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();           
      }
}