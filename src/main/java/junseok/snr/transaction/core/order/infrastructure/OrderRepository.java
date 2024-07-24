package junseok.snr.transaction.core.order.infrastructure;

import junseok.snr.transaction.core.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
