package menus;

import java.util.ArrayList;   //til oprettelse af ArrayList's
import models.*;
import handlers.*;

public class Output
{    
      //Erik Pilverdier
      //**HJÆLPE METODER:**  
      //bruges til at printe en linje tekst med * som ramme
      public void printLine(String text)
      {
            System.out.println("*" + text + whiteSpaces(113 - text.length()) + "*");
      }
      
      //Erik Pilverdier
      //Laver overskriften på vores menu'er
      public void header()
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
      
      //Erik Pilverdier
      //bruges til at bede brugeren om at taste input ind, range er det tilladte fra og til
      public void typeYourInput(String range)
      {
            System.out.println("*" + "  Type your input here; " + range + whiteSpaces(89 - range.length()) + "*");
      }
      
      //Adam Birch
      //printer en tom linje per "number"
      public void emptyLine(int number)
      {
            for(int i = 0; i < number; i++)
            {
                  System.out.printf("%1s %111s %1s \n","*","", "*");
            }
      }
      
      //Erik Pilverdier
      //printer en linje *******
      public void line()
      {
            System.out.print("*******************************************************************************************************************");
            System.out.println();
      }
      
      //Erik Pilverdier
      //laver en slut knap nede i højre hjørne
      public void endButton(int number)
      {
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonBody("(" + number +")" + " Main Menu",19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
      }
      
      //Erik Pilverdier
      //laver en tilbage knap og en slut knap
      public void bakEndButton(int bakNumber, int endNumber)
      {
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonBody("(" + bakNumber + ")" + " Last Menu ", 19) + whiteSpaces(3) + buttonBody("(" + endNumber +")" + " Main Menu",19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
      }
      
      //Erik Pilverdier
      //laver to knapper
      public void twoButtons(String textButtonOne, String textButtonTwo, int length)
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(textButtonOne, length) + whiteSpaces((113 - 2*length)/ 3)
            + buttonBody(textButtonTwo, length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
      }
      
      //Erik Pilverdier
      //laver 3 knapper
      public void threeButtons(String textButtonOne, String textButtonTwo, String textButtonThree, int length)
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
      
      //Erik Pilverdier
      //laver en knap i venstre side
      public void buttonLeft(String text, int length)
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(text, length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
      }
      
      //Erik Pilverdier
      //laver en kanp i midten af skærmen
      public void buttonMiddle(String text, int length)
      {
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonBody(text,length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");            
      }
      
      //Erik Pilverdier
      //bruges til at kroppen af knapperne
      public String buttonBody(String text, int length)
      {
            String head = "";
            head += "|" + whiteSpaces(length/8) + text;
            int number = (length - 1) - head.length();
            head += whiteSpaces(number) + "|";
            return head;
      }
      
      //Erik Pilverdier
      //bruges til at printe linjerne i toppen og bunden af knappen
      public String buttonHead(int length)
      {
            String top = "";
            for(int i = 0; i < length; i++)
            {
                  top += "-";
            }
            return top;
      }
      
      //Erik Pilverdier
      //laver number antal mellemrum
      public String whiteSpaces(int number)
      {
            String spaces = "";
            for(int i = 0; i < number; i++)
            {
                  spaces += " ";
            }
            return spaces;
      } 
      
      //Erik Pilverdier
      //Laver et H om til Home game og A om til Away game 
      public String homeAwayGame(char game)
      {
            if(game == 'H')
            {
                  return "Home";
            }
            else
            {
                  return "Away";
            }
      }
      
      //Erik Pilverdier
      //finder modstander navnet ud fra deres modstander id og returnerer det
      public String getOpponent(int matchOpponentID)
      {
            OpponentHandler oh = OpponentHandler.getOpponentHandler();
            ArrayList<Opponent> opponents = oh.getContent();
            for(Opponent i : opponents)
            {
                  if(i.getID() == matchOpponentID)
                  {
                        return i.getOpponentName();
                  }
            }
            return null;
      }
      
      //Erik Pilverdier
      //Finder en fodboldspillers navn ud fra et fodboldspiller id og returnerer navnet
      public String getGoalScorerName(int goalScorerFootballerID, ArrayList<Footballer> footballers)
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
      
      //Adam Birch
      //finder oplægeren til målet udfra assistingFootballerID og returnrer navnet, hvis der ikke er lagt op til målet returneres no assist
      public String getAssistingPlayerName(int assistingFootballerID, ArrayList<Footballer> footballers)
      {
            String assistingFootballerName = "";
            if(assistingFootballerID == 00)
            {
                  return "UNASSISTED";
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
      
      //Erik Pilverdier, Lasse Gustavson
      //**MENU'ER:**
     //Printer start menuen hvorfra du kan vælge statisk, admin menu eller schedule.
      public void startMenu()
      {
            header();         //Printer overskriften "you vil newer walk alone, liverpool F.C.
            buttonMiddle("Start Menu", 15);//laver en kanp i midten af skærmen, med teksten "start menu"
            emptyLine(2);     //to tomme linjer
            buttonLeft("(1). Statistics", 31);  //laver en knap til højre i skærmbilledet
            emptyLine(2);     
            twoButtons("(2). Login", "(3). Shedule", 31);   //to knapper ved siden af hinanden
            emptyLine(7);
            typeYourInput("1-3");// printer en besked til brugeren om at de skal taste et tal imellem 1 og 3.
            line();//linje af *** til at markere slutningen på skærmen
      }
      
      //Erik Pilverdier, Lasse Gustavson
      //printer statisik menuen for alle brugere der giver mulighed for at tilgå statistik om footballere og kampe.       
      public void statisticMenu()//Printer statistik menu billdet
      {
            header();
            buttonMiddle("Statistic Menu", 21);
            emptyLine(3);
            twoButtons("(1). Top 3 goal scorers", "(3) Club statistics", 31);
            emptyLine(2);
            twoButtons("(2). Footballer Statistics", "(4). Match Statistics", 31);
            emptyLine(2);
            endButton(5);     //vider en slut knap nede i højre hjørne
            typeYourInput("1-5");
            line();            
      }
      
      //Erik Pilverdier
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
      
      //Erik Pilverdier
      //Printer holdets statistikker ud for sæsonen
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
      
      //Erik Pilverdier
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
      
      //Erik Pilverdier
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
      
      //Erik Pilverdier 
      //Printer oplysninger om en spiller med mulighed for at se hvilke kampe han har spillet
      public void displayFootballerStatistics(Footballer footballer, int goals, int assists, int cleansheets, int matchesPlayed)
      {
            header();
            emptyLine(1);
            buttonMiddle(footballer.getFootballerName()+ " (" + footballer.getFootballerPosition() + ")", 41);
            emptyLine(1);
            twoButtons("Jersey number: "+footballer.getFootballerJersey(), "Salary/week: " 
            + footballer.getFootballerSalary() + "£", 31);
            
            if (footballer instanceof Forward || footballer instanceof Midfielder)
            {
                  twoButtons("Goals scored: " + goals, "Goals assisted: " + assists, 31);
            }
            //hvis fodboldspilleren er forsvarer eller målmand, skal vi printe antallet af clean sheets med
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
      
      //Adam Birch   
      //printer statistik omrking en enkelt kamp, kampdato, spillet formation, startopstilling, hvilke mål Liverpool har scoret
      //målscorer, tidspunkt i kampen målet er scoret, om målet er scoret på straffe osv samt hvem der lagde op til målet
      public void chosenMatch(Match match, ArrayList<Goal> goals, ArrayList<Footballer> footballers)
      {
            header();
            emptyLine(5);
            System.out.printf("%1s %10s %10s %11s %35s %43s \n","*" ,"", "Match Date", "Formation", "Starting Lineup", "*"); 
            System.out.printf("%1s %10s %10s %11s %35s %43s \n", "*","", match.getMatchDate(), match.getMatchFormation(),match.getMatchLineup(),"*");
            int count = 1;
            emptyLine(1);
            System.out.printf("%1s %10s %3s %14s %30s %12s %20s %18s \n","*","","#", "Minute scored", "Goalscorer", "Type", "Assisted", "*");
            for(Goal i : goals)//printer listen af mål
            {
                  System.out.printf("%1s %10s %3s %14s %30s %12s %20s %18s \n", "*","", count, i.getGoalMinuteScored(), getGoalScorerName(i.getGoalScorer(), footballers), i.getGoalTypeToString(), getAssistingPlayerName(i.getGoalAssistingPlayer(), footballers), "*");
                  count ++;
            }
            emptyLine(5);
            bakEndButton(4,5);
            line();
      }
      
      //Emilie Bentsen, Lasse Gustavson
      //Printer Menuen til at administrator menuen
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
      
      //Emilie Bentsen, Lasse Gustavson
      //Printer Menuen til at administrere matches
      public void adminMatchMenuUI()
      {
            header();
            emptyLine(2);
            buttonMiddle("Manage Matches", 31);
            emptyLine(4);
            threeButtons("1. Create Future Match","2. Update Match (NYI)","3. Type in Match Result",31 );
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
      //Erik Pilverdier
      //Printer Menuen til at administrere modstandere
      public void adminOpponentMenu()
      {
            header();
            emptyLine(2);
            buttonMiddle("Manage Opponents", 31);
            emptyLine(4);
            twoButtons("1. Update opponent ","2. Create opponent ",31 );
            emptyLine(7);
            bakEndButton(3,4);
            line();      
      } 
      
      //Erik pilverdier
      //Printer Menuen til at administrere footballers
      public void adminFootballerMenu()
      {
            header();
            emptyLine(2);
            buttonMiddle("Manage Footballers", 31);
            emptyLine(4);
            twoButtons("1. Update Footballer ","2. Create Footballer ",31 );
            emptyLine(7);
            bakEndButton(3,4);
            line(); 
      }      
      
      //Erik Pilverdier
      //**TOP 3 MENU:**
      //menu der beder brugeren om at vælge en dato for starten af den periode de ønsker at se top 3 målscorere
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
      
      //Erik Pilverdier
      //Metode der printer top 3 målscorer i sæsonen
      public void printTopThreeGoalScorers(int[][] topThreeGoalScorers)
      {
            FootballerHandler footballerHandler = FootballerHandler.getFootballerHandler();//objekt af footballhandler, singleton metoden
            header();
            emptyLine(3);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[0][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[0][1], 42);//printer den bedste målscorer ud med navn og antal mål 
            emptyLine(1);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[1][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[1][1], 42);//printer nummer 2 målscorer ud
            emptyLine(1);
            buttonLeft(footballerHandler.getFootballer(topThreeGoalScorers[2][0]).getFootballerName()
             + ": Goals scored " + topThreeGoalScorers[2][1], 42);//nr 3 målscorer
            emptyLine(3);
            bakEndButton(4,5);//printer en tilbage og afslut knap nede i højre hjørne 
            line();
      }
      
      //Erik Pilverdier
      //Menuvalg, brugeren vælger en slut dato for perioden de vil se spillede kampe fra
      public void endDateOfPeriod(String text)
      {
            header();
            emptyLine(2);
            buttonMiddle(text, 41);
            emptyLine(4);
            printLine(" Enter end date for the period, the format is yyyy-mm-dd ");
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
      //Erik Pilverdier
      //**PRINT LISTER:**
      //printer en liste over aktive fodboldspillere.
      public void printActiveFootballers(ArrayList<Footballer> activeFootballers)
      {
      
            for(Footballer i : activeFootballers)
            {
                  System.out.println(i.getFootballerJersey() + " " + i.getFootballerName() + " " + i.getFootballerPosition());
            }
      }
      
      //Adam Birch
      //printer en liste af stats us for oppnents
      public void printOpponentFootballers(ArrayList<Footballer> opponents)
      {
            
            System.out.printf("%3s %20s %5s \n", "ID", "Name", "Team");
            for(Footballer i : opponents)
            {
                  System.out.printf("%3s %20s %5s \n", i.getID(), i.getFootballerName(), i.getFootballerSalary());
            }
            System.out.println();
      }
      
      //Adam Birch
      //printer det resterende kampprogram for sæsonen
      public void printSchedule(ArrayList<Match> schedule)
      {
           System.out.printf("%10s %20s \n","Match date", "Opponent");
           for(Match i : schedule)
            {
                  System.out.printf("%10s %20s \n",i.getMatchDate(), getOpponent(i.getMatchOpponentID()));
            }   
      }
      
      //Adam Birch      
      //printer en liste af de kampe der er spillet i en periode ud
      public void printMatchesPlayedInPeriod(ArrayList<Match> matches)
      {
            System.out.printf("%3s %11s %35s %10s %5s %10s \n", "ID", "Date", "Opponent", "Home/Away", "Score", "Formation");
            for (Match i : matches)
            {
                  System.out.printf("%3s %11s %35s %10s %5s %10s \n", i.getID(), i.getMatchDate(), getOpponent(i.getMatchOpponentID()), i.getMatchHomeOrAway(), i.getMatchHomeGoals() + "-" + i.getMatchAwayGoals(), i.getMatchFormation());       
            }
      }
      
      //Erik Pilverdier
      //Printer en liste over modstandere
      public void printOpponentList(ArrayList<Opponent> opponents)
      {
            for(Opponent i : opponents)
            {
                  System.out.println("Opponent ID: " + i.getID() + ", "+"Opponent Name: " + i.getOpponentName()); 
            }
      }
      
      //Adam Birch      
      //Printer en liste overkampe som ikke er registreret endnu      
      public void printNonRegisteredMatches(ArrayList<Match> matches)
      {
            System.out.printf("%3s %10s %10s \n", "ID", "Date", "Home/Away");
            for(Match i : matches)
            {
                  System.out.printf("%3s %8s %25s \n", i.getID(), i.getMatchDate(), getOpponent(i.getMatchOpponentID()));
            }   
      }
      
      //Emilie Bentsen
      //**PRINT**         
      //Bekræftelse på at en match er blevet oprettet
      public void matchCreationConfirmation()
      {
            printLine("The new match has been created and registered! Good job!");
      }
      
      //Emilie Bentsen
      //Bekræftelse på at en kamps resultater er blevet opdateret
      public void typeInResultConfirmation()
      {
            printLine("Match result has been updated!");
      }
      
      //Erik Pilverdier
      //Printer navnet ud på på en nuværende modstander
      public void printOpponentName(Opponent opponent)
      {
            printLine("Current opponent name: " + opponent.getOpponentName());
      }
      
      //Adam Birch
      //Giver en bekræftelse på at der er opdateret en spiller, samt viser de nye oplysninger om spilleren
      public void confirmationUpdateFootballer(Footballer footballer)
      {
            printLine("You have updated "+footballer.getFootballerName());
            System.out.printf("%3s %3s %8s %5s %3s", "ID\n", "Jersey", "Name", "Salary/week", "Employed", "Position"); 
            System.out.printf("%3s %3s %8s %5s %3s\n", footballer.getID(), footballer.getFootballerJersey(), footballer.getFootballerName(), footballer.getFootballerSalary(), footballer.getFootballerEmployed(), footballer.getFootballerPosition());
      }
      
      //Erik Pilverdier
      //Giver ern bekræftelse, samt viser oplysniner om nyoprettet footballer
      public void confirmationOnCreateFootballer(int jerseyNumber, String name, String salary, boolean employed, String position) 
      {
            printLine("You have created a new footballer: " + name);
            printLine("Jersey number: " + jerseyNumber + ", Salary: " + salary + ", Employment staus: " + employed + ", Position: " + position);
      }
      
      //Erik Pilverdier
      //Giver en bekræftelse, samt viser oplysninger om en nyoprettet modstander
      public void confirmationOnCreateOpponent(String opponentName, boolean active) 
      {
            printLine("You have created" + opponentName + ". Their current status is:" + active );
            printLine("Input 3 to return to menu.");
      }
      
      //Adam Birch
      //Giver en bekræftelse med de opdaterede oplysninger når en modstander er opdateret
      public void confirmationOnUpdateOpponent(Opponent opponent)
      {
            printLine("You have updated the opponent.");
            System.out.printf("%3s %20s %5s\n", "ID", "Name", "Active");
            System.out.printf("%3s %20s %5s\n", opponent.getID(), opponent.getOpponentName(), opponent.getID()); 
            printLine("Input 3 to return to menu."); 
      }
      
      //Emilie Bentsen
      //Giver en meddelelses om hvor mange mål admin mangler at indtaste data for
      public void printGoals(int homeGoals) 
      {
            printLine("Goals left to update: " + homeGoals);
      }
      
      //Emilie Bentsen
      //Fejlmeddelelse hvis brugeren har indtastet forkert brugernavn eller password
      public void invalidUser() 
      {
            printLine("Wrong password or username, please try again");
      } 

     //**PROMPT:**  //Alle gruppe medlemmer har produceret flere af disse
     //Beder om en spillers jersey number
      public void promptForJerseyNumber() 
      {
            printLine("Players jersey number:");
      }  
      //Beder om et Jersey nr.
      public void promptJerseyNumberFootballerStatistics()  
      {
            System.out.println("Wich footballer do you want to see");
            System.out.println("input the footballers jersey number to choose");
      }
      //Beder om et ID 
      public void promptForID() 
      {
            System.out.println("Enter ID:");
      }
      //Beder om et Username til en admin der forsøger at logge ind      
      public void promptUsername() 
      {
            printLine("Please type in username (Enter exit if you want to return to main menu)");      
      }  
      //Beder om et password til en admin der forsøger at logge ind
      public void promptPassword() 
      {
            printLine("Please type in password (Enter exit if you want to return to main menu)");      
      } 
      //Beder om en dato på en ny oprettet kamp
      public void promptDate() 
      {
            printLine("Enter date of the new match, the format is yyyy-mm-dd");       
      }
      //Beder om et ID på en modstander fra en liste af modstandere
      public void promptOpponent() 
      {
            printLine("Please enter the ID of one the displayed Opponents");
      }
      //Spørger om Liverpool har spillet ude eller hjemme
      public void promptHomeAway() 
      {
            printLine("Please enter wether Liverpool is playing at \"Home\" or \"Away\". (H/A)");
      }
      //Beder om et ID på en kamp fra en liste af kampe   
      public void promptMatchByID() 
      {
            printLine("Please enter ID of one of the listed matches.");
      }
      //beder om resultatet på en kamp
      public void promptMatchResult() 
      {
            printLine("Please enter match result. (Home-Away)(X-X) ");
      }
      //Beder om en footballers jersey nr
      public void promptGoalscorer() 
      {
            printLine("Please enter scoring footballers jersey number:");
            
      }
      //Spørger i hvilket minut af kampen et mål er blevet scoret
      public void promptGoalMinuteScored() 
      {
            printLine("What minute was the goal scored?");
      }
      //Beder bruger om at indtaste typen på et mål
      public void promtGoalType() 
      {
            printLine("Please enter type of goal. (R = 'Regular' P = 'Penalty' O = 'Own')");
      }
      //Spørger om et mål var assisted
      public void promtWasGoalAssisted() 
      {
            printLine("Was the goal assisted? (Y/N)");
      }
      //beder om assisterende spiller til et mål
      public void promptForAssistedFootballer() 
      {
            printLine("Please enter jersey number of assisting player:");
      }
      //Beder om et holds formation
      public void promptMatchFormation() 
      {
            printLine("Enter starting formation. (0-0-0 or 0-0-0-0) ");
      }
      //Beder om et holds startopstilling
      public void promptMatchLineup() 
      {
            printLine("Enter starting lineup: (00-00-00-00-00-00-00-00-00-00-00) ");
      }
      //Spørger om den scorende modstander er på listen over modstandere
      public void promptIsOpponentOnList() 
      {
            printLine("Is the scoring opponent on the list? (Y/N)");
      }
      //beder om en spillers nye jersey nr.
      public void promptNewJerseyNumber(Footballer footballer) 
      {
            printLine("Players current jersey number is " + footballer.getFootballerJersey());
            printLine("Enter the players new jersey number: ");
      }
      //beder om en spillers nye navn
      public void promptFootballerName(Footballer footballer) 
      {
            printLine("Players current name is " + footballer.getFootballerName());
            printLine("Enter the players new name: ");
      }
      //beder om en spillers nye løn
      public void promptFootballerSalary(Footballer footballer) 
      {
            printLine("Players current salary is " + footballer.getFootballerSalary());
            printLine("Enter the players new salary: ");
      }
      //Beder om spillers status aktiv/inaktiv
      public void promptFootballerEmployed(Footballer footballer)
      {
            printLine("Players current employment status is " + footballer.getFootballerEmployed());
            printLine("Enter the players employment status (1) = true, (2) = false ");
      }
      //beder om en spillers jersey nr.
      public void promptJerseyNumber() 
      {
            printLine("Enter the new players jersey number:");
      }
      //Beder om en spillers navn
      public void promptFootballerName() 
      {
            printLine("Enter the new players namer:");
      }
      //beder om spilleres løn eller hold afhængigt af en string.
      public void promptFootballerSalary(String salaryOrTeam) 
      {
            printLine("Input players " + salaryOrTeam);
      }
      //beder brugeren indtaste om spilleren er aktiv eller ej
      public void promptFootballerEmployed() 
      {
            printLine("Enter the players status. (1. Liverpool 2. Other team/former player)");
      }
      //Beder om footballers position
      public void promptFootballerPosition() 
      {
            printLine("Input number to set players position:  GK(1), DF(2), MF(3), FW(4) ");
      } 
      //Beder om modstanderen
      public void promptOpponentNameCreateNewOpponent() 
      {
            printLine("Enter opponent name:");
      }
      //Beder om modstanderens nye navn
      public void promptOpponentName() 
      {
            printLine("New opponent name:");
      }
      //Spørger om modstander er i PL, til at afgøre om modstanderen er aktiv
      public void promptOpponentActice() 
      {
            printLine("Is the opponent currently in Premier League?");
            printLine("(1. Yes (2. No");
      }
}