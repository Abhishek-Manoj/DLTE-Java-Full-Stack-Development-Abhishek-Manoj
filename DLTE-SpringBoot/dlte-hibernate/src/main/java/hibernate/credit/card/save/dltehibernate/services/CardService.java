package hibernate.credit.card.save.dltehibernate.services;

import hibernate.credit.card.save.dltehibernate.model.CreditCard;
import hibernate.credit.card.save.dltehibernate.remote.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;
    public CreditCard implementationOfSave(CreditCard creditCard){
        return repository.save(creditCard);
    }
}

