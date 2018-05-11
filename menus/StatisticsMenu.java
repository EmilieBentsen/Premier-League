package menus;    //vi har flere menu'er samt output og input, som alle er i denne package

import models.*;              //skal have adgang til modelernes get metoder
import handlers.*;            //Til brug af vores handlers
import java.time.*;           //til benyttelse af LocalDate
import java.util.ArrayList;   //Til når vi opretter ArrayList's

public class StatisticsMenu   
{
      //objekter af vores handlers, singleton løsning.
      FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();
      GoalHandler goalHandler = GoalHandler.getGoalHandler();
      MatchHandler matchHandler = MatchHandler.getMatchHandler();
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
      
      //output og input er ikke statiske hvorfor vin opretter objekter for at tilgå metoderne.
      Output output = new Output();
      Input input = new Input();
      
      MainMenu mainMenu = new MainMenu(); //For at kunne komme tilbage til startMenu() i MainMenu, hvis brugeren ønsker det.
      
      //Statistik hovedmenu
      public void statisticsMenu()
      {
            output.statisticMenu();       //Printer statistik hovedmenuen ud på consolen.
            int choice = input.getInt(1,5);//kalder getInt() i input der sanitere input således vi kun kan få tallende mellem 1 og 5
            
            switch(choice)
            {
                  case 1:     topThreeScorerMenu();   //til top tre mål scorer menuen
                              break;
                  
                  case 2:     footballerStatisticsMenu();   //til fodboldspiller statistik menuen
                              break;
                  
                  case 3:     clubStatisticsMenu();   //til club menuen
                              break;
                  
                  case 4:     matchStatisticsMenu();  //til kamp statistik menuen
                              break;
                  
                  case 5:     mainMenu.startMenu();   //Tilbage til startMenu
                              break;
            }
      }
      
      //top tre mål scorer menuen
      public void topThreeScorerMenu()   
      {
            output.topThreeScorerMenu();//printer menuen ud på consolen, som beder brugeren om at taste start datoen
                        
            LocalDate startDate = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate
            output.endDateOfPeriod("Top Three Goal Scorers");//output metoden endDateOfPeriod, beder brugeren om at taste slut datoen
            LocalDate endDate = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate
            //får et doobelt array med top tre målscorer og antal af deeres mål
            int[][] topThreeGoalscorers = goalHandler.getTopGoalscorersByDate(3, startDate, endDate);
            output.printTopThreeGoalScorers(topThreeGoalscorers); //printer de tre top scorere og antal mål.
            bakEndButtons();// metoden giver brugeren mulighed for at gå tilbage til Statistik hovedmenu, eller tilabge til star menuen
      }
      
      public String getDate()//beder brugeren om at indtaste en dato, og giver muligheden for at gå tilbage i til forrige menu eller start
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
      
      public void footballerStatisticsMenu()//til fodboldspiller statistik menuen
      {
            //laver en ArrayList med aktive fodboldspiller for klubben
            ArrayList<Footballer> activeFootballers = footballerHandler.getActiveFootballersArray();
            output.printActiveFootballers(activeFootballers);//Printer listen med aktive fodboldspillere
            output.inputJerseyNumber();//beder brugeren om vælge en fodboldspiller fra listen            
            //gemmer den valgte spiller i chosenFootballer til senere brug
            Footballer chosenFootballer = input.getFootballerByJersey(activeFootballers);
                        
            int goals = goalHandler.goalsByFootballer(chosenFootballer.getID());//henter den valgte fodboldspillers mål.
            int assists = goalHandler.assistsByFootballer (chosenFootballer.getID());//henter den valgte fodboldspillers assists
            String jersey = "" + chosenFootballer.getFootballerJersey();//laver fodboldspillerens int trøjenr. om til en String
            int cleansheets = matchHandler.cleanSheetsByFootballer(jersey);//henter fodboldspillerens noterede cleansheets
            int matchesPlayed = matchHandler.matchesPlayedByFootballer(jersey);//henter antal kampe fodboldspilleren har spillet 
            
            //printer fodboldspillerens stats ud til consolen
            output.displayFootballerStatistics(chosenFootballer, goals, assists, cleansheets, matchesPlayed);
            
            int choice = input.getInt(3,5);//sørger for at input fra brugeren er mellem 3 og 5
            switch(choice)
            {
                  case 3 :    footballerMatchesPlayed(chosenFootballer);//til menuen for de kampe den valgte fodboldspiller har spillet
                              break;
            
                  case 4 :    statisticsMenu();//tilbage fodboldspiller statistik menuen
                              break;
                  
                  case 5 :    mainMenu.startMenu();//Tilbage til startMenu
                              break;
            }                
      }
      
