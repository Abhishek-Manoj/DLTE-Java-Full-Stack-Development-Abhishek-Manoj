package dlte.oop.javapart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ImplementingMultilevel extends DebCard{

    public void payBills(String toWhom,int amount){
        if (getAccBal()>=amount){
            setAccBal(getAccBal()-amount);
            System.out.println(amount+" Billing to "+toWhom+" has paid by "+getAccHolder());
        }
        else{
            System.out.println(amount+" Billing to "+toWhom+" hasn't paid by "+getAccHolder());
        }
    }

    public static void main(String[] args) {
        ImplementingMultilevel implement=new ImplementingMultilevel();
        implement.setAccNum(769775960767L);implement.setAccBal(12000);
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class KYC{
    private String accHolder;
    private long accNum;

    public String getAccHolder() {
        return accHolder;
    }

    public long getAccNum() {
        return accNum;
    }

    public double getAccBal() {
        return accBal;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }

    private double accBal;
}

class DebCard extends KYC {
    public void deposit(int amount){
        setAccBal(getAccBal()+amount);
        System.out.println(amount+" has deposited in "+getAccHolder()+"'s account.");
    }
    public void withdraw(int amount){
        if (getAccBal()>=amount){
            setAccBal(getAccBal()-amount);
            System.out.println(amount+" has paid by "+getAccHolder());
        }
        else{
            System.out.println(amount+" hasn't paid by "+getAccHolder());
        }
    }
}