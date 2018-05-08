package menus;

public class AdminMatchMenu
{
      public void adminMatchMenu()
      {
            /* Printer menu header (You'll never walk alone" box + Menu navn/overskift).
            Printer menu oversigt(1. Create Future Match, 2. Update Match, 3. Opponent).
            Kører input metode til at få en int i mellem 1-3.
            Hvis input = 1 : createFutureMatch();            
            */
      }
      
      public void createFutureMatch()
      {
            /*Prompt bruger for følgende input: MatchDate(skal være sikker
            på at datoen ikke ligger i fortiden) , Opponent (print liste),Home or away. Lav ny kamp med de 
            indtastede parametre.
            adminMenu();*/
            

      }
      
      public void updateMatch()
      {
            /*
            Prompter for indtastning af to datoer i date format.
            Printer liste af kampe spillet inden for de indtastede datoer.
            Prompter bruger til at vælge en af disse kampe.
            prompter om man vil ændre dato (Ja/nej), hvis input = Ja: prompt for ny dato.
            prompter om man vil ændre modstander(Ja/Nej), hvis input = Ja: print liste over gyldige modstandere
            og prompt for valg af modstander.
            prompter om man vil ændre ude/hjemme status(Ja/Nej), hvis input = Ja: ændre home til away eller 
            omvendt
            prompter om man vil ændre resultatet af kampen (Ja/Nej),hvis input = Ja: prompter for indtastning
            af nyt resultat. H
            Hvis nyt resulat har færre Liverpool mål end det originale: generer liste over mål
            scoret af liverpool i kampen, prompter for hvilken af dem der skal slettes, gentages indtil at 
            mængden af mål stemmer overens med det nye resultat. 
            Hvis nyt resultat har flere liverpool mål end originalt: skal der kaldes metode til at oprette mål,
            gentages indtil at mængden af mål stemmer overns med resultatet. 
            prompter om der skal ændres i formation (Ja/Nej), Hvis input = Ja: prompt for ny formation.
            prompter for om der skal ændres i lineup(Ja/Nej), Hvis input er = Ja: prompt for nyt line up.
            den valgte match ændres baseret på brugerens indtasninger og gemmes.
            adminMenu();
            */     
      }
      
      public void typeInResult()
      {
            /* generer liste over endnu ikke spillede kampe, og prompter bruger til at vælge en.
            prompter bruger for at indtaste kampens resultat, Hvis liverpool har scoret mål kaldes 
            userCreateGoal()for hvert mål socret af liverpool.
            prompter for indtastning af formation.
            prompter for indtastning af lineup.
            kampen opdateres med de indtastede informationer.
            adminMenu();*/
      }
      
}