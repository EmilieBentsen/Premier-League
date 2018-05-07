import models.*;
import handlers.*;
import java.util.*;
import java.time.LocalDate;

public class Main
{
      public static void main(String[]args)
      {
            MatchHandler mh = new MatchHandler();            
            //System.out.println(mh.CleanSheetsByClub());
            System.out.println(mh.CleanSheetsByFootballer("1"));

      }
}