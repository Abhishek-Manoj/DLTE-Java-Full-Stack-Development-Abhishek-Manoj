package hibernate.credit.card.save.dltehibernate.remote;

import hibernate.credit.card.save.dltehibernate.model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CreditCard,Long> {

}
