package hibernate.credit.card.save.dltehibernate.controls;

import hibernate.credit.card.save.dltehibernate.model.CreditCard;
import hibernate.credit.card.save.dltehibernate.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @PutMapping("/change")
    public CreditCard callUpdate(@RequestBody CreditCard creditCard){
        return cardService.implementationOfSave(creditCard);
    }

    @DeleteMapping("/delete/{card_number}")
    public String callDeleteById(@PathVariable("card_number") long card_number){
        return cardService.implementOfDeleteById(card_number);
    }

    @GetMapping("/card/{card_number}")
    public Optional<CreditCard> callingFindById(@PathVariable("card_number") long card_number){
        return cardService.implementOfFindById(card_number);
    }

    @GetMapping("/retrieve")
    public List<CreditCard> callingFindAll(){
        return cardService.implementOfFindAll();
    }

    @PostMapping("/insert")
    public CreditCard callingSave(@RequestBody CreditCard creditCard){
        return cardService.implementationOfSave(creditCard);
    }
}
