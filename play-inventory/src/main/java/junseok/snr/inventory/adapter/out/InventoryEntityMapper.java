package junseok.snr.inventory.adapter.out;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.core.inventory.entity.InventoryEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryEntityMapper {

    // Domain -> Entity
    public static void updateEntityFromModel(InventoryEntity inventoryEntity, Inventory inventory) {
        inventoryEntity.setId(inventory.getId());
        inventoryEntity.setQuantity(inventory.getQuantity());
    }

}
