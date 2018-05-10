package handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import models.*;

public class GoalHandler extends ObjectHandler<Goal>
{
      private static GoalHandler instance;
      private ArrayList<Goal> goals;
      private int rows = 0;
      
      private GoalHandler()
      {
            goals = getContent();
      }
      
      public static GoalHandler getGoalHandler()
      {
            if(instance == null)
            {
                  GoalHandler gh = new GoalHandler();
                  instance = gh;
            }
            return instance;
      }

      public int goalsByFootballer(int footballerID) //metoden tæller alle mål med matchende footballer id i arrayet og ligger dem sammen.
      {
            int count = 0;
            for(Goal i : goals)
            {
                  if (i.getGoalScorer() == footballerID)
                  {
                  count++;
                  }
            }
            return count;
      }
   
      public int assistsByFootballer (int footballerID)
      {
            int count = 0;
            for (Goal i : goals)
            {
                  if (i.getGoalAssistingPlayer() == footballerID)
                  {
                        count++;
                  }
            }
            return count;
      }
   
      public ArrayList<Integer> getGoalscorerByMatchID(ArrayList<Integer> getMatchIDInAPeriod)
      {
            ArrayList<Integer> goalScorers = new ArrayList<Integer>();
      
            for(Goal i : goals)
            {
                  if(getMatchIDInAPeriod.contains(i.getGoalMatchID()))
                  {
                        goalScorers.add(i.getGoalScorer());
                  }
            }
   
            return goalScorers;
      } 
   
      public int[] convertIntegers(List<Integer> integers) //https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
      {
            int[] ret = new int[integers.size()];
            Iterator<Integer> iterator = integers.iterator();
            for (int i = 0; i < ret.length; i++)
            {
                  ret[i] = iterator.next().intValue();
            }
            return ret;
      }

      public int[] sort(int goalScorers[])
      {
            for(int i=0;i<goalScorers.length;i++)
            {
                  for(int j=i;j<goalScorers.length;j++)
                  {
                        if(goalScorers[i]>goalScorers[j])
                        {
                              int sortedGoalscorer;
                              sortedGoalscorer = goalScorers[i];
                              goalScorers[i]=goalScorers[j];
                              goalScorers[j]=sortedGoalscorer; 
                        }
                  }
            }
            return goalScorers;
      }  

      public int[][] sort(int occurenceGoalscorers[][])
      {
            int sortedGoalscorers[] = new int[2];
      
            for(int i=0;i<rows;i++)
            {
                  for(int j=i;j<rows;j++)
                  {
                        if(occurenceGoalscorers[i][1]<occurenceGoalscorers[j][1])
                        {
                              sortedGoalscorers=occurenceGoalscorers[i];
                              occurenceGoalscorers[i]=occurenceGoalscorers[j];
                              occurenceGoalscorers[j]=sortedGoalscorers;
                        }
                  }
            }       
            return occurenceGoalscorers;
      }
   
      public int[][] getArrayWithGoalFrequencies(ArrayList<Integer> importedGoalScorers)
      {     
            int[] goalScorers = convertIntegers(importedGoalScorers);
            int occurenceGoalscorers[][] = new int[goalScorers.length][2];
      
            goalScorers = sort(goalScorers);
      
            occurenceGoalscorers[rows][0] = goalScorers[0];
      
            for(int i=1;i<goalScorers.length;i++)
            {
                  if(goalScorers[i] == goalScorers[i-1])
                  {
                        occurenceGoalscorers[rows][1] = (occurenceGoalscorers[rows][1] + 1);
                  }
                  else
                  {
                        rows++;
                        occurenceGoalscorers[rows][0]=goalScorers[i];
                  }
            }
            rows++;
      
            occurenceGoalscorers = sort(occurenceGoalscorers);
           
            return occurenceGoalscorers;
      }
   
