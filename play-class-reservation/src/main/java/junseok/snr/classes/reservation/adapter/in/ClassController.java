package junseok.snr.classes.reservation.adapter.in;

import junseok.snr.classes.reservation.application.port.in.SaveClassUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/classes")
public class ClassController {
    private final SaveClassUseCase classUseCase;

    @PostMapping
    public ResponseEntity<Void> create() {
        classUseCase.create500Classes();
        return ResponseEntity.ok().build();
    }

}
