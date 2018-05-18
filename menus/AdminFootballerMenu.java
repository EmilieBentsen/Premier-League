package menus;

import handlers.*;
import models.*;
import java.util.ArrayList;

//Erik Pilverdier
public class AdminFootballerMenu //Vi bruger menuen til at navigere i Admin Footballer Menu i programmet
{
      Output output = new Output();
      Input input = new Input();
      FootballerHandler fh = FootballerHandler.getFootballerHandler();
      
      public void adminFootballerMenu() 
      {
            output.adminFootballerMenu();
            int choice = input.getInt(1,4); 
                        
            switch(choice)
            {
                  case 1 :    updateFootballerMenu(); //Menuen til at opdatere en footballer
                              break;
                  
                  case 2 :    createFootballerMenu("salary"); //Menuen til at skabe en footballer
                              int endMenu = input.getInt(3,3);
                              output.endButton(3);
                              AdminMenu adminMenu = new AdminMenu();
                              adminMenu.adminMenu();
                              break;
                              
                  case 3:
                              AdminMenu am = new AdminMenu(); 
                              am.adminMenu();
                              break;
                  case 4:
                              MainMenu mm = new MainMenu();
                              mm.startMenu();
                              break;
            }
      }
      
      public void updateFootballerMenu() //Menuen er til for at kunne opdatere oplysninger om en eksisterende footballer
      {            
            ArrayList<Footballer> footballers = fh.getFootballerArray();
            output.printActiveFootballers(footballers); //printer en liste af aktive footballers
            output.promptJerseyNumber(); //beder om Jersey nr. p� den spiller der �nskes opdateret
            Footballer chosenFootballer = input.getFootballerByJersey(footballers); 
            
            output.promptNewJerseyNumber(chosenFootballer); //informerer om jersey nr., og beder om at indtaste det nye
            chosenFootballer.setFootballerJersey(input.getInt());
            output.promptFootballerName(chosenFootballer);//informerer om navnet, og beder om at intaste det nye
            chosenFootballer.setFootballerName(input.getString());
            output.promptFootballerSalary(chosenFootballer);//informerer om l�nen, og beder om at intaste den nye l�n
            chosenFootballer.setFootballerSalary(input.getString());
            output.promptFootballerEmployed(chosenFootballer);//informerer om fodboldspilleren er ansat, og beder om at intaste den nye status
            
            int active = input.getInt(1,2);
                              if(active == 1)
                              {
                                    chosenFootballer.setFootballerEmployed(true); //s�tter den nye status til aktiv
                              }
                              else
                              {
                                    chosenFootballer.setFootballerEmployed(false);//s�tter den nye status til aktiv 
                              }
            output.confirmationUpdateFootballer(chosenFootballer); //giver en bekr�ftelse af opdateringen af footballer s� brugeren ved den er opdateret            
            int endMenu = input.getInt(3,3);
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();
      }
      
      
      //Adam Birch, Erik Pilverdier
      public void createFootballerMenu(String salaryOrTeam) //menu til at oprette en footballer
      {
            output.promptForJerseyNumber(); //Beder om et Jersey number
            int jerseyNumber = input.getInt(); 
            output.promptFootballerName(); //Beder om footballer name
            String name = input.getString();
            output.promptFootballerSalary(salaryOrTeam); //Beder om en footballers l�n eller hold
            String salary = input.getString();
            boolean employed = true;
            
            if(salaryOrTeam.equals("salary")) //Hvis salaryOrTeam er lige med "Salary" s�ttes employed til true ellers til false.
            {     
                  employed =true;
            }
            else
            {
                  employed = false;
            }
            
            output.promptFootballerPosition(); //beder om footballerens position 
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
                        
            fh.createObject(jerseyNumber, name, salary, employed, position); //Opretter den nye footballer og gemmer den i footballers
            output.confirmationOnCreateFootballer(jerseyNumber, name, salary, employed, position); //Brugeren f�r en bekr�ftelse p� at der er oprettet en ny spiller
      }
}