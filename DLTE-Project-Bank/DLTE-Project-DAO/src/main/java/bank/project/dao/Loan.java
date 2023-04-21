package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//POJO for Loan Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private Long loanAppId,loanSchemeId,customerId;
    private float loanAmount,loanEmi;
    private int loanTenure;
}
