package menus;

import handlers.*;
import models.*;
import java.util.ArrayList;

public class AdminFootballerMenu //Vi bruger menuen til at navigere i Admin Footballer Menu i programmet
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
                  
                  case 2 :    createFootballerMenu("salary");
                              int endMenu = input.getInt(3,3);
                              output.endButton(3);
                              AdminMenu adminMenu = new AdminMenu();
                              adminMenu.adminMenu();
                              break;
                              
                  case 3 :    MainMenu mainMenu = new MainMenu();
                              mainMenu.startMenu();
                              break;
            }
      }
      
      public void updateFootballerMenu() //Menuen er til for at kunne opdatere oplysninger om en eksisterende footballer
      {
            FootballerHandler fh = FootballerHandler.getFootballerHandler();
            ArrayList<Footballer> footballers = fh.getFootballerArray();
            output.printActiveFootballers(footballers); //printer en liste af aktive footballers
            output.promptJerseyNumber(); 
            Footballer chosenFootballer = input.getFootballerByJersey(footballers);
            
            output.promptNewJerseyNumber(chosenFootballer); 
            chosenFootballer.setFootballerJersey(input.getInt());
            output.promptFootballerName(chosenFootballer);//informerer om navnet, og beder om at intaste det nye
            chosenFootballer.setFootballerName(input.getString());
            output.promptFootballerSalary(chosenFootballer);//informerer om lønen, og beder om at intaste den nye løn
            chosenFootballer.setFootballerSalary(input.getString());
            output.promptFootballerEmployed(chosenFootballer);//informerer om fodboldspilleren er ansat, og beder om at intaste den nye status
            
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
            output.promptFootballerName();
            String name = input.getString();
            output.promptFootballerSalary(salaryOrTeam);
            String salary = input.getString();
            boolean employed = true;
            
            if(salaryOrTeam.equals("salary"))
            {     
                  employed =true;
            }
            else
            {
                  employed = false;
            }
            
            output.promptFootballerPosition();
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
            
            FootballerHandler fh = FootballerHandler.getFootballerHandler();
            fh.createObject(jerseyNumber, name, salary, employed, position);
            output.confirmationOnCreateFootballer(jerseyNumber, name, salary, employed, position);
      }
}