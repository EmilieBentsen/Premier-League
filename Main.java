import models.*;
import handlers.*;
import java.util.*;
import java.time.LocalDate;

public class Main
{
      public static void main(String[]args)
      {

      MatchHandler mh = MatchHandler.getMatchHandler();
            GoalHandler gh = GoalHandler.getGoalHandler();
            
            //System.out.println(mh.CleanSheetsByClub());
            LocalDate startDate = LocalDate.parse("2017-08-01");
            LocalDate endDate = LocalDate.parse("2017-12-01");
            
            int[][] doubleArray = gh.getArrayWithGoalFrequencies(gh.getGoalscorerByMatchID(mh.getMatchIDInAPeriod(startDate, endDate)));
            gh.getTopGoalscorers(doubleArray, 4);
            
      
      }
}