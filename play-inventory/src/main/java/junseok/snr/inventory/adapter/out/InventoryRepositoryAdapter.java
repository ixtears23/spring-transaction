package junseok.snr.inventory.adapter.out;

import junseok.snr.core.inventory.adapter.out.InventoryJpaRepository;
import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.inventory.application.port.out.InventoryRepository;
import junseok.snr.core.inventory.entity.InventoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class InventoryRepositoryAdapter implements InventoryRepository {
    private final InventoryJpaRepository inventoryJpaRepository;

    @Override
    public Inventory findById(long inventoryId) {
        InventoryEntity inventoryEntity = inventoryJpaRepository.findById(inventoryId)
                .orElseThrow();

        return InventoryMapper.toInventory(inventoryEntity);
    }
}
