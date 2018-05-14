package menus;

public class AdminOpponentMenu
{
      Output output = new Output();
      AdminMenu adminMenu = new AdminMenu();
      
      OpponentHandler opponentHandler = OpponentHandler.getOpponentHandler();
      
      public void adminOpponentMenu()
      {
            output.adminOpponentMenu();//ikke lavet
            int choice = input.getInt(1,2);
            switch(choice)
            {
                  case 1 :    updateOpponentMenu();
                              break;
                              
                  case 2 :    createNewOpponentMenu();
                              break;              
            }
            /*Skal print menuoversigt: 1. Update Opponent Information, 2.Create Opponent*/
      }
      
      public void updateOpponentMenu()
      {
            ArrayList<Opponent> opponents = opponentHandler.getOpponentArray();
            output.printOpponentList(opponents);
            output.promptOpponent();           
            Opponnent chosenOpponent = input.getOpponentByList(opponents);//ikke lavet
            output.changeOpponentName();
            int choice = input.getInt(1,2);
            
            switch(choice)
            {
                  case 1 :    output.promptOpponentName();//ikke lavet
                              String newOpponentName = input.getString();
                              chosenOpponent.setOpponentName(newOpponentName);
                              break;
                              
                  case 2 :    break;                                          
            }
            
            output.changeOpponentActive();//ikke lavet
            int choice = input.getInt(1,2);
            
            switch(choice)
            {
                  case 1 :    output.promptOpponentActice();
                              int ative = input.getInt(1,2);
                              if(active == 1)
                              {
                                    chosenOpponent.setOpponentActive(true);
                              }
                              else
                              {
                                    chosenOpponent.setOpponentActive(false);
                              }
                              break;
                              
                  case 2 :    break;
            }
            
            output.confirmationOnUpdateOpponent(chosenOpponent);//ikke lavet
            input.getInt(5);
            adminMenu.adminMenu();
            /* 
            skal Printe liste af alle modstandere.
            skal prompte bruger til at vælge en modstander fra listen.
            Prompter bruger om man vil ændre Opponent Name(Ja/Nej)Hvis input = Ja: Prompt for nyt navn.
            Prompter bruger for om man vil ændre "Active Status"(Ja/nej) Hvis input = Ja, ændre værdi af valgt
            opponents boolean, evt. kunne den nye status blive printet så brugeren kan se at der sker noget.
            */
      }
      
      public void createNewOpponentMenu()
      {
            output.inputOpponentName();
            String opponentName = input.getString();
            output.promptOpponentActice();
            int isActive = getInt(1,2);
            boolean active = null;
            
            if(isActive == 1)
            {
                  active =true;
            }
            else
            {
                  active = false;
            }
            
            Opponent newOpponent = new Opponent();
            opponentHandler.createObject(opponentName, active);
            output.confirmationOnUpdateOpponent(opponentName, active);//ikke lavet
            input.getInt(5);
            adminMenu.adminMenu();           
      }
}