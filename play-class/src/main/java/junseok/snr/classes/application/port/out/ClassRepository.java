package junseok.snr.classes.application.port.out;

import junseok.snr.classes.adapter.out.entity.ClassEntity;
import org.springframework.transaction.annotation.Transactional;

public interface ClassRepository {
    ClassEntity findByClassId(long classId);

    @Transactional
    void saveAll(Iterable<ClassEntity> entities);
}
