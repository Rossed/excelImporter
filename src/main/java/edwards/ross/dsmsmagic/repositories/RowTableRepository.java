package edwards.ross.dsmsmagic.repositories;

import edwards.ross.dsmsmagic.model.RowTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowTableRepository extends JpaRepository<RowTable, Long> {
}
