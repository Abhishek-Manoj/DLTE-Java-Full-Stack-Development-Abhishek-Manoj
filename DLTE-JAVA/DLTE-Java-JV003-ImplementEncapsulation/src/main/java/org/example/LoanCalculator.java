package org.example;

public class LoanCalculator {
    public static void main(String[]args){
        customer depositMoney=new customer();
        depositMoney.openDeposits();
    }
}
class customer{
        public void openDeposits(){
        class request{
        private String customerName;
        private String PAN;
        private long Aadhaar;
        private String profession;
        private double cibil;
        private long contact;

        public String request(){
        return customerName;
        }

        public void setCustomerName(String customerName){
        this.customerName=customerName;
        }

        public String getCustomerName(){
        return customerName;
        }

        public void setProfession(String profession){
        this.profession=profession;
        }

        public String getProfession(){
        return profession;
        }

        public long getAadhaar(){
        return Aadhaar;
        }

        public void setAadhaar(int Aadhaar){
        this.Aadhaar=Aadhaar;
        }

        public void setCibil(double cibil){
        this.cibil=cibil;
        }

        public double getCibil(){
        return cibil;
        }

        public String getPAN(){
        return PAN;
        }

        public void setPAN(String PAN){
        this.PAN=PAN;
        }
//defaultconstructor
        public request(){}

//parameterizedconstructor
        public request(String customerName,String PAN,int Aadhaar,String profession,double cibil,int contact)
        {
        this.customerName=customerName;
        this.PAN=PAN;
        this.Aadhaar=Aadhaar;
        this.profession=profession;
        this.cibil=cibil;
        this.contact=contact;
        }
        }
        request fixed=new request();
        fixed.setCustomerName("Abhishek");
        fixed.setPAN("HGFPM7801PM");
        fixed.setAadhaar(355475653);
        fixed.setProfession("SDE");
        System.out.println(fixed.getCustomerName()+" "+fixed.getAadhaar()+" "+fixed.getCibil());
        request fde=new request("Kiran","ASDFG4568PM",1076846496,"HR",12324.9,5984);
        System.out.println(fde.getAadhaar()+" "+fde.getPAN()+" "+fde.getCustomerName());
        System.out.println("Loan Request Has been Recieved!");

        }

}