      public void footballerMatchesPlayed(Footballer footballer)
      {
            output.footballerMatchesPlayed(footballer);//beder brugeren om at indtaste start datoen for den periode kampende skal vises 
            LocalDate dateStart = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate
            output.endDateOfPeriod("Matches played by footballer: ");//beder brugeren om at indtaste slut datoen
            LocalDate dateEnd = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate
            //laver en ArrayList over kampe den valgte fodboldspiller har spillet i den valgte periode
<<<<<<< HEAD
            ArrayList<Match> matches = matchHandler.matchesPlayedByFootballer(dateStart, dateEnd, footballer.getFootballerJersey()); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printMatchesPlayedInPeriod(matches, opponents);
            output.bakEndButton(4,5);
            bakEndButtons();
=======
            ArrayList<Match> matches = matchHandler.getMatchesPlayedInPeriod(dateStart, dateEnd, footballer.getFootballerJersey()); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();//får en liste over modstandere.
            output.printMatchesPlayedInPeriod(matches, opponents);//Udskriver en liste over kampe der er spillet i den givne periode
            output.bakEndButton(4,5);//printer en tilbage og en slut knap ud
            bakEndButtons();//metoden giver brugeren mulighed for at gå tilbage til Statistik hovedmenu, eller tilabge til star menuen
>>>>>>> 3eb2af5be958c5dc11dd7520fe9a2ba1d5c80f56
      }
      
      //Club menuen, printer sæson stats ud for holdet
      public void clubStatisticsMenu()
      {
            //laver string (clubMatchStatistics), der gemmer spillede, vundne, uafgjorte og tabte kampe
            String clubMatchStatistics = matchHandler.matchesPlayedWonDrawLostByClub(); 
            String[] components = clubMatchStatistics.split(",");//Deler clubMatchStatistics op i et string array
            int matchesPlayed = Integer.parseInt(components[0]);//gemmer elementerne i array-et i int's
            int matchesWon = Integer.parseInt(components[1]);
            int matchesDraw = Integer.parseInt(components[2]);
            int matchesLost = Integer.parseInt(components[3]);
            
            int goalsScored = goalHandler.getGoalsByClub();//henter antal scorede mål for klubben
            int goalsConceded = matchHandler.goalsConcededByClub();//henter antal indkaserede mål fro klubben
            int cleenSheets = matchHandler.cleanSheetsByClub();//henter antal gange liverpool har spillet til nul
            
            //udskriver statistikerne på consolen
            output.clubStatisticsMenu(matchesPlayed, matchesWon, matchesDraw, matchesLost, goalsScored, goalsConceded, cleenSheets);
            bakEndButtons();//metoden giver brugeren mulighed for at gå tilbage til Statistik hovedmenu, eller tilabge til star menuen
      }
      
      //kamp statistik menuen
      public void matchStatisticsMenu()
      {
            output.matchStatisticsMenuStartDate();//Printer menuen ud på consolen, der bedere brugeren om at indtaste en start dato
                        
            LocalDate dateStart = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate 
            output.matchStatisticsMenuEndDate();//beder brugeren om at indtaste en slut dato
            LocalDate dateEnd = LocalDate.parse(getDate());//kalder getDate() og laver String(datoen) om til en LocalDate
            
<<<<<<< HEAD
            ArrayList<Match> matches = matchHandler.getMatchesInPeriod(dateStart,dateEnd); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printMatchesPlayedInPeriod(matches, opponents);
            Match chosenMatch = input.getMatchByID(matches);
            ArrayList<Goal> goals = goalHandler.getGoalsByMatchID(chosenMatch.getID());
            output.chosenMatch(chosenMatch, goals, footballerHandler.getFootballerArray());
            bakEndButtons();
=======
            //henter en liste af kampe spillet indenfor den givne periode
            ArrayList<Match> matches = matchHandler.matchesInPeriod(dateStart,dateEnd); 
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();//henter en liste over modstandere
            output.printMatchesPlayedInPeriod(matches, opponents);//printer en liste over kampe spillede i perioden.
            //output.promptMatchByID();//beder brugeren vælge en kamp
            Match chosenMatch = input.getMatchByID(matches);//gemmer den valgte kamp i chosenMatch
            ArrayList<Goal> goals = goalHandler.getGoalsByMatchID(chosenMatch.getID());//laver en liste med liverpool mål scoret i kampen
            output.chosenMatch(chosenMatch, goals, footballerHandler.getFootballerArray());//printer målene ud i consolen
            bakEndButtons();//metoden giver brugeren mulighed for at gå tilbage til Statistik hovedmenu, eller tilabge til star menuen
>>>>>>> 3eb2af5be958c5dc11dd7520fe9a2ba1d5c80f56
      }  
      
      public void bakEndButtons()//metoden beder brugeren om indput mellem 4 og 5 og vælger menu derefter
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