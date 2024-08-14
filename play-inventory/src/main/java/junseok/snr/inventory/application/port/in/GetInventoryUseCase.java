package junseok.snr.inventory.application.port.in;

import junseok.snr.inventory.domain.Inventory;

public interface GetInventoryUseCase {
    Inventory getInventory(long inventoryId);
}
