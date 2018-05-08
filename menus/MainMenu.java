package menus;

import java.time.*;

public class MainMenu
{
      Output output = new Output();
      Input input = new Input();
      
      public static void main(String[] args)
      {
            MainMenu main = new MainMenu();
            main.startMenu();            
      }
      
      public void startMenu()
      {
            output.startMenu();
            int choice = input.getInt(1,3, "You have to input a Number ", "Valid numbers are in the range from ");
            
            switch(choice)
            {
                  case 1:     statisticsMenu();
                              
                  case 2:     //adminMenu();
                              
                  case 3:     //adminMatchMenu();
                                
            }
      }
      
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
                  
                  case 5:     startMenu();
                                          
            }
      }
      
      public void topThreeScorerMenu()
      {
            output.topThreeScorerMenu();
            String start = input.getDate();
            if(start.equals("5")) 
            {
                  startMenu();
            }
            LocalDate dateStart = LocalDate.parse(start);
            output.endDateOfPeriod();
            String end = input.getDate();
            if(end.equals("5")) 
            {
                  startMenu();
            }
            LocalDate dateEnd = LocalDate.parse(end);
            //listTopThreeGoalScorers(dateStart, dateEnd);
            //kør input metode til at få en periode, kald top3scorer() med input som parameter.
      }
      
      public void footballerStatisticsMenu()
      {
           /* Printer liste af fodboldspilerer, kører input metode om at få et JerseynNumber,
            og prnter spiller oplysinger for den valgte spiller (visningaf spiller information kommer til at 
            blive en "spændende" metode)
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/
                  
      }
      
      public void clubStatisticsMenu()
      {
            /*???(hvilken statistik skal man kunne få om klubben? skal det være for en given periode?
            Skal den altid vise den samme skærm?).*/
      }
      
      public void matchStatisticsMenu()
      {
            /*(evt. prompt bruger til at indtaste periode) Print liste over kampe brugeren kan vælge 
            mellem, kør input metode der beder om at få et match id for en af de viste matches.
            Kald metode der tager imod en Match/MatchID, og viser detaljerede information baseret 
            om pågældende match.
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/      
      } 
}