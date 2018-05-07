import models.*;
import handlers.*;
import java.util.*;
import java.time.LocalDate;

public class Main
{
      public static void main(String[]args)
      {
            //FileHandler fh = new FileHandler();
            //fh.writeFileContent("goal_backup.txt", fh.getFileContent(fh.GOAL_TXT));
            //System.out.println(ileHandler.getFileContent(FileHandler.OPPONENT_TXT));
      
<<<<<<< HEAD
            FootballerHandler fh = new FootballerHandler();
            MatchHandler mh = new MatchHandler();
            GoalHandler gh = new GoalHandler();
            
=======
            //FootballerHandler fh = new FootballerHandler();
>>>>>>> 8e3a9ceff3bdab1df960ec7ca498db97034b29ea
            //fh.listFootballers();
            

            MatchHandler mh = new MatchHandler();
            mh.deleteMatch(41);
            //mh.createObject(LocalDate.parse("2018-07-15"), 6, 'H', 0, 0,"4-4-2", "00-00-00-00-00-00-00-00-00-00-00");
            //mh.updateObject(mh.getMatchArray(),01,LocalDate.parse("2018-12-24"), 90, 'H', 3, 9, "6-3-2", "00-00-00-00-00-00-00-00-00-00-00");
            //mh.listMatches();
            /*OpponentHandler oh = new OpponentHandler();
            oh.listOpponents();*/
            
<<<<<<< HEAD
            
            //gh.listGoals();
            /*System.out.print(fh.getFootballer(26).getFootballerName());
            System.out.println(" scored " +gh.GoalsByFootballer(26) + " goals this season.");
            
            System.out.print(fh.getFootballer(26).getFootballerName());
            System.out.println(" made " +gh.AssistsByFootballer(26) + " assists this season.");
            
            System.out.println(mh.CleanSheetsByFootballer(00-00-00-00-00-00-00-00-00-00-00));
            */
            System.out.println(mh.CleanSheetsByClub());
            System.out.println(mh.CleanSheetsByFootballer("11"));
=======
            //GoalHandler gh = new GoalHandler();
            //gh.listGoals();
            /*System.out.print(fh.getFootballer(26).toString());
            System.out.println("Goals scored this season " + gh.GoalsByFootballer(26));*/
>>>>>>> 8e3a9ceff3bdab1df960ec7ca498db97034b29ea
      }
}