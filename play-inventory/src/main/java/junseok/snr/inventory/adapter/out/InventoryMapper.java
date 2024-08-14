package junseok.snr.inventory.adapter.out;

import junseok.snr.inventory.domain.Inventory;
import junseok.snr.inventory.adapter.out.entity.InventoryEntity;
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
