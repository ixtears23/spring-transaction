package junseok.snr.classes.reservation.application.service;

import junseok.snr.classes.reservation.application.port.in.GetClassUseCase;
import junseok.snr.classes.reservation.application.port.in.SaveClassUseCase;
import junseok.snr.classes.reservation.application.port.out.GetClassPort;
import junseok.snr.classes.reservation.application.port.out.SaveClassPort;
import junseok.snr.classes.reservation.domian.Classes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@RequiredArgsConstructor
@Service
public class ClassService implements SaveClassUseCase, GetClassUseCase {
    private final GetClassPort getClassPort;
    private final SaveClassPort saveClassPort;
    private final Random random = new Random();

    @Transactional
    @Override
    public void create500Classes() {
        List<String> classNames = List.of(
                "필라테스",
                "개인레슨",
                "리포머",
                "그룹수업"
        );
        List<Classes> classesList = new ArrayList<>();

        LongStream.range(0, 500)
                .forEach(i -> {
                    int maxCapacity = 100;
                    classesList.add(
                            Classes.builder()
                                    .name(classNames.get(random.nextInt(classNames.size())))
                                    .maxCapacity((random.nextInt((maxCapacity / 5) + 1)) * 5)
                                    .currentCount(0)
                                    .build()
                    );
                });

        saveClassPort.saveAll(classesList);
    }

    @Override
    public Classes getClass(long classId) {
        return getClassPort.findByClassId(classId);
    }

    @Override
    public List<Classes> getAllClass() {
        return getClassPort.findAll();
    }
}
