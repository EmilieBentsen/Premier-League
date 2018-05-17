package handlers;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class FileHandler
{
      public static <E extends Object> void save(String path, ArrayList<E> list, PersistentObjectHandler<E> handler)  
           //E kan være enhver type af objekter som extender Object klassen
           //metoden tager en FilePath ind og en Arraylist af objekter E som parameter, og skriver ArrayListen til den fil der har filepathen
      {
            try
            {
                  boolean firstElement = true;
                  Scanner sc = new Scanner(new File(path));
                  String header = sc.nextLine();//For at vi kan have en forklarende overskrift i vores filer, her læses den og gemmes i en variabel inde den overskrives 
                  PrintStream output = new PrintStream(new File(path)); 
                  output.println(header);//Overskriften skrives på filen
                  
                  for(E element : list)//Arraylisten skrives på filen
                  {
                        if(!firstElement) output.print('\n'); //linjeskift hvis det første element i objektet 
                        else firstElement = false;
                        output.print(handler.lineFrom(element));//den medsendte PersistentObjectHandler beskriver hvordan objektet skal skrives til filen
                  }
            }
            catch(FileNotFoundException e)
            {
                  System.out.println("File not found.");
            }
      }
      
      public static <E extends Object> ArrayList<E> getContent(String path, PersistentObjectHandler<E> handler)
            //metoden læser fra en fil på placeringen path, klassen PersistentObjectHandler<E> beskriver hvordan objektet skal oprettes.
            //objekterne gemmes i en ArrayList, som returnres
      {
            ArrayList<E> list = new ArrayList<E>();
            try
            {
                  Scanner sc = new Scanner(new File(path));
                  sc.nextLine();
                  while(sc.hasNextLine())
                  {
                        E object = handler.objectFrom(sc.nextLine());//opretter et objekt, som beskrevet i PersistentObjectHandler 
                        list.add(object); //tilføjer objektet i Arraylisten list
                  }
            }
            catch(FileNotFoundException e)
            {
                  System.out.println("File not found.");
            }
            return list;
      }
}