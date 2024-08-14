package junseok.snr.classes.application.port;

import junseok.snr.classes.application.port.in.SaveClassUseCase;
import junseok.snr.classes.application.port.out.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class ClassService implements SaveClassUseCase {
    private final ClassRepository classRepository;

    @Override
    public void create500Classes() {


        IntStream.range(0, 500)
                .forEach(i ->
    }
}
