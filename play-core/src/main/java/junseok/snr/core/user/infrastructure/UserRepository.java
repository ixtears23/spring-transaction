package junseok.snr.core.user.infrastructure;

import junseok.snr.core.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
