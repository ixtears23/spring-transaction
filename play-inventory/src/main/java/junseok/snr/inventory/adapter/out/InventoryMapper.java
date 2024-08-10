package junseok.snr.inventory.adapter.out;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.core.inventory.entity.InventoryEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryMapper {

    // Entity -> Domain
    public static Inventory toInventory(InventoryEntity inventoryEntity) {
        return new Inventory(
                inventoryEntity.getId(),
                inventoryEntity.getQuantity()
        );
    }
}
