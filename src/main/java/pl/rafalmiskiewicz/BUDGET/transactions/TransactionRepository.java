package pl.rafalmiskiewicz.BUDGET.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findById(int id);

    @Query(value = "SELECT * FROM transaction WHERE transaction.id_user=:idUser ", nativeQuery = true)
    List<Transaction> findAllByUserId(@Param("idUser") int idUser);

    @Query(value = "SELECT * FROM transaction WHERE transaction.=:idUser ", nativeQuery = true)
    List<Transaction> findAllBySchedule(@Param("idUser") int idUser);

    @Modifying
    @Query(value = "UPDATE `transaction` SET `amount` = :amount, `description` = :description, `date` = :date WHERE `transaction`.`id_transaction` = :id_transaction", nativeQuery = true)
    void updateTransaction(@Param("id_transaction") int id_transaction, @Param("amount") Double amount, @Param("description") String description, @Param("date") Date date);

    @Modifying
    @Query(value = "SELECT * FROM transaction WHERE MONTH (transaction.date)= :month AND transaction.id_user=:id_use", nativeQuery = true)
    List<Transaction> findAllByMonth(@Param("id_use") int id_user, @Param("month") Integer month);
}
