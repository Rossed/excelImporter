package edwards.ross.dsmsmagic.repositories;

import edwards.ross.dsmsmagic.model.TicketMovements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMovementsRepository extends JpaRepository<TicketMovements, Long> {
}
