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
            }
      }
      
      public void updateOpponentMenu()
      {
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printOpponentList(opponents);
            output.promptOpponent();           
            Opponent chosenOpponent = input.getOpponentByList(opponents);
            output.changeOpponentName();
            int choice = input.getInt(1,2);
            
            switch(choice)
            {
                  case 1 :    output.promptOpponentName();
                              String newOpponentName = input.getString();
                              chosenOpponent.setOpponentName(newOpponentName);
                              break;
                              
                  case 2 :    break;                                          
            }
            
            output.changeOpponentActive();
            int activeChoice = input.getInt(1,2);
            
            switch(activeChoice)
            {
                  case 1 :    output.promptOpponentActice();
                              int active = input.getInt(1,2);
                              if(active == 1)
                              {
                                    chosenOpponent.setOpponentActive(true);
                              }
                              else
                              {
                                    chosenOpponent.setOpponentActive(false);
                              }
                              break;
                              
                  case 2 :    break;
            }
            
            output.confirmationOnUpdateOpponent(chosenOpponent);
            int endMenu = input.getInt(5,5);
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
            input.getInt(5,5);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();           
      }
}