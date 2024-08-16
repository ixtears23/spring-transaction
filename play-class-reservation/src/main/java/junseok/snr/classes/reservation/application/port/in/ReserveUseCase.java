package junseok.snr.classes.reservation.application.port.in;

public interface ReserveUseCase {
    void makeReservation(long classId, long userId);
}
