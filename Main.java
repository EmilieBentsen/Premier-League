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
            GoalHandler gh = GoalHandler.getGoalHandler();
>>>>>>> d2286882a6c9f5fb1b1e422847c4648108e81fe5
            
            //System.out.println(mh.CleanSheetsByClub());
            LocalDate startDate = LocalDate.parse("2017-08-01");
            LocalDate endDate = LocalDate.parse("2017-12-01");
            
            int[][] doubleArray = gh.getArrayWithGoalFrequencies(gh.getGoalscorerByMatchID(mh.getMatchIDInAPeriod(startDate, endDate)));
            gh.getTopGoalscorers(doubleArray, 4);
            
<<<<<<< HEAD

=======
      
>>>>>>> d2286882a6c9f5fb1b1e422847c4648108e81fe5
      }
}