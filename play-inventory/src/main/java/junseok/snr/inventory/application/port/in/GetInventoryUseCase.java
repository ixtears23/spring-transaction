package junseok.snr.inventory.application.port.in;

import junseok.snr.core.inventory.domain.model.Inventory;

public interface GetInventoryUseCase {
    Inventory getInventory(long inventoryId);
}
