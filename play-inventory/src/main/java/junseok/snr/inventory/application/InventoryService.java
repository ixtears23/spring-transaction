package junseok.snr.inventory.application;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.inventory.application.port.out.InventoryRepository;
import junseok.snr.inventory.application.port.in.GetInventoryUseCase;
import junseok.snr.inventory.application.port.in.ReduceInventoryUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.api.options.CommonOptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryService implements GetInventoryUseCase, ReduceInventoryUserCase {

    private final RedissonClient redissonClient;
    private final InventoryRepository inventoryRepository;

    @Transactional
    public void reduceStock(long inventoryId, int quantity) {
        Inventory inventory= inventoryRepository.findById(inventoryId);

        RLock rLock = redissonClient.getLock(CommonOptions.name("decreaseStock"));

        try {
            log.info("=== Lock 획득 시도");
            rLock.lock();
            log.info("=== Lock 획득 성공");
            inventory.decreaseQuantity(quantity);
        } finally {
            rLock.unlock();
            log.info("=== Lock 해제");
        }
    }

    @Transactional
    public Inventory getInventory(long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId);

        return inventory;
    }
}
