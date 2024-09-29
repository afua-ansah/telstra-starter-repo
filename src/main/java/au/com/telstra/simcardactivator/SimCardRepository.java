package au.com.telstra.simcardactivator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Long>{
    SimCard findById(long id);
}
