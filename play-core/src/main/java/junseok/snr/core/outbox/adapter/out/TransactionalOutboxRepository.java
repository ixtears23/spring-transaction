package junseok.snr.core.outbox.adapter.out;

import junseok.snr.core.outbox.domain.TransactionalOutbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalOutboxRepository extends JpaRepository<TransactionalOutbox, Long> {
}
