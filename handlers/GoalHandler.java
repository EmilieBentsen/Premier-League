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
      private int rows = 0; //Bruges n�r der skal oprettes en- og to-dimensionelle arrays til TopX metoden.

      private GoalHandler()/*Metoden er til fordi vi gerne vil v�re sikker p� at der kun er en instans af klassen. 
      Derfor har vi overskrevet default konstruktoren med en private konstruktor, som vi kalder i metoden getGoalHandler, 
      i det tilf�lde der ikke allerede findes en instans. Dette er en Singleton l�sning. goals ArrayList fyldes op med 
      obejkter lavet fra filen goals.csv*/
      {
            goals = getContent();
      }
             
      public String getFilePath() //filen vi gemmer vores m�l i
      {
            return "goal.csv";
      }

      public static GoalHandler getGoalHandler() //metode der returnerer en instans af GoalHandler
      {
            if(instance == null) //tjekker om der er lavet en instans af klassen
            {
                  GoalHandler gh = new GoalHandler();
                  instance = gh;
            }
            return instance;
      }

      public int goalsByFootballer(int footballerID) //Fodboldspillerens unikke m�l oprettet i goal.csv.
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

      public ArrayList<Integer> getGoalscorerByMatchID(ArrayList<Integer> getMatchIDInAPeriod)//returnerer et AL af m�lscorere der har scoret m�l i en periode 
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
            int[] ret = new int[integers.size()]; //Vi opretter et 1-dimensionelt array der er lige s� langt (length), som vores ArrayList(size()).
            Iterator<Integer> iterator = integers.iterator(); //Iterator laver en linje for hver gang der er en v�rdi.  (integers.iterator())
            for (int i = 0; i < ret.length; i++) //For hver linje i vores 1-dimensionelle array
            {
                  ret[i] = iterator.next().intValue(); //Tag v�rdien i iterator-listen og s�t den ind i ret[].
            }
            return ret;
      }

      public int[] sort(int goalScorers[]) //1-dimensionel bubblesort metode.
      {
            for(int i=0;i<goalScorers.length;i++) //For alle linjer i vores array
            {
                  for(int j=i;j<goalScorers.length;j++) //Skal vi udf�re sorteringen indtil vi har v�ret resten af linjerne i vores array igennem
                  {
                        if(goalScorers[i]>goalScorers[j]) //Hvis v�rdien af linje i er st�rre end linje j (I dette tilf�lde m�lscorerens ID)
                        {
                              int sortedGoalscorer;   //En midlertidig v�rdi, mens vi bytter rundt p� to linjer
                              sortedGoalscorer = goalScorers[i]; //Den store v�rdi gemmes midlertidigt
                              goalScorers[i]=goalScorers[j]; //Den mindre v�rdi gemmes p� den stores plads
                              goalScorers[j]=sortedGoalscorer;  //og den store v�rdi gemmes p� den mindre v�rdis plads
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
                  for(int j=i;j<rows;j++) //Skal vi udf�re sorteringen indtil vi har v�ret resten af r�kkerne igennem
                  {
                        if(occurenceGoalscorers[i][1]<occurenceGoalscorers[j][1]) //Bubblesort fungerer pr�cis som ovenfor. Vi kigger i 2. kolonne, da vi gerne vil sortere efter m�l og ikke spiller ID
                        {
                              sortedGoalscorers=occurenceGoalscorers[i];
                              occurenceGoalscorers[i]=occurenceGoalscorers[j];
                              occurenceGoalscorers[j]=sortedGoalscorers;
                        }
                  }
            }       
            return occurenceGoalscorers; //Den sorterede liste returneres
      }
   
      public int[][] getArrayWithGoalFrequencies(ArrayList<Integer> importedGoalScorers) //Vi �nsker et 2-dimensionelt array med hhv. m�lscorerens ID og antallet af m�l der er scoret.
      {     
            int[] goalScorers = convertIntegers(importedGoalScorers); //Vores ArrayList med Strings skal konverteres til Ints, f�r vi kan manipulere dem korrekt.
            int occurenceGoalscorers[][] = new int[goalScorers.length][2]; //Vi opretter et 2-dimensionelt array, lige s� langt som antallet af m�l i perioden.

            goalScorers = sort(goalScorers); //Vi bubblesorterer vores 1-dimensionelle liste af m�lscorere (se metoden ovenfor) 

            occurenceGoalscorers[rows][0] = goalScorers[0]; //P� plads nummer "0"(rows=0) inds�ttes nu v�rdien af f�rste v�rdien af goalscorer. 

            for(int i=1;i<goalScorers.length;i++) //For hver linje i vores array
            {
                  if(goalScorers[i] == goalScorers[i-1]) //Hvis m�lscoreren vi kommer til, har samme v�rdi som sidste linje -> 
                  {
                        occurenceGoalscorers[rows][1] = (occurenceGoalscorers[rows][1] + 1); //L�gger vi 1 til i 2. kolonne.
                  }
                  else
                  {
                        rows++;
                        occurenceGoalscorers[rows][0]=goalScorers[i]; //Ellers g�r vi en r�kke frem og l�gger et nyt spiller ID ind i 1. kolonne
                        occurenceGoalscorers[rows][1]=(occurenceGoalscorers[rows][1]+1); //Et array starter p� 0. Men et registreret m�l skal t�lle for 1.
                  }
            }
            rows++; //Vores array starter p� 0, s� +1, for at f� det rigtige antal gange der skal sorteres i bubblesort.

            occurenceGoalscorers = sort(occurenceGoalscorers); //Vi bubblesorterer vores 2-dimensionelle array (se metoden ovenfor)

            return occurenceGoalscorers; //Vi returnerer det sorterede 2-dimensionelle array
      }

      public int[][] getTopGoalscorers(int occurenceGoalscorers[][], int topX)
      {     
            int getTopScorers[][] = new int[topX][2];

            for(int i=0;i<topX;i++)
            {
                        getTopScorers[i][0] = occurenceGoalscorers[i][0];
                        getTopScorers[i][1] = occurenceGoalscorers[i][1];
            }

      return getTopScorers;
      }
      
      public int[][] getTopGoalscorersByDate(int topX, LocalDate startDate, LocalDate endDate) //Vi samler metoderne til topX for en periode.
      {
            MatchHandler mh = MatchHandler.getMatchHandler();
            return getTopGoalscorers(getArrayWithGoalFrequencies(getGoalscorerByMatchID(mh.getMatchIDInAPeriod(startDate, endDate))), topX);
      }

      public PersistentObjectHandler<Goal> getHandler()//Returnerer en persistentObjectHandler for Goal.
      { 
            return
            new PersistentObjectHandler<Goal>()
            {
                  public String lineFrom(Goal g)//Vi g�r fra et objekt til en String.
                  {
                        return g.getID() 
                        + "," + g.getGoalMatchID()
                        + "," + g.getGoalScorer()
                        + "," + g.getGoalMinuteScored()
                        + "," + g.getGoalType()
                        + "," + g.getGoalAssistingPlayer();
                  }

                  public Goal objectFrom(String s)//Vi g�r fra String til object. Konverterer de forskellige Strings til rette type.
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
   
      public void deleteGoal(int id) //metode der sletter et m�l 
      {
            deleteObject(goals, id);
      }

      public ArrayList<Goal> getGoalArray() //metode der returnerer goals
      {
            return goals;
      }

      public int getNewGoalID() //N�r et nyt m�l skal oprettes, skal vi have genereret et nyt ID.
      {
            int newID = getNewID(goals);
            return newID;
      }
      //metode til at oprette et m�l
      public void createObject(int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer) //opretter et nyt m�l objekt
      {
            goals.add(new Goal(getNewGoalID(), 
                              goalMatchID, 
                              goalScorer, 
                              goalMinuteScored, 
                              goalType, 
                              goalAssistingPlayer));
            save(goals);
      }   
      //metode til at opdatere et m�l
      public void updateObject(int goalID, int goalMatchID, int goalScorer, int goalMinuteScored, char goalType, int goalAssistingPlayer) //opdaterer et m�l objekt
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

      public int getGoalsByClub() //metode der t�ller hvor mangen m�l klubben har scoret ialt
      {
            int count = 0; 
            for(Goal i : goals)
            {
                  count++;
            }
            return count;
      }

      public ArrayList<Goal> getGoalsByMatchID(int matchID) //metode der returnerer et AL med de m�l der er scoret i en given kamp
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