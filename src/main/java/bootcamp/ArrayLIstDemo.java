package bootcamp;

import java.util.ArrayList;

public class ArrayLIstDemo {

	// Here is the code to check if array list is sorted in Ascending order or not
    boolean checkSorting(ArrayList< String > arraylist){
        boolean isSorted=true;
        for(int i=1;i < arraylist.size();i++){
            if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
                isSorted= false;
                break;
            }
        }
        return isSorted;
    }
    
    
    public static void main(String[] args) {
        ArrayList < String > al=new ArrayList < String >();
      
        al.add("Apple");
        al.add("Ball");
        al.add("Cat");
       al.add("cat");
        al.add("Dog");
        
        al.replaceAll(String::toUpperCase);
        
        ArrayLIstDemo alDemo=new ArrayLIstDemo();
       
        
        
        System.out.println("Is Sorted in ascending:"+alDemo.checkSorting(al));

    }
}
