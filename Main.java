import models.*;
import handlers.*;
import java.util.*;

public class Main
{
      public static void main(String[]args)
      {
            //FileHandler fh = new FileHandler();
            //fh.writeFileContent("goal_backup.txt", fh.getFileContent(fh.GOAL_TXT));
            System.out.println(FileHandler.getFileContent(FileHandler.OPPONENT_TXT));
/*            Opponent o = new Opponent(01, "Arsenal");
            OpponentHandler.updateOpponent(o);
  */    }
}