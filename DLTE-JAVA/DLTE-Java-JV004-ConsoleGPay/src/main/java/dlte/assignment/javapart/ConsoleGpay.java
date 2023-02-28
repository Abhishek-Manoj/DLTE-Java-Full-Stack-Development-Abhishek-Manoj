package dlte.assignment.javapart;

import java.util.Scanner;

public class ConsoleGpay {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer amount;
        String ans = new String();
        Gpay endUser = new Gpay("123456789",5000,4321,"Gourav");
        do {
            System.out.println("+++++++++++++++++++++++++++++++++++++MENU++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("1. Fund Transfer\t2. Mobile Recharge\t3. FASTag Recharge\nEnter your choice:");
            switch (sc.nextInt()){
                case 1: sc.nextLine();
                    System.out.println("Enter the recipient name:");
                    String recipient = sc.nextLine();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    endUser.fundTransfer(recipient,amount);
                    break;
                case 2: System.out.println("Enter the mobile number:");
                    Long phnno = sc.nextLong();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    endUser.recharge(phnno,amount);
                    break;
                case 3: System.out.println("Enter the vehicle number:");
                    sc.nextLine();
                    String vehicle = sc.nextLine();
                    System.out.println("Enter the amount:");
                    amount = sc.nextInt();
                    endUser.recharge(vehicle,amount);
                    break;
                default: System.out.println("Invalid Choice");
            }
            System.out.println("Do you want to make another transaction(Y/N): ");
            ans = sc.nextLine();
        }while ((ans.equals('y')||ans.equals('Y'))==true);
    }
}

class Gpay{
    Scanner sc = new Scanner(System.in);

    private String accno;
    private  Integer balance;
    private Integer upi;
    private String name;

    //Parameterised constructor
    public Gpay(String accno, Integer balance, Integer upi, String name) {
        this.accno = accno;
        this.balance = balance;
        this.upi = upi;
        this.name = name;
    }
    //Fund Transfer Method
    public void fundTransfer(String recep, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println(amount+" transferred to "+recep);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }
    //Method Overloading-function name is same. parameter is different
    //Used for mobile recharge
    public void recharge(Long number, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println(number+" successfully recharged with "+amount);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }

    //Used for Fastag Recharge
    public void recharge(String vehicle, Integer amount){
        if(amount>this.balance){
            System.out.println("Insufficient balance...");
            return;
        }
        System.out.println("Enter the UPI pin: ");
        if(this.upi==sc.nextInt()){
            System.out.println("FASTag for "+vehicle+" successfully recharged with "+amount);
        }
        else {
            System.out.println("Invalid UPI pin");
        }
    }
}
