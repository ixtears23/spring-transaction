package junseok.snr.user.adapter.out;

import junseok.snr.user.adapter.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
