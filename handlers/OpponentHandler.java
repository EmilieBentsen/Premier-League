package handlers;

import models.Opponent;
import handlers.FileHandler;
import java.util.Scanner;

public class OpponentHandler
{     
      public static void updateOpponent(Opponent o)
      {
            String content = FileHandler.getFileContent(FileHandler.OPPONENT_TXT);
            Scanner sc = new Scanner(content);
            
            String newContent = sc.nextLine() + '\n';
            boolean firstLine = true;
            
            while (sc.hasNextLine())
            {
                  
                  int opponentID = sc.nextInt();
                  String opponentName = sc.nextLine();
                  
                  if (!firstLine) newContent += '\n';
                  else
                  {
                        firstLine = false;
                  }
                  
                  if (opponentID != o.getOpponentID())
                  {     
                        newContent += opponentID + opponentName;
                  }
                  else
                  {
                        newContent += o.toString(o);
                  }
            }
            FileHandler.writeFileContent(FileHandler.OPPONENT_TXT, newContent);
            System.out.println("Opponent #"+o.getOpponentID()+" changed name to "+ o.getOpponentName());
            }
}