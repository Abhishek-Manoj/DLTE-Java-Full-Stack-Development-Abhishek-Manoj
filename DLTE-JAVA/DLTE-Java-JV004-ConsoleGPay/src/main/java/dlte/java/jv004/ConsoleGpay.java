package dlte.java.jv004;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class ConsoleGpay {
    public static void main(String[] args) {
        Gpay gpayOne = new Gpay("Abhishek",1234,123456789,25000);
        gpayOne.toString();
        System.out.println(gpayOne.getName()+" "+gpayOne.getAccnum()+" "+gpayOne.getUpipin()+" "+gpayOne.getBalance());
        System.out.println(gpayOne.toString());
        gpayOne.fundTransfer();
        gpayOne.rechargemobile();
        gpayOne.Fastagrecharge();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Gpay {

    private String name;
    private int upipin;
    private long accnum;
    private double balance;

    public void setName(String name) {
        this.name = name;
    }

    public void setUpipin(int upipin) {
        this.upipin = upipin;
    }

    public void setAccnum(long accnum) {
        this.accnum = accnum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getUpipin() {
        return upipin;
    }

    public long getAccnum() {
        return accnum;
    }

    public double getBalance() {
        return balance;
    }

    public Gpay(String name, int upipin, long accnum, double balance) {
        this.name = name;
        this.upipin = upipin;
        this.accnum = accnum;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Gpay{" +
                "name='" + name + '\'' +
                ", upipin=" + upipin +
                ", accnum=" + accnum +
                ", balance=" + balance +
                '}';
    }

    public void fundTransfer(){
        System.out.println("Enter UPI ID: ");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();

        System.out.println("Enter the amount to be transferred: ");
        Double amount = sc.nextDouble();

        System.out.println("Enter Name of Recipient: ");
        String recipient = sc.nextLine();

        if (pin == upipin) {
            System.out.println(amount+" is transferred to "+recipient);
        }
        else {
            System.out.println("Invalid UPI PIN!");
        }
    }

    public void recharge(){
        System.out.println();
    }
}