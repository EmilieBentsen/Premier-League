package menus;

import java.util.ArrayList;   //til oprettelse af ArrayList's
import models.*;
import handlers.*;

public class Output
{      
      public void startMenu()//Printer start menu billedet
      {
            header();         //Printer overskriften "you vil newer walk alone, liverpool F.C.
            buttonMiddle("Start Menu", 15);//laver en kanp i midten af sk�rmen, med teksten "start menu"
            emptyLine(2);     //to tomme linjer
            buttonLeft("(1). Statistics", 31);  //laver en knap til h�jre i sk�rmbilledet
            emptyLine(2);     
            twoButtons("(2). Login", "(3). Shedule", 31);   //to knapper ved siden af hinanden
            emptyLine(7);
            typeYourInput("1-3");// printer en besked til brugeren om at de skal taste et tal imellem 1 og 3.
            line();//linje af *** til at markere slutningen p� sk�rmen
      }
            
      public void statisticMenu()//Printer statistik menu billdet
      {
            header();
            buttonMiddle("Statistic Menu", 21);
            emptyLine(3);
            twoButtons("(1). Top 3 goal scorers", "(3) Club statistics", 31);
            emptyLine(2);
            twoButtons("(2). Footballer Statistics", "(4). Match Statistics", 31);
            emptyLine(2);
            endButton(5);     //vider en slut knap nede i h�jre hj�rne
            typeYourInput("1-5");
            line();            
      }
      
      public void topThreeScorerMenu()
      {
            header();
            emptyLine(2);
            buttonMiddle("Top Three Goal Scorers", 31);
            emptyLine(4);
            printLine("  Wich period do you want to se the top three goal scorers for ");
            emptyLine(1);
            printLine("  Enter start date for the period, the format is yyyy-mm-dd ");
            emptyLine(5);
            bakEndButton(4,5);
            line();
      }
      
      public void printTopThreeGoalScorers(int[][] topThreeGoalScorers)//
      {
            FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();//objekt af footballhandler, singleton metoden
            header();
            emptyLine(3);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[0][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[0][1], 42);//printer den bedste m�lscorer ud med navn og antal m�l 
            emptyLine(1);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[1][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[1][1], 42);//printer nummer 2 m�lscorer ud
            emptyLine(1);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[2][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[2][1], 42);//nr 3 m�lscorer
            emptyLine(3);
            bakEndButton(4,5);//printer en tilbage og afslut knap nede i h�jre hj�rne 
            line();
      }
      
