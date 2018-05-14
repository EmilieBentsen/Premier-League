package menus;

import handlers.*;
import java.util.*;
import models.*;
import java.time.*;

public class AdminMatchMenu
{
      
      Output output = new Output();
      Input input = new Input();
     
      public void adminMatchMenu()
      {
           output.adminMatchMenuUI();
           int choice = input.getInt(1,5);
           
           switch(choice)
           {
                  case 1: 
                              createFutureMatch();
                              break;
                  case 2: 
                              updateMatch();
                              break;
                  case 3:
                              typeInResult();
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
      
      public void createFutureMatch()
      {
            
            output.promptDate();
            String date = input.getDate();
            LocalDate matchDate = LocalDate.parse(date);
            
            switch(date)
            {
                  case "5":
                              MainMenu mainMenu = new MainMenu();
                              mainMenu.startMenu();
                              
                              
                  case "4":
                              AdminMatchMenu adminMatchMenu = new AdminMatchMenu();
                              adminMatchMenu();
            }
            OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
            ArrayList<Opponent> opponents = opponentHandler.getActiveOpponentsArray();
            output.printOpponentList(opponents); 
            output.promptOpponent();
            int opponent = input.getOpponentIDByList(opponents);
            output.promptHomeAway();
            char homeAway = input.getHomeAway();
            
            MatchHandler matchHandler = MatchHandler.getMatchHandler();
            matchHandler.createObject(matchDate, opponent,Character.toUpperCase(homeAway), 0, 0, "0-0-0-0", "00-00-00-00-00-00-00-00-00-00-00");
            output.matchCreationConfirmation();
            
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.adminMenu();

      }
      
      public void updateMatch()
      {
            /*
            Prompter for indtastning af to datoer i date format.
            Printer liste af kampe spillet inden for de indtastede datoer.
            Prompter bruger til at vælge en af disse kampe.
            prompter om man vil ændre dato (Ja/nej), hvis input = Ja: prompt for ny dato.
            prompter om man vil ændre modstander(Ja/Nej), hvis input = Ja: print liste over gyldige modstandere
            og prompt for valg af modstander.
            prompter om man vil ændre ude/hjemme status(Ja/Nej), hvis input = Ja: ændre home til away eller 
            omvendt
            prompter om man vil ændre resultatet af kampen (Ja/Nej),hvis input = Ja: prompter for indtastning
            af nyt resultat. H
            Hvis nyt resulat har færre Liverpool mål end det originale: generer liste over mål
            scoret af liverpool i kampen, prompter for hvilken af dem der skal slettes, gentages indtil at 
            mængden af mål stemmer overens med det nye resultat. 
            Hvis nyt resultat har flere liverpool mål end originalt: skal der kaldes metode til at oprette mål,
            gentages indtil at mængden af mål stemmer overns med resultatet. 
            prompter om der skal ændres i formation (Ja/Nej), Hvis input = Ja: prompt for ny formation.
            prompter for om der skal ændres i lineup(Ja/Nej), Hvis input er = Ja: prompt for nyt line up.
            den valgte match ændres baseret på brugerens indtasninger og gemmes.
            adminMenu();
            */     
      }
      
      public void typeInResult()
      {
            /* gennerer liste over endnu ikke spillede kampe, og prompter bruger til at vælge en.
            prompter bruger for at indtaste kampens resultat, Hvis liverpool har scoret mål kaldes 
            userCreateGoal()for hvert mål socret af liverpool.
            prompter for indtastning af formation.
            prompter for indtastning af lineup.
            kampen opdateres med de indtastede informationer.
            adminMenu();*/
            
            MatchHandler mh = MatchHandler.getMatchHandler();
            ArrayList<Match> matches = mh.schedule();
            output.printNonRegisteredMatches(matches);
            output.promptMatchByID();
            Match match = input.getMatchIDByList(matches);
            output.promptMatchResult();
            int liverpoolGoals = input.getResult(match.getMatchHomeOrAway(), match);
            FootballerHandler fh = FootballerHandler.getFootballerHandler();
            ArrayList<Footballer> footballers = fh.getActiveFootballersArray();
            for(int i = 0; i <= liverpoolGoals; i++)
            {
                  output.printActiveFootballers(footballers);
                  output.promptGoalscorer();                  
                  int ID = input.getGoalscorer(match);
                  output.promptGoalMinuteScored();
                  int time = input.getGoalMinuteScored();
                  output.promtGoalType();
                  char goalType = input.getGoalType();
                  if(goalType == 'R' || goalType == 'r')
                  {
                        output.promptForAssistedFootballer();
                        int assisted = input.getAssistedFootballer();
                        
                  }
                  else if(!goalType == 'R' || !goalType == 'r')
                  {
                        int assisted = 00;
                  }
                  
                GoalHandler gh = GoalHandler.getGoalHandler();
                Goal goal = new Goal(gh.getNewGoalID(), match.getID(), ID, time, goalType, assisted);
                  
                  
            }
            output.getMatchFormation();
            input.promptMatchFormation();
            output.promptMatchLineup();
            input.getMatLineup();
            output.typeInResultConfirmation();
            
            
            //Der mangler at blive inputtet resultat, home goals (hvem og hvornår de er scoret), away goals, formation, lineup.
            
      }
      
}