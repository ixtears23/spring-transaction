package junseok.snr.classes.adapter.out;

import junseok.snr.classes.adapter.out.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassJpaRepository extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassId(long classId);
    List<ClassEntity> saveAll(Iterable<ClassEntity> entities);
}
