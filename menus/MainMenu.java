package menus;
import handlers.*;
import models.*;
import handlers.*;
import java.time.*;
import java.util.ArrayList;

public class MainMenu
{
<<<<<<< HEAD
      Output output = new Output();
      Input input = new Input();
      MatchHandler matchHandler = MatchHandler.getMatchHandler();
            
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

                  case 2:     //adminMenu();
                              break;
                              
                  case 3:     
                              ArrayList<Match> schedule = matchHandler.schedule();
                              output.printSchedule(schedule);
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
=======
      public void startMenu()
      {
            /*skal printe boks med "you'll never walk alone" efterfulgt af boks med "Start/Main menu",
            og dereftemenu oversigt, hvor der står "1. Statistik, 2. Log In, 3. Schedule". 
            skal evt. bruge "print.f" for at det kommer til at se lækkert ud. 
            Derefter skal der printes en prompt om at få et input af typen int i mellem 1
            og 3. input metode kaldes, og menuen kalder en undermenu baseret på brugerens input.*/
>>>>>>> 951871f4e3dd9c1ea65dae909780c577f4af8d83
      }
}