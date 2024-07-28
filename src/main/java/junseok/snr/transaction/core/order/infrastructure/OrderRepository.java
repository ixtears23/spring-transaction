package junseok.snr.transaction.core.order.infrastructure;

import junseok.snr.transaction.core.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findFirstByDescription(String description);
}
