
//package notepad;

import java.awt.Color;
import java.util.ArrayList;



public abstract  class EditOperations {
    
    
      public static void find(String word,Zone zone,int order){
                
                String text = zone.getText();
                ArrayList<Integer>  indexes = EditOperations.getIndexesOfWord(word, text);
                    int index = 0;
                    zone.requestFocus();
                    zone.select(indexes.get(order-1), indexes.get(order-1) + word.length());
      }
      
      public static void replaceSelected(Zone zone,String word,String newWord){
           String text = zone.getText();
           int order = Window.order;
           int indx = (int) getIndexesOfWord( word, text).get(order-1);
           String substr = text.substring(indx, indx+word.length());
           String result = text.substring(0,indx)+newWord+text.substring(indx+word.length());
           zone.setText(result);
      }
      
      public static void replaceAllSelected(Zone zone,String word,String newWord){
          
          ArrayList<Integer> indexes;
          while((int)(indexes = EditOperations.getIndexesOfWord(word, zone.getText())).size()!=0){
                   EditOperations.replaceSelected(zone, word, newWord);
          }
      }
      
      
      public static String replace(String word,String newWord,String txt){
          return  txt.replaceAll(word, newWord);
      }
      
      public static  ArrayList getIndexesOfWord(String word,String text){
             
          int currentIndex = 0;
          ArrayList<Integer> indexes = new ArrayList<>();
          while((currentIndex = text.indexOf(word, currentIndex)) !=-1){
                  indexes.add(currentIndex);
                  currentIndex+=word.length();
          }
          return indexes;
           
      }
      
}
