package menus;
import handlers.*;
import models.*;
import handlers.*;
import java.time.*;
import java.util.ArrayList;

public class MainMenu
{
      Output output = new Output();
      Input input = new Input();
      MatchHandler matchHandler = MatchHandler.getMatchHandler();
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
            
      public static void main(String[] args)
      {
            MainMenu main = new MainMenu();
            main.startMenu();            
      }
      
      public void startMenu()
      {
            output.startMenu();
            int choice = input.getInt(1,3);
            
            switch(choice)
            {
                  case 1:     StatisticsMenu sm = new StatisticsMenu();
                              sm.statisticsMenu();
                              break;

                  case 2:     AdminMenu am = new AdminMenu();
                              am.login();
                              break;
                              
                  case 3:     
                              ArrayList<Match> schedule = matchHandler.schedule();
                              ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
                              output.printSchedule(schedule, opponents);
                              output.endButton(4);
                              int choiceSchedule = input.getInt(4,4);
                                    
                                    switch(choiceSchedule)
                                    {
                                    case 4: 
                                                startMenu();
                                                break;
                                    }                             
                              break;  
            }
      }
}