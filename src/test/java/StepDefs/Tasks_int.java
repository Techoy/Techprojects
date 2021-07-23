package StepDefs;

import java.util.ArrayList;

public class Tasks_int {

    String [][] myArray1;


    public int myArray(String [][] myArray){
        this.myArray1=myArray;
         int count=0;
        for(int i=0; i<myArray.length; i++){
            for(int y=0; y<myArray[i].length; y++){
                if (myArray[i][y].contains("Fox")){
                    count++;
                }
            }
        }
        return count;
    }

    public ArrayList reversed(ArrayList arrayList){
        ArrayList reversed=new ArrayList();

        for(int i=arrayList.size()-1; i>=0; i--){
           reversed.add(arrayList.get(i));

        }
        return reversed;
    }

    public static void main(String[] args) {
        String [][] myArray1={{"Apple", "Banana", "FoxNews"},{"Pork", "Beef", "FoxSports"}};
        Tasks_int obj=new Tasks_int();
        System.out.println(obj.myArray(myArray1));
        ArrayList array=new ArrayList();
        array.add("Eliza");
        array.add("Kuttya");
        array.add("Techtorial");


        System.out.println(obj.reversed(array));
    }
}
