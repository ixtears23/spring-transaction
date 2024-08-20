package junseok.snr.classes.reservation.adapter.in;


import junseok.snr.classes.reservation.application.exception.ReservationException;
import junseok.snr.classes.reservation.application.port.in.ReserveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/classes")
public class ClassReservationController {
    private final ReserveUseCase reserveUseCase;

    @PostMapping("/{classId}/reserve")
    public void reserveClass(@PathVariable Long classId, @RequestParam("userId") long userId) {
        reserveUseCase.makeReservation(classId, userId);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(ReservationException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

}
