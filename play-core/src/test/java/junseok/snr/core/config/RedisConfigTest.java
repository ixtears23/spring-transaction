package junseok.snr.core.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RedisConfig.class)
class RedisConfigTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void getLockTest() {
        RLock rLock = redissonClient.getLock("dummy lock");
        rLock.lock();

        if (rLock.isLocked()) {
            rLock.unlock();
        }
    }

    @Test
    void getLockAsyncTest() {
        RLock rLock = redissonClient.getLock("dummy lock");
        rLock.lockAsync();

        if (rLock.isLocked()) {
            rLock.unlockAsync();
        }
    }

    @Test
    void getLockPerformTest() throws InterruptedException {
        int numberOfTask = 100_000;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(10_000);

        for (int i  = 0; i < numberOfTask; i++) {
            executorService.execute(() -> {
                RLock rLock = redissonClient.getLock("dummy lock");
                rLock.lock();

                if (rLock.isLocked()) {
                    rLock.unlock();
                }

                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        assertThat(countDownLatch.getCount()).isZero();
    }

}