      public int[][] getTopGoalscorers(int occurenceGoalscorers[][], int topX)
      {     
            int getTopScorers[][] = new int[topX][2];
      
            for(int i=0;i<topX;i++)
            {
                        getTopScorers[i][0] = occurenceGoalscorers[i][0];
                        getTopScorers[i][1] = occurenceGoalscorers[i][1] +1;                        
            }
            
      return getTopScorers;
      }
      /*    MatchHandler mh = MatchHandler.getMatchHandler();
            GoalHandler gh = GoalHandler.getGoalHandler();
            
            //System.out.println(mh.CleanSheetsByClub());
            LocalDate startDate = LocalDate.parse("2017-08-01");
            LocalDate endDate = LocalDate.parse("2017-12-01");
            
            int[][] doubleArray = gh.getArrayWithGoalFrequencies(gh.getGoalscorerByMatchID(mh.getMatchIDInAPeriod(startDate, endDate)));
            gh.getTopGoalscorers(doubleArray, 3);
        */ 
      public String getFilePath()
      {
            return "goal.csv";
      }
   
      public PersistentObjectHandler<Goal> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return 
            new PersistentObjectHandler<Goal>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
            {
                  public String lineFrom(Goal g)//PersistentObjectHandler kræver vi har denne metode, modtager et objekt og laver om til en String
                  {
                        return g.getID() 
                        + "," + g.getGoalMatchID()
                        + "," + g.getGoalScorer()
                        + "," + g.getGoalMinuteScored()
                        + "," + g.getGoalType()
                        + "," + g.getGoalAssistingPlayer();
                  }
         
                  public Goal objectFrom(String line)//PersistentObjectHandler kræver vi har denne metode, modtager en String og laver den om til et objekt og returnerer det
                  {
                        String[] components = line.split(",");
                        int id = Integer.parseInt(components[0]); //laver strings i arraylisten om til int.
                        int goalMatchID = Integer.parseInt(components[1]);
                        int goalScorer = Integer.parseInt(components[2]);
                        int goalMinuteScored = Integer.parseInt(components[3]);
                        char goalType = components[4].charAt(0);
                        int goalAssistingPlayer = Integer.parseInt(components[5]);                         
            
                  return new Goal(id, goalMatchID, goalScorer, goalMinuteScored, goalType, goalAssistingPlayer); //obretter er nyt object af footballer                      
                  }
            };
      }
   
      public void listGoals() //metode printer en liste med goals
      {           
            for(Goal i : goals)
            {
                  System.out.println(
                  i.getID() + " " + 
                  i.getGoalScorer() + " " + 
                  i.getGoalMatchID() + " "+ 
                  i.getGoalMinuteScored() + " " + 
                  i.getGoalType() + " " + 
                  i.getGoalAssistingPlayer());   
            }
      }
   
      public void deleteGoal(int id)//Metoden sletter et goal. Metoden kalder deleteObject i ObjectHandler med ArrayList goals og et goalID
      {
            deleteObject(goals, id);
      }
   
      public ArrayList<Goal> getGoalArray() //Metode der returnere et ArrayList goals
      {
            return goals;
      }
   
      public int getNewGoalID() //Metode der laver et nyt goalID. Metoden kalder getNewID med ArrayList goals
      {
            int newID= getNewID(goals);
            return newID;
      }
   
      public void createObject(int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, //Metode der opretter nyt goal objekt med nyt goalID
      int goalAssistingPlayer)
      {
            goals.add(new Goal(getNewGoalID(), goalMatchID, goalScorer, goalMinuteScored, goalType, goalAssistingPlayer));
            save(goals);
      }   
   
      public void updateObject(int goalID, int goalMatchID, int goalScorer, int goalMinuteScored, //Metode til at opdatere et goal objekt vha. set metoder
      char goalType, int goalAssistingPlayer)
      {
            for(Goal i : goals)
            {
                  if (i.getID() == goalID)
                  {
                        i.setGoalMatchID(goalMatchID);
                        i.setGoalScorer(goalScorer);
                        i.setGoalMinuteScored(goalMinuteScored);
                        i.setGoalType(goalType);
                        i.setGoalAssistingPlayer(goalAssistingPlayer);
                        save(goals);
                  }
            }
      }   
      
      public int getGoalsByClub()
      {
            int count = 0; 
            for(Goal i : goals)
            {
                  count++;
            }
            return count;
      }
}