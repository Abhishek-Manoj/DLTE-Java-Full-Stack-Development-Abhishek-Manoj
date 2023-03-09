package exception.slicing;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlicingException {
    Scanner scanner=new Scanner(System.in);
    Double[] loanamt={10000.0,20000.,30000.0,50000.0,75000.0};            //array of loan amounts
    static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);     // Developer's use (for tracking the process)


    public static void main(String[] args) {
        Integer start=0;
        Integer end=0;
        SlicingException slicingException = new SlicingException();      //object-creation


        try {
            System.out.println(Arrays.toString(slicingException.loanamt));
            System.out.println("For the above loan amounts,Enter the start and end index for slicing the loan amounts:");
            start=slicingException.scanner.nextInt();       //from index
            end=slicingException.scanner.nextInt();         //to index
            assert start>=end:"from index is more";        //assertion
            logger.log(Level.INFO,"Inputs received from user");
            slicingException.slice(slicingException.loanamt,start,end);
        }
        //handling ArrayIndexOutOfBoundsException
        catch(ArrayIndexOutOfBoundsException object ) {
            logger.log(Level.WARNING,"ArrayIndexOutOfBounds exception occurred, it will be handled");
            System.out.println(object);
            System.out.println("Start and end index must be within "+slicingException.loanamt.length);
            start=slicingException.scanner.nextInt();
            end=slicingException.scanner.nextInt();
            slicingException.slice(slicingException.loanamt,start,end);
        }
        //AssertionError and NegativeArraySizeException(if end index is less than start index)
        catch(NegativeArraySizeException|AssertionError asrobj){
            logger.log(Level.WARNING,"NegativeArraySizeException occurred, it will be handled");
            System.out.println("start index must be less than end index(5)");
            start=slicingException.scanner.nextInt();
            end=slicingException.scanner.nextInt();
            slicingException.slice(slicingException.loanamt,start,end);
        }
        //handling InputMismatchException
        catch (InputMismatchException object1){
            logger.log(Level.WARNING,"InputMismatchException occurred, it will be handled");
            System.out.println(object1);
            System.out.println("please enter the indexes in number format ");
            Scanner scanner1=new Scanner(System.in);    //scanner object is no longer useful,create a new object for Scanner class
            start=scanner1.nextInt();
            end=scanner1.nextInt();
            slicingException.slice(slicingException.loanamt,start,end);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            logger.log(Level.FINE,"process complete");
            System.out.println("The above Array represents the sliced loan amounts");
        }
    }

    public void slice(Double[] loanamt,int start,int end){
        Double[] newloanamt=new Double[end-start];
        for(int index=0;index<newloanamt.length;index++){
            newloanamt[index]=loanamt[start+index];           //srart to end-1 index
        }
        System.out.println(Arrays.toString(newloanamt));
    }
}