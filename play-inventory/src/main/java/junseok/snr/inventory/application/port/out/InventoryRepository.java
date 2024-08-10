package junseok.snr.inventory.application.port.out;

import junseok.snr.core.inventory.domain.model.Inventory;

public interface InventoryRepository {
    Inventory findById(long inventoryId);
}
