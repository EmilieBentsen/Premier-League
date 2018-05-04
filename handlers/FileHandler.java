package handlers;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class FileHandler
{
      public static <E extends Object> void save(String path, ArrayList<E> list, 
            PersistentObjectHandler<E> handler)  //E kan være enhver type af objekter som extender Object klassen
                                                //metoden returnerer ikke noget. Den tager en String og en Arraylist med objekter E som parameter.
      {
            try
            {
                  boolean firstElement = true;
                  Scanner sc = new Scanner(new File(path));
                  String header = sc.nextLine();
                  PrintStream output = new PrintStream(new File(path)); 
                  output.println(header);
                  
                  for(E element : list)
                  {
                        if(!firstElement) output.print('\n');
                        else firstElement = false;
                        output.print(handler.lineFrom(element));
                  }
            }
            catch(FileNotFoundException e)
            {
            
            }
      }
      
      public static <E extends Object> ArrayList<E> getContent(String path, 
            PersistentObjectHandler<E> handler) //metoden bruger en string og klassen PersistentObjectHandler<E> handler, som parameteter og returnerer en arraylist
      {
            ArrayList<E> list = new ArrayList<E>();
            try
            {
                  Scanner sc = new Scanner(new File(path));
                  sc.nextLine();
                  while(sc.hasNextLine())
                  {
                        E object = handler.objectFrom(sc.nextLine());
                        list.add(object);
                  }
            }
            catch(FileNotFoundException e)
            {
            
            }
            return list;
      }
}