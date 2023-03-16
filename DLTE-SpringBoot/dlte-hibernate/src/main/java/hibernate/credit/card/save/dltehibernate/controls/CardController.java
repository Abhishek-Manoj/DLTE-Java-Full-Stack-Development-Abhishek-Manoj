package hibernate.credit.card.save.dltehibernate.controls;

import hibernate.credit.card.save.dltehibernate.model.CreditCard;
import hibernate.credit.card.save.dltehibernate.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/insert")
    public CreditCard callingSave(@RequestBody CreditCard creditCard){
        return cardService.implementationOfSave(creditCard);
    }
}
