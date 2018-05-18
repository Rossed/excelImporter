package edwards.ross.dsmsmagic.repositories;

import edwards.ross.dsmsmagic.model.TicketActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketActivityRepository extends JpaRepository<TicketActivity, Long> {
}