      public void endDateOfPeriod(String text)
      {
            header();
            emptyLine(2);
            buttonMiddle(text, 31);
            emptyLine(4);
            printLine(" Enter end date for the period, the format is yyyy-mm-dd ");
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
      public void printActiveFootballers(ArrayList<Footballer> activeFootballers)
      {
      //printer en liste over aktive fodboldspillere.
            for(Footballer i : activeFootballers)
            {
                  System.out.println(i.getFootballerJersey() + " " + i.getFootballerName() + " " + i.getFootballerPosition());
            }
      }
      
      public void printOpponentFootballers(ArrayList<Footballer> opponents)
      {
            for(Footballer i : opponents)
            {
                  System.out.printf("%3s %20s %5s", "ID", "Name", "Team");
                  System.out.printf("%3s %20s %5s", i.getID(), i.getFootballerName(), i.getFootballerSalary());
            }
      }
      
      public void printSchedule(ArrayList<Match> schedule, ArrayList<Opponent> opponents)
      {
      //printer det resterende kampprogram for s�sonen.
           for(Match i : schedule)
            {
                  System.out.println("Match date: " + i.getMatchDate() + " Opponent: " + getOpponent(i.getMatchOpponentID(), opponents) + " " 
                  + i.getMatchHomeOrAway() + " " + i.getMatchHomeGoals() + "-" + i.getMatchAwayGoals()
                  + " Formation played: " + i.getMatchFormation());
            }   
      }
      
      public void inputJerseyNumber()
      {
            System.out.println("Wich footballer do you want to see");
            System.out.println("input the footballers jersey number to choose");
      }
      
      //printer stats us for den enkelte fodboldspiller
      public void displayFootballerStatistics(Footballer footballer, int goals, int assists, int cleansheets, int matchesPlayed)
      {
            header();
            emptyLine(1);
            buttonMiddle(footballer.getFootballerName()+ " (" + footballer.getFootballerPosition() + ")", 41);
            emptyLine(1);
            twoButtons("Jersey number: "+footballer.getFootballerJersey(), "Salary: " 
            + footballer.getFootballerSalary(), 31);
            
            if (footballer instanceof Forward || footballer instanceof Midfielder)
            {
                  twoButtons("Goals scored: " + goals, "Goals assisted: " + assists, 31);
            }
            //hvis fodboldspilleren er forsvarer eller m�lmand, skal vi printe antallet af clean sheets med
            else if( footballer instanceof Defender || footballer instanceof Goalkeeper)
            {
                  threeButtons("Cleansheets: " + cleansheets,"Goals scored: " + goals, "Goals assisted: " + assists, 31); 
            }
            emptyLine(2);
            buttonLeft("(3): Matches played in period", 37);
            emptyLine(2);
            bakEndButton(4,5);   
            line();        
      }
      
      //printer menu'en for hvilke kampe fodboldspilleren har spillet
      public void footballerMatchesPlayed(Footballer footballer)
      {
            header();
            emptyLine(6);
            printLine(" Wich period do you want to se the matches played by: " + footballer.getFootballerName());
            emptyLine(2);
            printLine(" Enter end date for the period, the format is yyyy-mm-dd: ");
            emptyLine(4);
            bakEndButton(4,5);
            line();
      }
      
      //printer en liste af de kampe der er spillet i en periode ud
      public void printMatchesPlayedInPeriod(ArrayList<Match> matches, ArrayList<Opponent> opponents)
      {
            for (Match i : matches)
            {
                  System.out.println("ID: " + i.getID() + " Match date: " + i.getMatchDate() + " Opponent: " + getOpponent(i.getMatchOpponentID(), opponents)
                  + " " + homeAwayGame(i.getMatchHomeOrAway()) + " " + i.getMatchHomeGoals() + "-" + i.getMatchAwayGoals()
                  + " Formation played: " + i.getMatchFormation());
            }            
      }
      
      public String homeAwayGame(char game)//Laver et H om til Home game og A om til Away game 
      {
            if(game == 'H')
            {
                  return "Home game";
            }
            else
            {
                  return "Away game";
            }
      }
      
      //finder modstander navnet ud fra deres modstander id og returnerer det
      public String getOpponent(int matchOpponentID, ArrayList<Opponent> opponents)
      {
            for(Opponent i : opponents)
            {
                  if(i.getID() == matchOpponentID)
                  {
                        return i.getOpponentName();
                  }
            }
            return null;
      }
      
      //Printer holdets statistikker ud for s�sonen
      public void clubStatisticsMenu(int gamesPlayed, int gamesWon, int gamesDraw, int gamesLost, int goalsScored, int goalsConceded, int cleenSheets)
      {
            header();
            emptyLine(1);
            buttonMiddle("Games played : " + gamesPlayed, 31);
            emptyLine(1);
            threeButtons("Games won : " + gamesWon, "Games draw : " + gamesDraw, "Games lost : " + gamesLost, 31);
            emptyLine(1);
            threeButtons("Goals scored : " + goalsScored, "Goals conceded : " + goalsConceded, "Cleen sheets : " + cleenSheets, 31);
            emptyLine(4);
            bakEndButton(4,5);
            line();
      }
      
      //printer en menu ud, der beder brugeren om at taste en start dato for en periode
      public void matchStatisticsMenuStartDate()
      {
            header();
            emptyLine(2);
            buttonMiddle("Match Statistics", 31);
            emptyLine(4);
            printLine(" Please input the period for which you want matches displayed");
            emptyLine(1);
            printLine(" Enter start date for the period, the format is yyyy-mm-dd ");
            emptyLine(5);
            bakEndButton(4,5);
            line();
      }
      
      //printer en menu ud, der beder brugeren om at taste en slut dato for en periode
      public void matchStatisticsMenuEndDate()
      {
            header();
            emptyLine(2);
            buttonMiddle("Match Statistics", 31);
            emptyLine(5);
            printLine(" Enter end date for the period, the format is yyyy-mm-dd ");
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
      //printer statistik omrking en enkelt kamp, kampdato, spillet formation, startopstilling, hvilke m�l Liverpool har scoret
      //m�lscorer, tidspunkt i kampen m�let er scoret, om m�let er scoret p� straffe osv samt hvem der lagde op til m�let
      public void chosenMatch(Match match, ArrayList<Goal> goals, ArrayList<Footballer> footballers)
      {
            header();
            emptyLine(5);
            printLine(" Match Date: " + match.getMatchDate() + " Formation: " + match.getMatchFormation() + " Starting lineup by jersey number:  " + match.getMatchLineup());
            int count = 1;
            for(Goal i : goals)//printer listen af m�l
            {
                  printLine(count + " Minutte scored: " + i.getGoalMinuteScored() + " Goal scorer: " + printGoalScorerName(i.getGoalScorer(), footballers) + " "
                   + i.getGoalTypeToString() + " Asisted by: " + printAssistingPlayerName(i.getGoalAssistingPlayer(), footballers));
                  count ++;
            }
            emptyLine(5);
            bakEndButton(4,5);
            line();
      }
      
      //Finder en fodboldspillers navn ud fra et fodboldspiller id og returnerer navnet
      public String printGoalScorerName(int goalScorerFootballerID, ArrayList<Footballer> footballers)
      {
            String goalScorerName = "";
            for(Footballer i : footballers)
            
            {
                  if(goalScorerFootballerID == i.getID())
                  {
                        goalScorerName = i.getFootballerName();
                  }
            }
            return goalScorerName;
      }
      
      //finder opl�geren til m�let udfra assistingFootballerID og returnrer navnet, hvis der ikke er lagt op til m�let returneres no assist
      public String printAssistingPlayerName(int assistingFootballerID, ArrayList<Footballer> footballers)
      {
            String assistingFootballerName = "";
            if(assistingFootballerID == 00)
            {
                  return "no assist";
            }
            else
            {
                  for(Footballer i : footballers)
                  {
                        if(assistingFootballerID == i.getID())
                        {
                              assistingFootballerName = i.getFootballerName();
                        }
                  }
            }
            return assistingFootballerName;
      }
      
      public void printLine(String text)//bruges til at printe en linje tekst med * som ramme
      {
            System.out.println("*" + text + whiteSpaces(113 - text.length()) + "*");
      }
      
      public void header()//Laver overskriften p� vores menu'er
      {
            line();
            System.out.println("*" + " __   __                     _ _ _                                             _ _            _                  " + "*");
            System.out.println("*" + " \\ \\ / /__  _   _  __      _(_) | |  _ __   _____   _____ _ __  __      ____ _| | | __   __ _| | ___  _ __   ___ " + "*");
            System.out.println("*" + "  \\ V / _ \\| | | | \\ \\ /\\ / / | | | | '_ \\ / _ \\ \\ / / _ \\ '__| \\ \\ /\\ / / _` | | |/ /  / _` | |/ _ \\| '_ \\ / _ \\" + "*");
            System.out.println("*" + "   | | (_) | |_| |  \\ V  V /| | | | | | | |  __/\\ V /  __/ |     \\ V  V / (_| | |   <  | (_| | | (_) | | | |  __/" + "*");
            System.out.println("*" + "   |_|\\___/ \\__,_|   \\_/\\_/ |_|_|_| |_| |_|\\___| \\_/ \\___|_|      \\_/\\_/ \\__,_|_|_|\\_\\  \\__,_|_|\\___/|_| |_|\\___|" + "*");           
            emptyLine(1);
            line();
            System.out.println("*" + whiteSpaces(32) + "  _    _                            _   ___ ___   " + whiteSpaces(31) + "*");
            System.out.println("*" + whiteSpaces(32) + " | |  (_)_ _____ _ _ _ __  ___  ___| | | __/ __|  " + whiteSpaces(31) + "*");
            System.out.println("*" + whiteSpaces(32) + " | |__| \\ V / -_) '_| '_ \\/ _ \\/ _ \\ | | _| (__ _ " + whiteSpaces(31) + "*");
            System.out.println("*" + whiteSpaces(32) + " |____|_|\\_/\\___|_| | .__/\\___/\\___/_| |_(_)___(_)" + whiteSpaces(31) + "*");
            System.out.println("*" + whiteSpaces(32) + "                    |_|                           " + whiteSpaces(31) + "*");
      }
      
      public void typeYourInput(String range)//bruges til at bede brugeren om at taste input ind, range er det tilladte fra og til
      {
            System.out.println("*" + "  Type your input here; " + range + whiteSpaces(89 - range.length()) + "*");
      }
      
      public void emptyLine(int number)//printer en tom linje per "number"
      {
            for(int i = 0; i < number; i++)
            {
                  System.out.printf("%1s %111s %1s \n","*","", "*");
            }
      }
      
      public void line()//printer en linje *******
      {
            System.out.print("*******************************************************************************************************************");
            System.out.println();
      }
      
      public void endButton(int number)//laver en slut knap nede i h�jre hj�rne
      {
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonBody("(" + number +")" + " End Program",19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
      }
      
      public void bakEndButton(int bakNumber, int endNumber)//laver en tilbage knap og en slut knap
      {
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonBody("(" + bakNumber + ")" + " Last Menu ", 19) + whiteSpaces(3) + buttonBody("(" + endNumber +")" + " End Program",19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
      }
      
      public void twoButtons(String textButtonOne, String textButtonTwo, int length)//laver to knapper
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(textButtonOne, length) + whiteSpaces((113 - 2*length)/ 3)
            + buttonBody(textButtonTwo, length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
      }
      
      public void threeButtons(String textButtonOne, String textButtonTwo, String textButtonThree, int length)//laver 3 knapper
      {
            System.out.println("*" + whiteSpaces((113 - 3*length)/ 4) + buttonHead(length)
             + whiteSpaces((113 - 3*length)/ 4) + buttonHead(length) + whiteSpaces((113 - 3*length)/ 4) 
             + buttonHead(length) + whiteSpaces((113 - 3*length)/ 4) + "*");
             
            System.out.println("*" + whiteSpaces((113 - 3*length)/ 4) 
            + buttonBody(textButtonOne, length) + whiteSpaces((113 - 3*length)/ 4)
            + buttonBody(textButtonTwo, length) + whiteSpaces((113 - 3*length)/ 4)
            + buttonBody(textButtonThree, length) + whiteSpaces((113 - 3*length)/ 4) + "*");
            
            System.out.println("*" + whiteSpaces((113 - 3*length)/ 4) + buttonHead(length)
             + whiteSpaces((113 - 3*length)/ 4) + buttonHead(length) + whiteSpaces((113 - 3*length)/ 4) 
             + buttonHead(length) + whiteSpaces((113 - 3*length)/ 4) + "*");
      }
      
      public void buttonLeft(String text, int length)//laver en knap i venstre side
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(text, length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
      }
      
      public void buttonMiddle(String text, int length)//laver en kanp i midten af sk�rmen
      {
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonBody(text,length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");            
      }
      
      public String buttonBody(String text, int length)//bruges til at kroppen af knapperne
      {
            String head = "";
            head += "|" + whiteSpaces(length/8) + text;
            int number = (length - 1) - head.length();
            head += whiteSpaces(number) + "|";
            return head;
      }
      
      public String buttonHead(int length)//bruges til at printe linjerne i toppen og bunden af knappen
      {
            String top = "";
            for(int i = 0; i < length; i++)
            {
                  top += "-";
            }
            return top;
      }
      
      public String whiteSpaces(int number)//laver number antal mellemrum
      {
            String spaces = "";
            for(int i = 0; i < number; i++)
            {
                  spaces += " ";
            }
            return spaces;
      }  
      
      public void promptUsername()
      {
            printLine("Please type in username (Enter exit if you want to return to main menu)");      
      }  
      
      public void promptPassword()
      {
            printLine("Please type in password (Enter exit if you want to return to main menu)");      
      } 
      
      public void invalidUser()
      {
            printLine("Wrong password or username, please try again");
      } 
      public void promptDate()
      {
            printLine("Enter date of the new match, the format is yyyy-mm-dd");       
      }
      public void promptOpponent()
      {
            printLine("Please enter the ID of one the displayed Opponents");
      }
      public void promptHomeAway()
      {
            printLine("Please enter whether Liverpool is playing as \"Home\" or \"Away\", enter \"H\" for \"Home\" and \"A\" for \"Away\".");
      }
      public void matchCreationConfirmation()
      {
            printLine("The new match has been created and registered! Good job!");
      }
           
      public void printOpponentList(ArrayList<Opponent> opponents)
      {
            for(Opponent i : opponents)
            {
                  System.out.println("Opponent ID: " + i.getID() + ", "+"Opponent Name: " + i.getOpponentName()); 
            }
      }
      
      public void adminMenuUI()
      {
            header();
            emptyLine(2);
            buttonMiddle("Admin Menu", 31);
            emptyLine(4);
            threeButtons("1. Manage Matches","2. Manage Footballers ","3. Manage Opponents",31 );
            emptyLine(7);
            endButton(4);
            line();
      }
      public void adminMatchMenuUI()
      {
            header();
            emptyLine(2);
            buttonMiddle("Manage Matches", 31);
            emptyLine(4);
            threeButtons("1. Create Future Match","2. Update Match","3. Type in Match Result",31 );
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
      public void printNonRegisteredMatches(ArrayList<Match> schedule)
      {
           for(Match i : schedule)
            {
                  System.out.println("Match ID: " + i.getID() +  
                  "Match date: " + i.getMatchDate() +", Home/Away: " + i.getMatchHomeOrAway());
            }   
      }
      
      public void promptMatchByID()
      {
            printLine("Please enter \"ID\" of one of the listed matches.");
      }
      
      public void promptMatchResult()
      {
            printLine("Please enter match result. The home team Goals is the first ciffer \"2-3\" ");
      }
      
      public void promptGoalscorer()
      {
            printLine("Please enter \"Jersey Nr.\" of the scoring footballer.");
            
      }
      
      public void promptGoalMinuteScored()
      {
            printLine("Please enter what minute the goal was scored");
      }
      
      public void promtGoalType()
      {
            printLine("Please enter type of goal R = 'Regular' P = 'Penalty' O = 'Own'");
      }
      
      public void promptForAssistedFootballer()
      {
            printLine("please enter ID of assisted player");
      }
      public void getMatchFormation()
      {
            printLine("please enter match formation by format \"0-0-0-0\" ");
      }
      public void promptMatchLineup()
      {
            printLine("please enter match lineup by format \"00-00-00-00-00-00-00-00-00-00-00\" ");
      }
      public void typeInResultConfirmation()
      {
            printLine("Match result has been updated!");
      }
      
      public void adminOpponentMenu()
      {
            header();
            emptyLine(2);
            buttonMiddle("Manage Opponents", 31);
            emptyLine(4);
            threeButtons("1. Update opponent ","2. Create opponent Match ","3. Type in Match Result",31 );
            emptyLine(7);
            bakEndButton(4,5);
            line();      /*Skal print menuoversigt: 1. Update Opponent Information, 2.Create Opponent*/
      } 
      
      public void promptOpponentName()
      {
            printLine("Enter the new name of the opponent");
      }
      
      public void changeOpponentName()
      {
            printLine("Do you want to change the name of the opponent");
      }
      
      public void changeOpponentActive()
      {
            printLine("Do you want to change the active status of the opponent");
      }
      
      public void promptOpponentActice()
      {
            printLine("Enter if the opponent is active");
            printLine("1 for active, 2 for inactive");
      }
      
      public void confirmationOnUpdateOpponent(Opponent opponent)
      {
            printLine("You have updatet the opponent with the id " + opponent.getID() + " to: " + opponent.getOpponentName()
             + " and active status is " + opponent.getOpponentActive());
      }
      
      public void inputOpponentName()
      {
            printLine("Enter the opponents name");
      }
      
      public void confirmationOnCreateOpponent(String opponentName, boolean active)
      {
            printLine(" you have created " + opponentName + " and active status is " + active );
      }
}