package junseok.snr.classes.reservation.application.service;

import junseok.snr.classes.reservation.application.exception.ReservationException;
import junseok.snr.classes.reservation.application.port.in.GetClassUseCase;
import junseok.snr.classes.reservation.application.port.in.ReserveUseCase;
import junseok.snr.classes.reservation.application.port.out.SaveClassPort;
import junseok.snr.classes.reservation.application.port.out.SaveReservationPort;
import junseok.snr.classes.reservation.domian.Classes;
import junseok.snr.classes.reservation.domian.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReservationService implements ReserveUseCase {
    private final GetClassUseCase getClassUseCase;
    private final SaveReservationPort saveReservationPort;
    private final SaveClassPort saveClassPort;

    @Transactional
    @Override
    public void makeReservation(long classId, long userId) {
        Classes classes = getClassUseCase.getClass(classId);

        if (!classes.canReserve()) {
            throw new ReservationException("Can't reserve class");
        }

        Reservation reservation = Reservation.builder()
                .reservationAt(LocalDateTime.now())
                .userId(userId)
                .classes(classes)
                .build();

        classes.reserve(reservation);

        saveReservationPort.save(reservation);
        saveClassPort.update(classes);
    }
}
