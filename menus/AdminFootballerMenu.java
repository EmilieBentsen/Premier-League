package menus;

import handlers.*;
import models.*;
import java.util.ArrayList;

public class AdminFootballerMenu
{
      Output output = new Output();
      Input input = new Input();
      FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();
      
      public void adminFootballerMenu()
      {
            output.adminFootballerMenu();
            int choice = input.getInt(1,3);
                        
            switch(choice)
            {
                  case 1 :    updateFootballerMenu();
                              break;
                  
                  case 2 :    createFootballerMenu("salary: ");
                              break;
                              
                  case 3 :    MainMenu mainMenu = new MainMenu();
                              mainMenu.startMenu();
                              break;
            }
      }
      
      public void updateFootballerMenu()
      {
            ArrayList<Footballer> footballers = footballerHandler.getFootballerArray();
            output.printActiveFootballers(footballers);
            output.inputJerseyNumber();        
            Footballer chosenFootballer = input.getFootballerByJersey(footballers);
            
            output.inputJerseyNumber(chosenFootballer); 
            chosenFootballer.setFootballerJersey(input.getInt());
            output.inputFootballerName(chosenFootballer);//informerer om navnet, og beder om at intaste det nye
            chosenFootballer.setFootballerName(input.getString());
            output.inputFootballerSalary(chosenFootballer);//informerer om lønen, og beder om at intaste den nye løn
            chosenFootballer.setFootballerSalary(input.getString());
            output.inputFootballerEmployed(chosenFootballer);//informerer om fodboldspilleren er ansat, og beder om at intaste den nye status
            
            int active = input.getInt(1,2);
                              if(active == 1)
                              {
                                    chosenFootballer.setFootballerEmployed(true);
                              }
                              else
                              {
                                    chosenFootballer.setFootballerEmployed(false);
                              }
            output.confirmationUpdateFootballer(chosenFootballer);            
            int endMenu = input.getInt(3,3);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();
      }
      
      public void createFootballerMenu(String salaryOrTeam)
      {
            output.setJerseyNumber();
            int jerseyNumber = input.getInt();
            output.inputFootballerName();
            String name = input.getString();
            output.inputFootballerSalary(salaryOrTeam);
            String salary = input.getString();
            output.inputFootballerEmployed();
            
            int isActive = input.getInt(1,2);
            boolean employed = true;
            if(isActive == 1)
            {
                  employed =true;
            }
            else
            {
                  employed = false;
            }
            
            output.inputFootballerPosition();
            String position = "";
            int choice = input.getInt(1,4);
            switch(choice)
            {
                  case 1 :    position = "GK";
                              break;
                  
                  case 2 :    position = "DF";
                              break;
                  
                  case 3 :    position = "MF";
                              break;
                  
                  case 4 :    position = "FW";
                              break;
            }
            
            footballerHandler.createObject(jerseyNumber, name, salary, employed, position);
            output.confirmationOnCreateFootballer(jerseyNumber, name, salary, employed, position);
            input.getInt(3,3);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();
      }
}