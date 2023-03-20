package ojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payee {
    private String payee_name;
    private Long accountNumber,payee_acc;
}
