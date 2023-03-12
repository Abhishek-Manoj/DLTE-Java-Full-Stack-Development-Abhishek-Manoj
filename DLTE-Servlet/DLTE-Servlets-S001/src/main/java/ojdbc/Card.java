package ojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String car_holder, card_expiry;
    private int card_pin, limit;
    private long card_number;


}
