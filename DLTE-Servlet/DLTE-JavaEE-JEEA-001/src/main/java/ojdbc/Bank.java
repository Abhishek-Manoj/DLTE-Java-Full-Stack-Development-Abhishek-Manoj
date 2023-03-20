package ojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private Long accountNumber;
    private String accHolder, password;
    private int balance;
}
