package junseok.snr.reservation.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationService {

    @Scheduled(fixedRate = 5000)
    public void pollingReservation() {
        log.info("=== polling reservation ===");
    }
}
