package hibernate.credit.card.save.dltehibernate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long card_number;

    @Column(nullable = false)
    private String card_holder;

    @Column(nullable = false)
    private int card_pin;

    @Column(nullable = false)
    private Date card_expiry;

    @Column(nullable = false)
    private int limit;

}
