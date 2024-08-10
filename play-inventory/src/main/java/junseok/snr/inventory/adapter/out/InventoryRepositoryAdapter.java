package junseok.snr.inventory.adapter.out;

import junseok.snr.core.inventory.adapter.out.InventoryJpaRepository;
import junseok.snr.inventory.application.port.out.InventoryRepository;
import junseok.snr.core.inventory.entity.InventoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class InventoryRepositoryAdapter implements InventoryRepository {
    private final InventoryJpaRepository inventoryJpaRepository;

    @Override
    public InventoryEntity findById(long inventoryId) {
        return inventoryJpaRepository.findById(inventoryId)
                .orElseThrow();
    }

    @Override
    public void save(InventoryEntity inventoryEntity) {
        inventoryJpaRepository.save(inventoryEntity);
    }
}