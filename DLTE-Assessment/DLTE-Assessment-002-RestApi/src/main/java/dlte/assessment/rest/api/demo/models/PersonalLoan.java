package dlte.assessment.rest.api.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PersonalLoan {
    @Id
    private Long loanRequestNumber;

    @Column(nullable = false)
    private int requestedAmount;

    @Column(nullable = false)
    private int cibil;

    @Column(nullable = false)
    private Long aadhaar;

    @Column(nullable = false)
    private String pan;

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false)
    private Long incomePerAnnum;

    @Column
    private String statusOfApproval;

    @Temporal(TemporalType.DATE)
    private Date dateOfTheRequest;
}
