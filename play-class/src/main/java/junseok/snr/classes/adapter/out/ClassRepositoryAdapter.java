package junseok.snr.classes.adapter.out;

import junseok.snr.classes.adapter.out.entity.ClassEntity;
import junseok.snr.classes.application.port.out.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class ClassRepositoryAdapter implements ClassRepository {
    private final ClassJpaRepository classJpaRepository;

    @Override
    public ClassEntity findByClassId(long classId) {
        return classJpaRepository.findByClassId(classId);
    }

    @Transactional
    @Override
    public void saveAll(Iterable<ClassEntity> entities) {
        classJpaRepository.saveAll(entities);
    }


}
