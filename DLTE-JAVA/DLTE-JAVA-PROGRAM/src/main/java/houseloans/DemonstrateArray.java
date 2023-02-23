package houseloans;

import java.util.Scanner;
public class DemonstrateArray {
    public static void main(String[] args){
        Double[] transactions = new Double[10];
        Scanner sc = new Scanner(System.in);
        Integer noOfDebits=0;

        for(int index=0;index<transactions.length;index++){
            System.out.println("Current Balance : ");
            transactions[index]=sc.nextDouble();
            if(index>=1){
                if (transactions[index]<transactions[index-1])
                    noOfDebits++;
            }
        }
        System.out.println(noOfDebits+" debits occured");

        noOfDebits-=3;

        if (noOfDebits>0){
            System.out.println(noOfDebits*20+" charged extra for crossing transaction limit of "+transactions);
        }
        sc.close();
    }
}
