package menus;

import handlers.*;
import java.util.*;
import models.*;
import java.time.*;

public class AdminMatchMenu
{
      
      Output output = new Output();
      Input input = new Input();
      OpponentHandler oh = OpponentHandler.getOpponentHandler();
      MatchHandler mh = MatchHandler.getMatchHandler();
      GoalHandler gh = GoalHandler.getGoalHandler();
      FootballerHandler fh = FootballerHandler.getFootballerHandler();
     
     
      public void adminMatchMenu()
      {
           output.adminMatchMenuUI();
           int choice = input.getInt(1,5);
           
           switch(choice)
           {
                  case 1: 
                              createFutureMatch(); //Metode til at oprette en fremtidig Liverpool kamp
                              break;
                  case 2: 
                              updateMatch(); //Metode til at opdatere en fremtidig Liverpool kamp
                              break;
                  case 3:
                              typeInResult(); //Metode til at indtaste resultatet p� en spillet kamp
                              break;
                  case 4:
                              AdminMenu am = new AdminMenu(); 
                              am.adminMenu();
                              break;
                  case 5:
                              MainMenu mm = new MainMenu();
                              mm.startMenu();
                              break;
           } 
      }
      
      public void createFutureMatch() //til at oprette en kamp
      {
            
            output.promptDate(); //beder om dato p� den fremtidige kamp
            String date = input.getDate();
            LocalDate matchDate = LocalDate.parse(date);
            if(matchDate.isBefore(LocalDate.now())) //Tjekker om datoen ligger efter dags dato
            {
                  System.out.println("Date has to be after today.");
                  createFutureMatch();
            }
            switch(date)
            {
                  case "5":
                              MainMenu mainMenu = new MainMenu();
                              mainMenu.startMenu();
                              
                              
                  case "4":
                              AdminMatchMenu adminMatchMenu = new AdminMatchMenu();
                              adminMatchMenu();
            }
            
            ArrayList<Opponent> opponents = oh.getActiveOpponentsArray(); //henter aktive modstander array
            output.printOpponentList(opponents); //printer liste af aktive modstandere
            output.promptOpponent(); //beder om modstander fra liste
            int opponent = input.getOpponentIDByList(opponents);
            output.promptHomeAway(); //sp�rg om det er en ude eller hjemmekamp
            char homeAway = input.getHomeAway();
            
            mh.createObject(matchDate, opponent,Character.toUpperCase(homeAway), 0, 0, "0-0-0", "00-00-00-00-00-00-00-00-00-00-00");
            output.matchCreationConfirmation(); //Bekr�ftelse p� at kampen er oprettet
            
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();

      }
      
      public void updateMatch()
      {
            /*
            Prompter for indtastning af to datoer i date format.
            Printer liste af kampe spillet inden for de indtastede datoer.
            Prompter bruger til at v�lge en af disse kampe.
            prompter om man vil �ndre dato (Ja/nej), hvis input = Ja: prompt for ny dato.
            prompter om man vil �ndre modstander(Ja/Nej), hvis input = Ja: print liste over gyldige modstandere
            og prompt for valg af modstander.
            prompter om man vil �ndre ude/hjemme status(Ja/Nej), hvis input = Ja: �ndre home til away eller 
            omvendt
            prompter om man vil �ndre resultatet af kampen (Ja/Nej),hvis input = Ja: prompter for indtastning
            af nyt resultat. H
            Hvis nyt resulat har f�rre Liverpool m�l end det originale: generer liste over m�l
            scoret af liverpool i kampen, prompter for hvilken af dem der skal slettes, gentages indtil at 
            m�ngden af m�l stemmer overens med det nye resultat. 
            Hvis nyt resultat har flere liverpool m�l end originalt: skal der kaldes metode til at oprette m�l,
            gentages indtil at m�ngden af m�l stemmer overns med resultatet. 
            prompter om der skal �ndres i formation (Ja/Nej), Hvis input = Ja: prompt for ny formation.
            prompter for om der skal �ndres i lineup(Ja/Nej), Hvis input er = Ja: prompt for nyt line up.
            den valgte match �ndres baseret p� brugerens indtasninger og gemmes.
            adminMenu();
            */     
      }
      
      public void typeInResult()
      {           
            ArrayList<Match> matches = mh.getMatchesWithoutResult(); //henter liste af kampe der er spillede, men uden resultat
            output.printNonRegisteredMatches(matches); //printer listen
            output.promptMatchByID(); //Beder om match ID til kampen der �nskes at indtaste resultat for
            Match match = input.getMatchIDByList(matches);
            output.promptMatchResult(); //Beder om kampens resultat
            int liverpoolGoals = input.getResult(match.getMatchHomeOrAway(), match);
            ArrayList<Footballer> footballers = fh.getActiveFootballersArray(); //henter liste af aktive spillere
    
                  for(int i = 0; i < liverpoolGoals; i++) //for loppet k�rer for s� mange m�l der er scoret af LP og der registreres hvem der m�lscore
                  {
                        int assistedID = 0;
                        output.printGoals(liverpoolGoals-i); 
                        output.promtGoalType(); //sp�rger om m�ltypen
                        char goalType = input.getGoalType();
                        if(goalType == 'o' || goalType == 'O') //hvis m�let er et selvm�l, hentes modstander liste og der v�lges et ID p� spilleren
                        {
                              ArrayList<Footballer> op = fh.getOpponentFootballersArray();
                              output.printOpponentFootballers(op); //printer liste med modstandere
                              output.promptIsOpponentOnList(); //beder om modstander fra liste
                              int ID = input.getOpponentID();
                              output.promptGoalMinuteScored(); //beder om tiden p� m�let i min fra kampstart
                              int time = input.getGoalMinuteScored();
                              
                              
                              Goal goal = new Goal(gh.getNewGoalID(), match.getID(), ID, time, goalType, 00);
                        }
                        else
                        {
                              output.printActiveFootballers(footballers);
                              output.promptGoalscorer(); //Beder om m�lscoren                  
                              int ID = input.getGoalscorer(footballers);
                              output.promptGoalMinuteScored(); //beder om tiden p� m�let i min fra kampstart
                              int time = input.getGoalMinuteScored();
                  
                              if(goalType == 'R' || goalType == 'r') //hvis m�let er et regular m�l, sp�rger det var assisted
                              {
                                    
                                    output.promtWasGoalAssisted(); //Sp�rger om m�let var assisted
                                    assistedID = input.getAssistedFootballer(footballers);
                        
                              }
                              else if(goalType != 'R' || goalType != 'r') //Hvis m�let ikke er reguler, s�ttes assist til 00
                              {
                                    assistedID = 00;
                              }
                  
                              
                              Goal goal = new Goal(gh.getNewGoalID(), match.getID(), ID, time, goalType, assistedID);
     
                        }
            
                  }
                  output.promptMatchFormation(); //Beder om kamp formationen
                  String formation = input.promptMatchFormation();
                  output.promptMatchLineup(); //beder om kampens lineup
                  String lineup = input.getMatchLineup();
                  mh.updateObject(match.getID(), match.getMatchDate(), match.getMatchOpponentID(), match.getMatchHomeOrAway(), match.getMatchHomeGoals(), match.getMatchAwayGoals(), formation, lineup);
                  output.typeInResultConfirmation(); //bekr�ftelse af opdateringen af kampens resultater
                  
                  AdminMenu am = new AdminMenu();
                  am.adminMenu();
            }
      
}