package junseok.snr.inventory;

import junseok.snr.core.inventory.entity.InventoryEntity;
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
public class InventoryService {
    private final RedissonClient redissonClient;
    private final InventoryRepository inventoryRepository;

    @Transactional
    public void reduceStock(long inventoryId, int quantity) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(inventoryId)
                .orElseThrow();

        RLock rLock = redissonClient.getLock(CommonOptions.name("decreaseStock"));

        try {
            log.info("=== Lock 획득 시도");
            rLock.lock();
            log.info("=== Lock 획득 성공");
            inventoryEntity.decreaseQuantity(quantity);
        } finally {
            rLock.unlock();
            log.info("=== Lock 해제");
        }
    }
}
