package junseok.snr.classes.reservation.adapter.out.mapper;

import junseok.snr.classes.reservation.adapter.out.entity.ClassEntity;
import junseok.snr.classes.reservation.domian.Classes;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassesMapper {

    // Entity -> Domain
    public static Classes toClasses(ClassEntity classEntity) {
        return Classes.builder()
                .classId(classEntity.getClassId())
                .name(classEntity.getName())
                .maxCapacity(classEntity.getMaxCapacity())
                .currentCount(classEntity.getCurrentCount())
                .build();
    }

    // Domain -> Entity
    public static ClassEntity toClassEntity(Classes classes) {
        return ClassEntity.builder()
                .classId(classes.getClassId())
                .name(classes.getName())
                .maxCapacity(classes.getMaxCapacity())
                .currentCount(classes.getCurrentCount())
                .build();
    }
}