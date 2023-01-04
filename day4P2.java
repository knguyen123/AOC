import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class day4P2{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("bingo.txt"));
      String s = f.nextLine();
      Scanner f1 = new Scanner(s);
      String n = "";
      String[][] arr = new String[5][5];
      ArrayList<TwoDArr> l = new ArrayList<>();
      boolean b = true;
      while(f.hasNext()){  
         for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
               arr[r][c] = f.next();
            }
         }
         
         l.add(new TwoDArr(arr));
         arr = new String[5][5];
      }
      while(l.size()>0){
         if(f1.hasNext())
            n = f1.next();
         System.out.println(n);
         for(int i = 0; i < l.size(); i++){
            
            l.get(i).contains(n);
         }
         
         for(int i = l.size()-1; i >= 0; i--){
            if(l.get(i).isBingo()){
               l.remove(i);  

            }
         }
      }   
   }
}
