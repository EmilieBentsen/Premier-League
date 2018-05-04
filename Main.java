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
      
            /*FootballerHandler fh = new FootballerHandler();
            fh.listFootballers();*/
            
<<<<<<< HEAD
            MatchHandler mh = new MatchHandler();
            mh.updateObject(mh.getMatchArray(),01,LocalDate.parse("2018-12-24"), 90, 'H', 3, 9, "6-3-2", "00-00-00-00-00-00-00-00-00-00-00");
            mh.listMatches();
=======
            /*OpponentHandler oh = new OpponentHandler();
            oh.listOpponents();*/
            
            GoalHandler gh = new GoalHandler();
            gh.listGoals();
            System.out.println(gh.GoalsByFootballer(1));
>>>>>>> 7635c8f7d0719e4602b7f14fef2f1fa334337894
      }
}