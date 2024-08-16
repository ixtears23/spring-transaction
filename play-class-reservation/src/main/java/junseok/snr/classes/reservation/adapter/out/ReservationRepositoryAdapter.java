package junseok.snr.classes.reservation.adapter.out;

import junseok.snr.classes.reservation.adapter.out.mapper.ReservationMapper;
import junseok.snr.classes.reservation.application.port.out.SaveReservationPort;
import junseok.snr.classes.reservation.domian.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationRepositoryAdapter implements SaveReservationPort {
    private final ReservationJpaRepository reservationJpaRepository;

    @Override
    public void save(Reservation reservation) {
        reservationJpaRepository.save(ReservationMapper.toReservationEntity(reservation));
    }
}
