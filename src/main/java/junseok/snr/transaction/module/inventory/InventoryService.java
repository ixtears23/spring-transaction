package junseok.snr.transaction.module.inventory;

import junseok.snr.transaction.module.order.application.OrderTxService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class InventoryService {
    private final RedissonClient redissonClient;
    private final Inventory inventory;
    private final OrderTxService orderTxService;
    private final ThreadPoolTaskExecutor taskExecutor;


    @Transactional
    public void reduceStock(String productId, int quantity) {

        taskExecutor.execute(() -> {
            int abc = 0;
            while (true) {
                abc++;
                if (abc < 0) {
                    break;
                }
            }

            RLock lock = redissonClient.getLock("inventory.reduceStock:" + productId);

            try {
                boolean isLocked = lock.tryLock(1, 1, TimeUnit.SECONDS);

                if (isLocked) {
                    orderTxService.creatOrder(UUID.randomUUID().toString());
                    inventory.setQuantity(inventory.getQuantity() - quantity);
                } else {
                    throw new RuntimeException();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });
    }
}
