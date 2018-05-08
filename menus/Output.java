package menus;

public class Output
{
      public void startMenu()
      {
            header();
            buttonMiddle("Start Menu", 15);
            emptyLine(2);
            buttonLeft("(1). Statistics", 31);
            emptyLine(2);
            twoButtons("(2). Login", "(3). Shedule", 31);
            emptyLine(7);
            typeYourInput("1-3");
            line();
      }
            
      public void statisticMenu()
      {
            header();
            buttonMiddle("Statistic Menu", 20);
            emptyLine(3);
            twoButtons("(1). Top 3 goal scorers", "(3) Club statistics", 31);
            emptyLine(2);
            twoButtons("(2). Footballer Statistics", "(4). Match Statistics", 31);
            emptyLine(2);
            endButton(5);
            typeYourInput("1-5");
            line();            
      }
      
      public void topThreeScorerMenu()
      {
            header();
            emptyLine(2);
            buttonMiddle("Top Three Goal Scorers", 31);
            emptyLine(4);
            System.out.println("*  Wich period do you want to se the top three goal scorers for " + whiteSpaces(50) + "*");
            emptyLine(1);
            System.out.println("*  Enter start date for the period, the format is yyyy-mm-dd " + whiteSpaces(53) + "*");
            emptyLine(5);
            bakEndButton(4,5);
            line();
      }
      
      public void endDateOfPeriod()
      {
            header();
            emptyLine(2);
            buttonMiddle("Top Three Goal Scorers", 31);
            emptyLine(4);
            System.out.println("Enter end date for the period, the format is yyyy-mm-dd ");
            emptyLine(7);
            bakEndButton(4,5);
            line();
      }
      
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
      
      public void typeYourInput(String range)
      {
            System.out.println("*" + "  Type your input here; " + range + whiteSpaces(89 - range.length()) + "*");
      }
      public void emptyLine(int number)
      {
            for (int i = 0; i < number; i++)
            {
                  System.out.println("*" + whiteSpaces(113) + "*");
            }
      }
      
      public void line()
      {
            for(int i = 0; i < 115; i++)
            {
                  System.out.print("*");
            }
            System.out.println();
      }
      
      public void endButton(int number)
      {
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonBody("(" + number +")" + " End Program",19) + " *");
            System.out.println("*" + whiteSpaces(93) + buttonHead(19) + " *");
      }
      
      public void bakEndButton(int bakNumber, int endNumber)
      {
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonBody("(" + bakNumber + ")" + " Last Menu ", 19) + whiteSpaces(3) + buttonBody("(" + endNumber +")" + " End Program",19) + " *");
            System.out.println("*" + whiteSpaces(71) + buttonHead(19) + whiteSpaces(3) + buttonHead(19) + " *");
      }
      
      public void twoButtons(String textButtonOne, String textButtonTwo, int length)
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(textButtonOne, length) + whiteSpaces((113 - 2*length)/ 3)
            + buttonBody(textButtonTwo, length) + whiteSpaces((113 - 2*length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((113 - 2*length)/ 3) + "*");
      }
      
      public void buttonLeft(String text, int length)
      {
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonBody(text, length) + whiteSpaces((2*113 - length)/ 3) + "*");
            System.out.println("*" + whiteSpaces((113 - 2*length)/ 3) + buttonHead(length) + whiteSpaces((2*113 - length)/ 3) + "*");
      }
      
      public void buttonMiddle(String text, int length)
      {
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonBody(text,length) + whiteSpaces((113 - length)/2) + "*");
            System.out.println("*" + whiteSpaces((113 - length)/2) + buttonHead(length) + whiteSpaces((113 - length)/2) + "*");            
      }
      
      public String buttonBody(String text, int length)
      {
            String head = "";
            head += "|" + whiteSpaces(length/8) + text;
            int number = (length - 1) - head.length();
            head += whiteSpaces(number) + "|";
            return head;
      }
      
      public String buttonHead(int length)
      {
            String top = "";
            for(int i = 0; i < length; i++)
            {
                  top += "-";
            }
            return top;
             
      }
      public String whiteSpaces(int number)
      {
            String spaces = "";
            for(int i = 0; i < number; i++)
            {
                  spaces += " ";
            }
            return spaces;
      }
}