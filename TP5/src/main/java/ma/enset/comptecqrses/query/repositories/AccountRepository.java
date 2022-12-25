package ma.enset.comptecqrses.commonapi.query.repositories;

import ma.enset.comptecqrses.commonapi.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
