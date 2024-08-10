package junseok.snr.core.inventory.adapter.out;

import junseok.snr.core.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Long> {
}
