package ma.enset.comptecqrses.commonapi.query.repositories;

import ma.enset.comptecqrses.commonapi.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
