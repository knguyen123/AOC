import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class day4{
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
      while(b){
         if(f1.hasNext())
            n = f1.next();
         System.out.println(n);
         for(int i = 0; i < l.size(); i++){
            
            l.get(i).contains(n);
         }
         
         for(int i = 0; i < l.size(); i++){
            if(l.get(i).isBingo()){
               
               b = false;
               break;
            }
         }
      }   
   }
}
class TwoDArr{
   private String[][] arr;
   
   public TwoDArr(String[][] a){
      arr = a;
   }
   public void contains(String s){
      for(int r = 0; r<5; r++){
         for(int c = 0; c<5; c++){
            if(arr[r][c].equals(s)){
               arr[r][c]+= "x";
               return;
            }
         }
         
      }
   } 
   
   public boolean isBingo(){
      boolean isB = true;
      
      for(int r = 0; r<5; r++){
         for(int c = 0; c<5; c++){
            if(arr[r][c].indexOf("x")==-1){
               isB = false;
               break;
            } 
         } 
         if(isB){
            print();
            return true;
         }else{
            isB = true;
         }  
      }
      
      for(int c = 0; c<5; c++){
         for(int r = 0; r<5; r++){
            if(arr[r][c].indexOf("x")==-1){
               isB = false;
               break;
            } 
         } 
         if(isB){
            print();
            return true;
         }else{
            isB = true;
         }  
      }
      
      return false;
   }
   public void print(){
      for(int r = 0; r<5; r++){
        for(int c = 0; c<5; c++){
            System.out.print(arr[r][c]+" ");
        } 
        System.out.println();     
      }
      System.out.println();  
   }
}