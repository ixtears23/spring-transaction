package junseok.snr.inventory.application;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.core.inventory.entity.InventoryEntity;
import junseok.snr.inventory.adapter.out.InventoryEntityMapper;
import junseok.snr.inventory.adapter.out.InventoryMapper;
import junseok.snr.inventory.application.port.out.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public void reduceStock(long inventoryId, int quantity) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(inventoryId);
        Inventory inventory = InventoryMapper.toInventory(inventoryEntity);
        log.info("=== Lock 획득 성공");
        inventory.decreaseQuantity(quantity);
        InventoryEntityMapper.updateEntityFromModel(inventoryEntity, inventory);
    }

}
