package junseok.snr.classes.application.port;

import junseok.snr.classes.adapter.out.entity.ClassEntity;
import junseok.snr.classes.application.port.in.SaveClassUseCase;
import junseok.snr.classes.application.port.out.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class ClassService implements SaveClassUseCase {
    private final ClassRepository classRepository;

    @Override
    public void create500Classes() {
        List<String> classNames = List.of(
                "1:1 필라테스",
                "1:1 개인레슨",
                "1:1 리포머",
                "3:1 그룹수업",
                "2:1 그룹수업",
                "그룹수업"
        );
        Random random = new Random();
        List<ClassEntity> classEntities = new ArrayList<>();

        IntStream.range(0, 500)
                .forEach(i -> {
                    int maxCapacity = 100;
                    classEntities.add(
                            ClassEntity.builder()
                                    .classId(i)
                                    .name(classNames.get(random.nextInt(classNames.size())))
                                    .maxCapacity((random.nextInt((maxCapacity / 5) + 1)) * 5)
                                    .currentCount(0)
                                    .build()
                    );
                });

        classRepository.saveAll(classEntities);
    }
}
