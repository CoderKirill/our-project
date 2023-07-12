package ee.example.ourproject.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDao, Integer> {
    @Transactional
    @Modifying
    @Query("update CustomerDao c set c.lastName = ?1 where c.id = ?2")
    int changeLastName(String lastName, int id);

    @Override
    void deleteById(Integer integer);

}
