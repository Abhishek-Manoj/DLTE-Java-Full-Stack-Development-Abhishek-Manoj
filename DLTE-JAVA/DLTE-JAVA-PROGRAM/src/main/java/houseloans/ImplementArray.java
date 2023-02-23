package houseloans;

import java.util.Scanner;

public class ImplementArray {
    public static void main(String[] args){
        String[] beneficiaries={"Manvith","Gourav","Surya","Ukiyo","Abhishek","Gourav","Apoorva","Sridhar","Arun","Srikanth","Arun","Gourav"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the beneficiary name");
        String myParticular=sc.nextLine();

        ImplementArray implement = new ImplementArray();
//        int total=array
    }
    public int occurance(String[] myArray,String desiredName){
        int count=0;
        for (int index=0;index<myArray.length;index++){
            if(myArray[index].equalsIgnoreCase(desiredName)){
                count++;
            }
        }
        return count;
    }
}
