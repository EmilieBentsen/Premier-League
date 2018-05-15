package menus;    //vi har flere menu'er samt output og input, som alle er i denne package

import handlers.*;      //skal have adgang til vores Handlers
import models.*;        //Skal have adgang til vores modeller
import java.util.ArrayList;   //til oprettelse af ArrayList's

public class MainMenu
{
      Output output = new Output();//output og input er ikke statiske hvorfor vin opretter objekter for at tilgå metoderne.
      Input input = new Input();
      
      MatchHandler matchHandler = MatchHandler.getMatchHandler();//objekter af vores handlers, singleton løsning.
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
            
      public static void main(String[] args)//Skal slettes, kun til test
      {
            MainMenu main = new MainMenu();
            main.startMenu();            
      }
      
      public void startMenu()//Start skærmen, hvor brugeren vælger menu
      {
            output.startMenu();//printer systemets start skærm
            int choice = input.getInt(1,3);//venter på input fra brugeren mellem 1 og 3 
            
            switch(choice)
            {
                  case 1:     StatisticsMenu sm = new StatisticsMenu();  
                              sm.statisticsMenu();//kalder statistik menuen i StatisticsMenu klassen
                              break;

                  case 2:     AdminMenu am = new AdminMenu();
                              am.login();//klader adminstrations menuen i AdminMenu klassen
                              break;
                              
                  case 3:     
                              ArrayList<Match> schedule = matchHandler.schedule();//laver en liste med det resterende kamprogram
                              ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();//liste over modstandere
                              output.printSchedule(schedule, opponents);//udskriver kamprogrammet
                              output.endButton(4);//printer en slut knap
                              int choiceSchedule = input.getInt(4,4);//tager kun 4 som gyldigt input
                                    
                              switch(choiceSchedule)
                              {
                              case 4: 
                              startMenu();// kaldder start menuen igen.
                              break;
                              }                             
                              break;  
            }
      }
}