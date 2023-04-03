package dlte.assessment.rest.api.demo.repository;

import dlte.assessment.rest.api.demo.models.PersonalLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<PersonalLoan,Long> {
    @Modifying
    @Transactional
    @Query("update PersonalLoan set statusOfApproval='Approved' where cibil>700 and profession in ('salaried','self-employed') and incomePerAnnum >= requestedAmount*3")
    void updateStatus();

    @Query("select loanRequestNumber,requestedAmount,cibil,aadhaar,pan,profession,incomePerAnnum,statusOfApproval,dateOfTheRequest from PersonalLoan where statusOfApproval='Rejected'")
    List<Object[]> fetchByStatus();
}
