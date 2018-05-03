package handlers;
import java.util.Scanner;
import java.io.*;

public class FileHandler
{     
      public static final String FOOTBALLER_TXT = "footballer.txt"; // Skal disse 4 filer ikke ligge i deres handlers?
      public static final String GOAL_TXT = "goal.txt";
      public static final String OPPONENT_TXT = "opponent.txt";
      public static final String MATCH_TXT = "match.txt";

      public static String getFileContent(String path)
      {
            String content = "";
            
            try
            {
                  Scanner sc = new Scanner(new File(path));
                  
                  content += sc.nextLine();
                  
                  while(sc.hasNextLine())
                  {
                        content += '\n' + sc.nextLine();
                  }
            }
            catch (FileNotFoundException e)
            {
                  System.out.println("File not found.");
            }
            
            return content;
      }
      
      public static void writeFileContent(String path, String content)
      {     
            try
            {
                  PrintStream output = new PrintStream(new File(path));
                  output.print(content); 
            }
            catch (FileNotFoundException e)
            {
                  System.out.println("Cannot access file: " + path);
            }
      }
}