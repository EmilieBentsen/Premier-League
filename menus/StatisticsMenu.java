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
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
 
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
                        
            LocalDate startDate = LocalDate.parse(getDate());
            output.endDateOfPeriod("Top Three Goal Scorers");
            LocalDate endDate = LocalDate.parse(getDate());
            int[][] doubleArray = goalHandler.getArrayWithGoalFrequencies(goalHandler.getGoalscorerByMatchID(matchHandler.getMatchIDInAPeriod(startDate, endDate)));
            int[][] topThreeGoalscorers = goalHandler.getTopGoalscorers(doubleArray, 3);
            output.printTopThreeGoalScorers(topThreeGoalscorers); 
            bakEndButtons();        
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
            // mit punkt
            int assists = goalHandler.assistsByFootballer (chosenFootballer.getID());
            String jersey = "" + chosenFootballer.getFootballerJersey();
            int cleansheets = matchHandler.cleanSheetsByFootballer(jersey);
            int matchesPlayed = matchHandler.matchesPlayedByFootballer(jersey); 
            
            output.displayFootballerStatistics(chosenFootballer, goals, assists, cleansheets, matchesPlayed);
            int choice = input.getInt(3,5);
            switch(choice)
            {
                  case 3 :    footballerMatchesPlayed(chosenFootballer);
                              break;
            
                  case 4 :    statisticsMenu();
                              break;
                  
                  case 5 :    mainMenu.startMenu();
                              break;
            }                
      }
      
      public void footballerMatchesPlayed(Footballer footballer)
      {
            output.footballerMatchesPlayed(footballer);
            LocalDate dateStart = LocalDate.parse(getDate());
            output.endDateOfPeriod("Matches played by footballer: ");
            LocalDate dateEnd = LocalDate.parse(getDate());
            ArrayList<Match> matches = matchHandler.getMatchesPlayedInPeriod(dateStart, dateEnd, footballer.getFootballerJersey()); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printMatchesPlayedInPeriod(matches, opponents);
            bakEndButtons();
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
            bakEndButtons();
      }
      
      public void matchStatisticsMenu()
      {
            output.matchStatisticsMenuStartDate();
                        
            LocalDate dateStart = LocalDate.parse(getDate());
            output.matchStatisticsMenuEndDate();
            LocalDate dateEnd = LocalDate.parse(getDate());
            
            ArrayList<Match> matches = matchHandler.matchesInPeriod(dateStart,dateEnd); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printMatchesPlayedInPeriod(matches, opponents);
            Match chosenMatch = input.getMatchByID(matches);
            ArrayList<Goal> goals = goalHandler.getGoalsByMatchID(chosenMatch.getID());
            output.chosenMatch(chosenMatch, goals);
            
            //vælg en kamp hvem har scoret hvornår. end menu = 0;    
      }  
      
      public void bakEndButtons()
      {
            int choice = input.getInt(4,5);
            switch(choice)
            {
                  case 4 :    statisticsMenu();
                              break;
                              
                  case 5 :    mainMenu.startMenu();
                              break;
            }
      }    
}