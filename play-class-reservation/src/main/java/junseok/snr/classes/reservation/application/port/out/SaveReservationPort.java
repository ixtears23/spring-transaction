package junseok.snr.classes.reservation.application.port.out;

import junseok.snr.classes.reservation.domian.Reservation;

public interface SaveReservationPort {
    void save(Reservation reservation);
}
