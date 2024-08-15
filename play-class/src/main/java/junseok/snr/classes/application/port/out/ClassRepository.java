package junseok.snr.classes.application.port.out;

import junseok.snr.classes.adapter.out.entity.ClassEntity;

public interface ClassRepository {
    ClassEntity findByClassId(long classId);
    void saveAll(Iterable<ClassEntity> entities);
}
