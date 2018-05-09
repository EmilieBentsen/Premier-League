import models.*;
import handlers.*;
import java.util.*;
import java.time.LocalDate;

public class Main
{
      public static void main(String[]args)
      {
<<<<<<< HEAD
           

=======
            MatchHandler mh = MatchHandler.getMatchHandler();
            /*System.out.print(mh.getMatchesPlayedInPeriod(LocalDate.parse("2017-11-01"), LocalDate.parse("2017-12-01"), 12));*/  
            System.out.print(mh.schedule());          
            
>>>>>>> 250bafc25dfeafb6cfac61adcc8f9183cafab51a
      }
}