package junseok.snr.inventory.application;

import junseok.snr.inventory.adapter.out.entity.InventoryEntity;
import junseok.snr.inventory.application.port.in.ReduceInventoryUserCase;
import junseok.snr.inventory.application.port.out.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReduceInventoryService implements ReduceInventoryUserCase {
    private final InventoryRepository inventoryRepository;

    @Transactional()
    @Override
    public void reduceStock(long inventoryId, int quantity) {
        final InventoryEntity inventoryEntity = inventoryRepository.findById(inventoryId);


    }
}
