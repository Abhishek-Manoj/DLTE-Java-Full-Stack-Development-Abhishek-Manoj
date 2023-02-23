package dlte.oop.javapart;

public class ImplementHierarchy {
    public static void main(String[] arg){
        Span span=new Span();
        span.spiralCopy();
        span.listAll();

        ImplementingSingle single=new ImplementingSingle();
        single.traverse();
        single.sumLocker();
    }
}

class Span extends Performing{
    int[] report=new int[lockers.length*lockers[0].length];

    public void listAll(){
        System.out.println();
    }
    public void spiralCopy(){
        int row=1,column=1,index=0;
        for (;column>0;column--,index++){
            report[index]=lockers[row][column];
        }
        column++;
        row++;
        for (;column<lockers[row].length;column++,index++){
            report[index]=lockers[row][column];
        }
        column--;
        row--;
        for (;row>=0;row--,index++){
            report[index]=lockers[row][column];

        }
        row++;column--;
        for (;column>=0;column--,index++){

        }
    }
}