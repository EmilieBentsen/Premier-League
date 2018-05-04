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
            //fh.listFootballers();
            

            //MatchHandler mh = new MatchHandler();
            //mh.updateObject(mh.getMatchArray(),01,LocalDate.parse("2018-12-24"), 90, 'H', 3, 9, "6-3-2", "00-00-00-00-00-00-00-00-00-00-00");
            //mh.listMatches();
            /*OpponentHandler oh = new OpponentHandler();
            oh.listOpponents();*/
            
            GoalHandler gh = new GoalHandler();
            //gh.listGoals();
            System.out.print(fh.getFootballer(26).toString());
            System.out.println("Goals scored this season " + gh.GoalsByFootballer(26));
      }
}