package dlte.oop.javapart;

import java.util.Arrays;

public class ImplementingSingle extends Performing {

    public void traverse(){
        for(int index=0;index<lockers.length;index++){
            Arrays.sort(lockers[index]);
            System.out.println(Arrays.toString(lockers[index]));
        }
    }

    public void sumLocker(){
        int worthAmount = 0;
        for (int[] row:lockers){
            for (int each:row){
                worthAmount+=each;

            }
        }
        System.out.println("Total worth amount: "+worthAmount);
    }
    public static void main(String[] args) {
        ImplementingSingle perform = new ImplementingSingle();
//        Performing perform = new Performing();
        perform.traverse();     //runtime polymorphism
        perform.sumLocker();
    }
}

class Performing{
    //array[row]][col] where row and column indices always starts with 0
    int[][] lockers={{34500,12000,80000},{4500,23000,10000},{7600,34000,12000}};

    public void traverse() {
        for(int[] row:lockers) {
            for(int each:row){
                System.out.print(each+" ");
            }
        }
    }
}