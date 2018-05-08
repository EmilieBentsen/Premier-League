package menus;

public class MainMenu
{
      Output output = new Output();
      Input input = new Input();
            
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
                              
                  case 2:     //adminMenu();
                              
                  case 3:     //adminMatchMenu();
                                
            }
      }
}