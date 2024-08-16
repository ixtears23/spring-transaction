package junseok.snr.classes.reservation.adapter.out;

import junseok.snr.classes.reservation.adapter.out.entity.ClassEntity;
import junseok.snr.classes.reservation.adapter.out.mapper.ClassesMapper;
import junseok.snr.classes.reservation.application.port.out.GetClassPort;
import junseok.snr.classes.reservation.application.port.out.SaveClassPort;
import junseok.snr.classes.reservation.domian.Classes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ClassRepositoryAdapter implements SaveClassPort, GetClassPort {
    private final ClassJpaRepository classJpaRepository;

    @Override
    public Classes findByClassId(long classId) {
        ClassEntity classEntity = classJpaRepository.findByClassId(classId);
        return ClassesMapper.toClasses(classEntity);
    }

    @Override
    public void saveAll(Iterable<Classes> entities) {
        List<ClassEntity> classEntities = new ArrayList<>();

        entities.forEach(classes ->
            classEntities.add(ClassesMapper.toClassEntity(classes))
        );

        classJpaRepository.saveAll(classEntities);
    }

    @Override
    public void save(Classes classes) {
        classJpaRepository.save(ClassesMapper.toClassEntity(classes));
    }

    @Override
    public void update(Classes classes) {
        classJpaRepository.save(ClassesMapper.toClassEntity(classes));
    }

    @Override
    public List<Classes> findAll() {
        List<ClassEntity> classEntityList = classJpaRepository.findAll();

        return classEntityList.stream()
                .map(ClassesMapper::toClasses)
                .toList();
    }

}
