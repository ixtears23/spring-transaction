package junseok.snr.inventory.application.port.out;

import junseok.snr.inventory.adapter.out.entity.InventoryEntity;

public interface InventoryRepository {
    InventoryEntity findById(long inventoryId);
    void save(InventoryEntity inventoryEntity);
}
