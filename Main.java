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
      
            FootballerHandler fh = new FootballerHandler();
            MatchHandler mh = new MatchHandler();
            GoalHandler gh = new GoalHandler();
            
            //fh.listFootballers();
            

            //MatchHandler mh = new MatchHandler();
            //mh.updateObject(mh.getMatchArray(),01,LocalDate.parse("2018-12-24"), 90, 'H', 3, 9, "6-3-2", "00-00-00-00-00-00-00-00-00-00-00");
            //mh.listMatches();
            /*OpponentHandler oh = new OpponentHandler();
            oh.listOpponents();*/
            
            
            //gh.listGoals();
            /*System.out.print(fh.getFootballer(26).getFootballerName());
            System.out.println(" scored " +gh.GoalsByFootballer(26) + " goals this season.");
            
            System.out.print(fh.getFootballer(26).getFootballerName());
            System.out.println(" made " +gh.AssistsByFootballer(26) + " assists this season.");
            
            System.out.println(mh.CleanSheetsByFootballer(00-00-00-00-00-00-00-00-00-00-00));
            */
            System.out.println(mh.CleanSheetsByClub());
            System.out.println(mh.CleanSheetsByFootballer("11"));
      }
}