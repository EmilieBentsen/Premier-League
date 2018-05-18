package handlers;//Taget fra et eksempel, fra undervisningen

public interface PersistentObjectHandler<T extends Object> //T kan være enhver type af objekter som extender Object klassen 
{
      public String lineFrom(T t); //metode der skal implementeres. returnerer en string og tager et objekt ind
      public T objectFrom(String line); //metode der skal implementeres. returnerer et object T og tager en String "line" ind
}