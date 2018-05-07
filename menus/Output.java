package menus;

public class Output
{
      public void startMenu()
      {
            header();
            emptyLine(5);
            header();
            
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
      
      public void header()
      {
            line();
            emptyLine(1);
            System.out.println("*" + " __   __                     _ _ _                                             _ _            _                  " + "*");
            System.out.println("*" + " \\ \\ / /__  _   _  __      _(_) | |  _ __   _____   _____ _ __  __      ____ _| | | __   __ _| | ___  _ __   ___ " + "*");
            System.out.println("*" + "  \\ V / _ \\| | | | \\ \\ /\\ / / | | | | '_ \\ / _ \\ \\ / / _ \\ '__| \\ \\ /\\ / / _` | | |/ /  / _` | |/ _ \\| '_ \\ / _ \\" + "*");
            System.out.println("*" + "   | | (_) | |_| |  \\ V  V /| | | | | | | |  __/\\ V /  __/ |     \\ V  V / (_| | |   <  | (_| | | (_) | | | |  __/" + "*");
            System.out.println("*" + "   |_|\\___/ \\__,_|   \\_/\\_/ |_|_|_| |_| |_|\\___| \\_/ \\___|_|      \\_/\\_/ \\__,_|_|_|\\_\\  \\__,_|_|\\___/|_| |_|\\___|" + "*");           
            emptyLine(1);
            line();
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