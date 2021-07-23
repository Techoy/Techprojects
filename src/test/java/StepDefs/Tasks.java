package StepDefs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tasks {

    public static boolean checkLetters (String str1, String str2){
        char [] letter=str1.toCharArray();
        char [] letter2=str2.toCharArray();
        boolean string=false;

        for(int i=0; i<letter.length; i++){
            for(int y=0; y<letter2.length; y++){
                if(letter[i]==letter2[y]){
                    string=true;
                }
            }
        }

        return string;


    }
    public static Set removeDuplicates (String str1, String str2) {
        char[] letter = str1.toCharArray();
        char[] letter2 = str2.toCharArray();
        Set unique = new HashSet();


        for (int i = 0; i < letter.length; i++) {
            for (int y = 0; y < letter2.length; y++) {
                if (letter[i] == letter2[y]) {
                    unique.add(letter[i]);
                }
            }
        }

        return unique;
    }

        public static String [] countLetters(String str1){
                   String [] str3= new String[str1.length()];
                   int count=0;
                   String str2="";
                  for(int i=0; i<str3.length; i++){
                      for(int y=0; y<str3.length; y++){
                          if(str3[i]==str3[y]){
                              count++;
                          }
                      }





                      Arrays.toString(str3);
                    }
            return str3;


    }

    public static void main(String[] args) {
        Tasks task=new Tasks();
        System.out.println(task.checkLetters("fad", "daf"));
        System.out.println(task.removeDuplicates("abcc", "abc"));
        System.out.println(task.countLetters("Eliza"));
        System.out.println(task.countLetters("Elkhan"));
    }

}
