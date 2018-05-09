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
            int choice = input.getInt(4,5);
            switch(choice)
            {
                  case 4 : statisticsMenu();
                  
                  case 5 : mainMenu.startMenu();
            }                
      }
      
      public void clubStatisticsMenu()
      {
            FourInt clubMatchStatistics = matchHandler.matchesPlayedWonDrawLostByClub();
            int matchesPlayed = clubMatchStatistics.getPlayed();
            int matchesWon = clubMatchStatistics.getWon();
            int matchesDraw = clubMatchStatistics.getDraw();
            int matchesLost = clubMatchStatistics.getLost();
            int goalsScored = goalHandler.getGoalsByClub();
            int goalsConceded = matchHandler.goalsConcededByClub();
            int cleenSheets = matchHandler.cleanSheetsByClub();
            
            output.clubStatisticsMenu(matchesPlayed, matchesWon, matchesDraw, matchesLost, goalsScored, goalsConceded, cleenSheets);
            
            int choice = input.getInt(4,5);
            switch(choice)
            {
                  case 4 : statisticsMenu();
                  
                  case 5 : mainMenu.startMenu();
            } 
      }
      
      public void matchStatisticsMenu()
      {
            output.matchStatisticsMenuStartDate();
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
            output.matchStatisticsMenuEndDate();
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
            
            matchHandler.getMatchesInPeriod(dateStart,dateEnd);
            
            
            /*kør input metode der beder om at få et match id for en af de viste matches.
            Kald metode der tager imod en Match/MatchID, og viser detaljerede information baseret 
            om pågældende match.
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/      
      }      
}