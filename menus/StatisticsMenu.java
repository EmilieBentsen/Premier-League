package menus;

public class StatisticsMenu
{
      public void statisticsMenu()
      {
            /* Printer menu header (You'll never walk alone" box + Menu navn/overskift).
            Printer menuoversigt("1. Top 3 scorer, 2. FootBaller, 3. Club, 4. Match)
            Kører input metode der printer prompts for input.
            Kør metoder i baseret på input.
            Hvis input = 1 : topThreeScorer();
            Hvis input = 2 : foootballerStatistics();
            Hvis input = 3 : clubStatistics();
            Hvis input = 4:  matchStatistics();
            */
      }
      
      public void topThreeScorer()
      {
            //kør input metode til at få en periode, kald top3scorer() med input som parameter.
            //skal kalde startMenu() hvis den metoder et bestemt input for brugeren.      
      }
      
      public void foootballerStatistics()
      {
           /* Printer liste af fodboldspilerer, kører input metode om at få et JerseynNumber,
            og prnter spiller oplysinger fo den valgte spiller (visningaf spiller information kommer til at 
            blive en "spændende" metode)
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/
                  
      }
      
      public void clubStatistics()
      {
            /*???(hvilken statistik skal man kunne få om klubben? skal det være for en given periode?
            Skal den altid vise den samme skærm?).*/
      }
      
      public void matchStatistics()
      {
            /*(evt. prompt bruger til at indtaste periode) Print liste over kampe brugeren kan vælge 
            mellem, kør input metode der beder om at få et match id for en af de viste matches.
            Kald metode der tager imod en Match/MatchID, og viser detaljerede information baseret 
            om pågældende match.
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/      
      }      
}