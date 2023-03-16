package hibernate.credit.card.save.dltehibernate.services;

import hibernate.credit.card.save.dltehibernate.model.CreditCard;
import hibernate.credit.card.save.dltehibernate.remote.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;
    public CreditCard implementationOfSave(CreditCard creditCard){
        return repository.save(creditCard);
    }

    public String implementOfDeleteById(long card_number) {
        CreditCard creditCard=repository.findById(card_number).get();
        String information= creditCard.getCard_number()+" has removed/suspended";
        repository.deleteById(card_number);
        return information;
    }

    public Optional<CreditCard> implementOfFindById(long card_number) {
        return repository.findById(card_number);
    }

    public List<CreditCard> implementOfFindAll() {
        return (List<CreditCard>) repository.findAll();
    }
}

