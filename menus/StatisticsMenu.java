package menus;

public class StatisticsMenu
{
      public void statisticsMenu()
      {
            /* Printer menu header (You'll never walk alone" box + Menu navn/overskift).
            Printer menuoversigt("1. Top 3 scorer, 2. FootBaller, 3. Club, 4. Match)
            K�rer input metode der printer prompts for input.
            K�r metoder i baseret p� input.
            Hvis input = 1 : topThreeScorer();
            Hvis input = 2 : foootballerStatistics();
            Hvis input = 3 : clubStatistics();
            Hvis input = 4:  matchStatistics();
            */
      }
      
      public void topThreeScorer()
      {
            //k�r input metode til at f� en periode, kald top3scorer() med input som parameter.
            //skal kalde startMenu() hvis den metoder et bestemt input for brugeren.      
      }
      
      public void foootballerStatistics()
      {
           /* Printer liste af fodboldspilerer, k�rer input metode om at f� et JerseynNumber,
            og prnter spiller oplysinger fo den valgte spiller (visningaf spiller information kommer til at 
            blive en "sp�ndende" metode)
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/
                  
      }
      
      public void clubStatistics()
      {
            /*???(hvilken statistik skal man kunne f� om klubben? skal det v�re for en given periode?
            Skal den altid vise den samme sk�rm?).*/
      }
      
      public void matchStatistics()
      {
            /*(evt. prompt bruger til at indtaste periode) Print liste over kampe brugeren kan v�lge 
            mellem, k�r input metode der beder om at f� et match id for en af de viste matches.
            Kald metode der tager imod en Match/MatchID, og viser detaljerede information baseret 
            om p�g�ldende match.
            skal kalde startMenu() hvis den metoder et bestemt input for brugeren.*/      
      }      
}