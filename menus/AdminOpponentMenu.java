package menus;

import handlers.*;
import models.*;
import java.util.ArrayList;

public class AdminOpponentMenu
{
      Output output = new Output();
      Input input = new Input();
      AdminMenu adminMenu = new AdminMenu();
      
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
            adminMenu.adminMenu();
            /* 
            skal Printe liste af alle modstandere.
            skal prompte bruger til at v�lge en modstander fra listen.
            Prompter bruger om man vil �ndre Opponent Name(Ja/Nej)Hvis input = Ja: Prompt for nyt navn.
            Prompter bruger for om man vil �ndre "Active Status"(Ja/nej) Hvis input = Ja, �ndre v�rdi af valgt
            opponents boolean, evt. kunne den nye status blive printet s� brugeren kan se at der sker noget.
            */
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
            output.confirmationOnUpdateOpponent(opponentName, active);//ikke lavet
            input.getInt(5,5);
            adminMenu.adminMenu();           
      }
}