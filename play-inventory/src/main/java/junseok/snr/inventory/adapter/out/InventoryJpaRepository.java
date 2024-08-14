package junseok.snr.inventory.adapter.out;

import junseok.snr.inventory.adapter.out.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Long> {
}
