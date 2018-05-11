package handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.time.LocalDate;
import models.*;

public class GoalHandler extends ObjectHandler<Goal>
{
      private static GoalHandler instance;
      private ArrayList<Goal> goals;
      private int rows = 0; //Bruges når der skal oprettes en- og to-dimensionelle arrays til TopX metoden.

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

      public int goalsByFootballer(int footballerID) //Fodboldspillerens unikke mål oprettet i goal.csv.
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

      public int assistsByFootballer (int footballerID) //Fodboldspillerens unikke assists oprettet i goal.csv
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
            int[] ret = new int[integers.size()]; //Vi opretter et 1-dimensionelt array der er lige så langt (length), som vores ArrayList(size()).
            Iterator<Integer> iterator = integers.iterator(); //Iterator laver en linje for hver gang der er en værdi.  (integers.iterator())
            for (int i = 0; i < ret.length; i++) //For hver linje i vores 1-dimensionelle array
            {
                  ret[i] = iterator.next().intValue(); //Tag værdien i iterator-listen og sæt den ind i ret[].
            }
            return ret;
      }

      public int[] sort(int goalScorers[]) //1-dimensionel bubblesort metode.
      {
            for(int i=0;i<goalScorers.length;i++) //For alle linjer i vores array
            {
                  for(int j=i;j<goalScorers.length;j++) //Skal vi udføre sorteringen indtil vi har været resten af linjerne i vores array igennem
                  {
                        if(goalScorers[i]>goalScorers[j]) //Hvis værdien af linje i er større end linje j (I dette tilfælde målscorerens ID)
                        {
                              int sortedGoalscorer;   //En midlertidig værdi, mens vi bytter rundt på to linjer
                              sortedGoalscorer = goalScorers[i]; //Den store værdi gemmes midlertidigt
                              goalScorers[i]=goalScorers[j]; //Den mindre værdi gemmes på den stores plads
                              goalScorers[j]=sortedGoalscorer;  //og den store værdi gemmes på den mindre værdis plads
                        }
                  }     //Eks. {2, 11, 26, 28, 26} Hvis 2>11 bytter de plads. Resultatet er {2, 11, 26, 26, 28}.
            }
            return goalScorers; //Den sorterede liste returneres
      }  

      public int[][] sort(int occurenceGoalscorers[][]) //2-dimensionel bubblesort metode
      {
            int sortedGoalscorers[] = new int[2];

            for(int i=0;i<rows;i++) //For hver gang vi opretterede en ny spiller i det 2-dimensionelle array
            {
                  for(int j=i;j<rows;j++) //Skal vi udføre sorteringen indtil vi har været resten af rækkerne igennem
                  {
                        if(occurenceGoalscorers[i][1]<occurenceGoalscorers[j][1]) //Bubblesort fungerer præcis som ovenfor. Vi kigger i 2. kolonne, da vi gerne vil sortere efter mål og ikke spiller ID
                        {
                              sortedGoalscorers=occurenceGoalscorers[i];
                              occurenceGoalscorers[i]=occurenceGoalscorers[j];
                              occurenceGoalscorers[j]=sortedGoalscorers;
                        }
                  }
            }       
            return occurenceGoalscorers; //Den sorterede liste returneres
      }
   
      public int[][] getArrayWithGoalFrequencies(ArrayList<Integer> importedGoalScorers) //Vi ønsker et 2-dimensionelt array med hhv. målscorerens ID og antallet af mål der er scoret.
      {     
            int[] goalScorers = convertIntegers(importedGoalScorers); //Vores ArrayList med Strings skal konverteres til Ints, før vi kan manipulere dem korrekt.
            int occurenceGoalscorers[][] = new int[goalScorers.length][2]; //Vi opretter et 2-dimensionelt array, lige så langt som antallet af mål i perioden.

            goalScorers = sort(goalScorers); //Vi bubblesorterer vores 1-dimensionelle liste af målscorere (se metoden ovenfor) 

            occurenceGoalscorers[rows][0] = goalScorers[0]; //Vores 2-dimensionelle array skal være lige så langt som antallet af målscorere

            for(int i=1;i<goalScorers.length;i++) //For hver linje i vores array
            {
                  if(goalScorers[i] == goalScorers[i-1]) //Hvis målscoreren vi kommer til, har samme værdi som sidste linje -> 
                  {
                        occurenceGoalscorers[rows][1] = (occurenceGoalscorers[rows][1] + 1); //Lægger vi 1 til i 2. kolonne.
                  }
                  else
                  {
                        rows++;
                        occurenceGoalscorers[rows][0]=goalScorers[i]; //Ellers går vi en række frem og lægger et nyt spiller ID ind i 1. kolonne
                  }
            }
            rows++; //Vores array starter på 0, så +1, for at få det rigtige antal gange der skal sorteres i bubblesort.

            occurenceGoalscorers = sort(occurenceGoalscorers); //Vi bubblesorterer vores 2-dimensionelle array (se metoden ovenfor)

            return occurenceGoalscorers; //Vi returnerer det sorterede 2-dimensionelle array
      }

      public int[][] getTopGoalscorers(int occurenceGoalscorers[][], int topX)
      {     
            int getTopScorers[][] = new int[topX][2];

            for(int i=0;i<topX;i++)
            {
                        getTopScorers[i][0] = occurenceGoalscorers[i][0];
                        if(getTopScorers[i][1] = 0) //Da vores Array naturligt starter på 0, skal vi lægge en til første gang, for at få det korrekte antal mål.
                        {
                              getTopScorers[i][1] = getTopScorers[i][1]+1;
                        }
                        else
                        {
                        getTopScorers[i][1] = occurenceGoalscorers[i][1] +1;
                        }
            }

      return getTopScorers;
      }
      
      public int[][] getTopGoalscorersByDate(int topX, LocalDate startDate, LocalDate endDate) //Vi samler metoderne til topX for en periode.
      {
            MatchHandler mh = MatchHandler.getMatchHandler();
            return getTopGoalscorers(getArrayWithGoalFrequencies(getGoalscorerByMatchID(mh.getMatchIDInAPeriod(startDate, endDate))), topX);
      }
       
      public String getFilePath()
      {
            return "goal.csv";
      }

      public PersistentObjectHandler<Goal> getHandler()//Returnerer en persistentObjectHandler for Goal.
      { 
            return
            new PersistentObjectHandler<Goal>()
            {
                  public String lineFrom(Goal g)//Vi går fra et objekt til en String.
                  {
                        return g.getID() 
                        + "," + g.getGoalMatchID()
                        + "," + g.getGoalScorer()
                        + "," + g.getGoalMinuteScored()
                        + "," + g.getGoalType()
                        + "," + g.getGoalAssistingPlayer();
                  }

                  public Goal objectFrom(String s)//Vi går fra String til object. Konverterer de forskellige Strings til rette type.
                  {
                        String[] components = s.split(",");
                        int id = Integer.parseInt(components[0]); 
                        int goalMatchID = Integer.parseInt(components[1]);
                        int goalScorer = Integer.parseInt(components[2]);
                        int goalMinuteScored = Integer.parseInt(components[3]);
                        char goalType = components[4].charAt(0);
                        int goalAssistingPlayer = Integer.parseInt(components[5]);                         

                        return new Goal(id, goalMatchID, goalScorer, goalMinuteScored, goalType, goalAssistingPlayer);
                  }
            };
      }

      public void listGoals() 
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
   
      public void deleteGoal(int id) 
      {
            deleteObject(goals, id);
      }

      public ArrayList<Goal> getGoalArray()
      {
            return goals;
      }

      public int getNewGoalID() //Når et nyt mål skal oprettes, skal vi have genereret et nyt ID.
      {
            int newID = getNewID(goals);
            return newID;
      }

      public void createObject(int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
      {
            goals.add(new Goal(getNewGoalID(), 
                              goalMatchID, 
                              goalScorer, 
                              goalMinuteScored, 
                              goalType, 
                              goalAssistingPlayer));
            save(goals);
      }   

      public void updateObject(int goalID, int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer)
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

      public ArrayList<Goal> getGoalsByMatchID(int matchID)
      {
            ArrayList<Goal> matchGoals = new ArrayList<Goal>();
            for(Goal i : goals)
            {
                  if (i.getGoalMatchID() == matchID)
                  {
                        matchGoals.add(i);
                  }      
            }
            return matchGoals;
      }
}