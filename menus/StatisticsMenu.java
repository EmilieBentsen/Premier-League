package menus;
import models.*;
import handlers.*;
import java.time.*;
import java.util.ArrayList;

public class StatisticsMenu
{
      FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();
      GoalHandler goalHandler = GoalHandler.getGoalHandler();
      MatchHandler matchHandler = MatchHandler.getMatchHandler();
 
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
            ArrayList<Footballer> activeFootballers = footballerHandler.getActiveFootballersArray();
            output.printActiveFootballers(activeFootballers);
            output.inputJerseyNumber();            
            Footballer chosenFootballer = input.getFootballerByJersey(activeFootballers);
            
            int goals = goalHandler.goalsByFootballer(chosenFootballer.getID());
            int assists = goalHandler.assistsByFootballer (chosenFootballer.getID());
            String jersey = "" + chosenFootballer.getFootballerJersey();
            int cleansheets = matchHandler.cleanSheetsByFootballer(jersey);
            int matchesPlayed = matchHandler.matchesPlayedByFootballer(jersey); 
            
            output.displayFootballerStatistics(chosenFootballer, goals, assists, cleansheets, matchesPlayed);
            
            
            
            /* og prnter spiller oplysinger for den valgte spiller (visningaf spiller information kommer til at 
            blive en "sp�ndende" metode)tr�jenr, navn, l�n, m�l, assist, cleansheets, 
            skal kalde startMenu() hvis den modtager et bestemt input for brugeren.*/
                  
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