package junseok.snr.transaction.module.inventory;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class InventoryService {
    private final RedissonClient redissonClient;
    private final Inventory inventory;

    @Transactional
    public void reduceStock(String productId, int quantity) throws InterruptedException {

        RLock lock = redissonClient.getLock("inventory.reduceStock:" + productId);

        try {
            boolean isLocked = lock.tryLock(10, 60, TimeUnit.SECONDS);

            if (isLocked) {
                inventory.setQuantity(inventory.getQuantity() - quantity);
            }
        } finally {
            lock.unlock();
        }
    }
}
