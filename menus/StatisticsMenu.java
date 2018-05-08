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
      
      public void statisticsMenu()
      {
            output.statisticMenu();
            int choice = input.getInt(1,5);
            
            switch(choice)
            {
                  case 1:     topThreeScorerMenu();
                              break;
                  
                  case 2:     footballerStatisticsMenu();
                              break;
                  
                  case 3:     clubStatisticsMenu();
                              break;
                  
                  case 4:     matchStatisticsMenu();
                              break;
                  
                  case 5:     mainMenu.startMenu();
                              break;
            }
      }
      
      public void topThreeScorerMenu()
      {
            output.topThreeScorerMenu();
            String start = input.getDate();
            
            LocalDate dateStart = LocalDate.parse(getDate());
            output.endDateOfPeriod();
            LocalDate dateEnd = LocalDate.parse(getDate());
      }
      
      public String getDate()
      {
            String date = input.getDate();
            
            if(date.equals("5")) 
            {
                  mainMenu.startMenu();
            }
            else if(date.equals("4"))
            {
                  statisticsMenu();
            }
            return date;
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
            int choice = input.getInt(4,5);
            switch(choice)
            {
                  case 3 :    footballerMatchesPlayed();
                              break;
            
                  case 4 :    statisticsMenu();
                              break;
                  
                  case 5 :    mainMenu.startMenu();
                              break;
            }                
      }
      
      public void footballerMatchesPlayed()
      {
            output.
      }
      
      public void clubStatisticsMenu()
      {
            String clubMatchStatistics = matchHandler.matchesPlayedWonDrawLostByClub();
            String[] components = clubMatchStatistics.split(",");
            int matchesPlayed = Integer.parseInt(components[0]);
            int matchesWon = Integer.parseInt(components[1]);
            int matchesDraw = Integer.parseInt(components[2]);
            int matchesLost = Integer.parseInt(components[3]);
            
            int goalsScored = goalHandler.getGoalsByClub();
            int goalsConceded = matchHandler.goalsConcededByClub();
            int cleenSheets = matchHandler.cleanSheetsByClub();
            
            output.clubStatisticsMenu(matchesPlayed, matchesWon, matchesDraw, matchesLost, goalsScored, goalsConceded, cleenSheets);
            
            int choice = input.getInt(4,5);
            switch(choice)
            {
                  case 4 :    statisticsMenu();
                              break;
                              
                  case 5 :    mainMenu.startMenu();
                              break;
            }
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