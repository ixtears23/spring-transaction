package junseok.snr.core.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

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

}