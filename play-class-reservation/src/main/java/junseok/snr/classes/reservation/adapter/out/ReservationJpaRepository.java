package junseok.snr.classes.reservation.adapter.out;

import junseok.snr.classes.reservation.adapter.out.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
}
