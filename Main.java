import models.*;
import handlers.*;
import java.util.*;

public class Main
{
      public static void main(String[]args)
      {
            //FileHandler fh = new FileHandler();
            //fh.writeFileContent("goal_backup.txt", fh.getFileContent(fh.GOAL_TXT));
            //System.out.println(ileHandler.getFileContent(FileHandler.OPPONENT_TXT));
      
            /*FootballerHandler fh = new FootballerHandler();
            fh.listFootballers();*/
            
            OpponentHandler oh = new OpponentHandler();
            oh.listOpponents();
      }
}