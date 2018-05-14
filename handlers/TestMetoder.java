package handlers;

import menus.*;



public class TestMetoder
{
      public static void main(String[] args)
      {
      
            Input input = new Input();
            int result = 0;
            String formation = input.getString();
            String[] stringArrayLineup = formation.split("-");
            int[] intArrayLineup = new int[stringArrayLineup.length];
            try{
                  for (int i = 0; i < stringArrayLineup.length; i++) 
                  {
                        String numberAsString = stringArrayLineup[i];
                        intArrayLineup[i] = Integer.parseInt(numberAsString);
                        result = result + intArrayLineup[i];
                  }
            }
            catch(NumberFormatException e)
            {
                  System.out.println("Invalid formation format.");
            }
            if(result == 10)
            {
                  System.out.print("Valid formation.");
            }
            else
            {
                  System.out.print("Invalid formation. You've got "+ (result + 1) +" players in your starting formation.");
            }
      }
}