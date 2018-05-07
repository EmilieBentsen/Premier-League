package handlers;

import java.util.ArrayList;
import models.*;

public class GoalHandler extends ObjectHandler<Goal>
{
      private ArrayList<Goal> goals = getContent();

      public int GoalsByFootballer(int footballerID) //metoden tæller alle mål med matchende footballer id i arrayet og ligger dem sammen.
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
      
      public int AssistsByFootballer (int footballerID)
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
      
      /*public Arraylist listGoalsByPeriod(LocalDate startDate, LocalDate endDate)
      {
                 
      }*/
      
      /*public ArrayList listTopThreeGoalScorers(LocalDate startDate, LocalDate endD)
      {
            int numberOfCounts = goals.size();
      }*/
            
      public String getFilePath()
      {
            return "goal.csv";
      }
      
      public PersistentObjectHandler<Goal> getHandler()//Returnerer en persistentObjectHandler med objectet Hamster
      {
            return new PersistentObjectHandler<Goal>()//dette er faktisk en klasse der implementerer PersistentObjectHandler der bliver returneret
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
                  System.out.println(i.getID() + " " + i.getGoalScorer() + " " + i.getGoalMatchID() + " "
                  + i.getGoalMinuteScored() + " " + i.getGoalType() + " " + i.getGoalAssistingPlayer());   
            }
      }
      
      public void deleteGoal(int id)//Metoden sletter et goal. Metoden kalder deleteObject i ObjectHandler med ArrayList goals og et goalID
      {
            deleteObject(goals, id);
      }
      
      public ArrayList getGoalArray() //Metode der returnere et ArrayList goals
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
}