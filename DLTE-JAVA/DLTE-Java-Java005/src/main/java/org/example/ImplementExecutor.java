package org.example;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ImplementExecutor {
    public static void main(String[] args) {

    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor

class Gpay{
    private String username;
    private int upi;
    private double accountBalance;
}

//resource class

class wallet implements Runnable{


}