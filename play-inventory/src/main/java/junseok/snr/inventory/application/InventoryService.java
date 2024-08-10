package junseok.snr.inventory.application;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.core.inventory.entity.InventoryEntity;
import junseok.snr.inventory.adapter.out.InventoryEntityMapper;
import junseok.snr.inventory.adapter.out.InventoryMapper;
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

import java.util.concurrent.TimeUnit;


@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryService implements GetInventoryUseCase, ReduceInventoryUserCase {

    private final RedissonClient redissonClient;
    private final InventoryRepository inventoryRepository;

    @Transactional
    public void reduceStock(long inventoryId, int quantity) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(inventoryId);
        Inventory inventory = InventoryMapper.toInventory(inventoryEntity);

        RLock rLock = redissonClient.getLock(CommonOptions.name("decreaseStock"));

        try {
            log.info("=== Lock 획득 시도");
            if (rLock.tryLock(5, 10, TimeUnit.SECONDS)) {
                try {
                    log.info("=== Lock 획득 성공");
                    inventory.decreaseQuantity(quantity);
                    InventoryEntityMapper.updateEntityFromModel(inventoryEntity, inventory);
                } finally {
                    log.info("=== Lock 해제");
                    rLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public Inventory getInventory(long inventoryId) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(inventoryId);

        return InventoryMapper.toInventory(inventoryEntity);
    }
}
