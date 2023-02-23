package houseloans;

import java.util.Scanner;
public class CalulateFD {
    public static void main(String[] args){
        Integer amount = 500000, duration = 3;
        Double maturity = 0.0, interest = 6.4,temp=0.0;

        Scanner sc = new Scanner(System.in);
        //        maturity=amount+(amount*duration*interest)/100;
        maturity = amount+(amount*interest)/100;
//         if()
        maturity+=(maturity*interest)/100;
        maturity+=(maturity*100);
        while(duration>0){
            temp=maturity+(amount*interest)/100;
            maturity+=(amount*interest)/100;
            duration--;
        }
        System.out.println(maturity+" is the money you get after "+duration+" years of "+amount+"");
    }
}
