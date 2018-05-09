import models.*;
import handlers.*;
import java.util.*;
import java.time.LocalDate;

public class Main
{
      public static void main(String[]args)
      {

            
            UserHandler uh = UserHandler.getUserHandler();
            
            System.out.print(uh.verifyAdmin("LasseMis", "FlopFlip"));         
            

      }
}