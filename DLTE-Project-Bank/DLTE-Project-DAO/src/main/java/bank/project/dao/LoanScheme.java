package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanScheme {
    private Long loanSchemeId;
    private String loanSchemeType,loanSchemeName,loanSchemeDesc;
    private float loanSchemeRoi;
}
