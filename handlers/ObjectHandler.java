package handlers;
import models.*;
import java.util.ArrayList;

public abstract class ObjectHandler<T extends Model> //T kan være enhver type af objekter som extender Object klassen "den som findes i forevejen"
{
      public abstract String getFilePath(); //Metode der skal implementeres af klasser som nedarver fra klassen. Denne metode returnerer en String
      public abstract PersistentObjectHandler<T> getHandler(); //metode der skal implemteres af klasser som nedarver fra klassen. Denne medtode returnere et interface      
      
      
      public void createObject()
      {
      
      } //laver et nyt object
      public void updateObject()  //opdaterer et object
      {
      
      }
      
      public void deleteObject(ArrayList<T> list, int id)//Sletter det objekt der har implementeret interfacet model i arraylisten med det medfølgende id og kalder save med den nye liste
      {
            for(Model i : list)
            {
                  if (i.getID() == id)
                  {
                        list.remove(i);
                        save(list);
                        break;
                  }
            }
      }
      
      public int getNewID(ArrayList<T> list)
      {
            int lastID = 0;
            for(Model i : list)
            {
                  if(lastID < i.getID())
                  {
                        lastID = i.getID();
                  }
            }
            lastID++;
            return lastID;
      }
      
      public ArrayList<T> getContent() //metode der nedarves hvis ikke de overskrives i subklassen. Returnerer en ArrayList der indeholder objekter T
      {
            return FileHandler.getContent(getFilePath(), getHandler());//Da klassen lover supklasserne har disse to metoder, kan vi kalde dem herfra.
      }
      
      public void save(ArrayList<T> list) //metode der nedarves hvis ikke de overskrives i subklassen. Returnerer ikke noget. Har en ArrayList med objekter af T der hedder "lis" som parameter.
      {
            FileHandler.save(getFilePath(), list, getHandler());
      }
}
