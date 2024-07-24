package junseok.snr.transaction.core.user.infrastructure;

import junseok.snr.transaction.core.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
