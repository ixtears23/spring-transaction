package junseok.snr.classes.reservation.adapter.out;

import junseok.snr.classes.reservation.adapter.out.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassJpaRepository extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassId(long classId);
}
