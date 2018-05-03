package handlers;

public class GoalHandler
{
      public int GoalsByFootballer(ArrayList<Goal> list, int footballerID) //metoden tæller alle mål med matchende footballer id i arrayet og ligger dem sammen.
      {
            int count;
            for(goal i : list)
            {
                   if (i.getID() == id)
                  {
                        count++;
                  }
            }
            return count;
      }
}