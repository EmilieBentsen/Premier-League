package menus;

import handlers.*;
import java.time.*;

public class StatisticsMenu
{
      FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();
 
      Output output = new Output();
      Input input = new Input();
      MainMenu mainMenu = new MainMenu();
      
      //Statisticmenu
      public void statisticsMenu()
      {
            output.statisticMenu();
            int choice = input.getInt(1,5, "You have to input a Number ", "Valid numbers are in the range from ");
            
            switch(choice)
            {
                  case 1:     topThreeScorerMenu();
                  
                  case 2:     footballerStatisticsMenu();
                  
                  case 3:     clubStatisticsMenu();
                  
                  case 4:     matchStatisticsMenu();
                  
                  case 5:     mainMenu.startMenu();
                                          
            }
      }
      
      public void topThreeScorerMenu()
      {
            output.topThreeScorerMenu();
            String start = input.getDate();
            if(start.equals("5")) 
            {
                  mainMenu.startMenu();
            }
            else if(start.equals("4"))
            {
                  statisticsMenu();
            }
            LocalDate dateStart = LocalDate.parse(start);
            output.endDateOfPeriod();
            String end = input.getDate();
            if(end.equals("5")) 
            {
                  mainMenu.startMenu();
            }
            else if(start.equals("4"))
            {
                  statisticsMenu();
            }
            LocalDate dateEnd = LocalDate.parse(end);
      }
      
      public void footballerStatisticsMenu()
      {
            output.printActiveFootballers(footballerHandler.getActiveFootballersArray());
            output.inputJerseyNumber();            
            input.getInt(1, 66, "You have to input a Number ","Valid numbers are in the range from ");
            
            
            /* og prnter spiller oplysinger for den valgte spiller (visningaf spiller information kommer til at 
            blive en "sp�ndende" metode)tr�jenr, navn, l�n, m�l, assist, cleansheets, 
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/
                  
      }
      
      public void clubStatisticsMenu()
      {
            /*???(hvilken statistik skal man kunne f� om klubben? skal det v�re for en given periode?
            Skal den altid vise den samme sk�rm?).*/
      }
      
      public void matchStatisticsMenu()
      {
            /*(evt. prompt bruger til at indtaste periode) Print liste over kampe brugeren kan v�lge 
            mellem, k�r input metode der beder om at f� et match id for en af de viste matches.
            Kald metode der tager imod en Match/MatchID, og viser detaljerede information baseret 
            om p�g�ldende match.
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/      
      }      
}