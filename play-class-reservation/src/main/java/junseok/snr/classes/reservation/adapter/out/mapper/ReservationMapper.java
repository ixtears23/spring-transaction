package junseok.snr.classes.reservation.adapter.out.mapper;

import junseok.snr.classes.reservation.adapter.out.entity.ReservationEntity;
import junseok.snr.classes.reservation.domian.Reservation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationMapper {

    // Entity -> Domain
    public static Reservation toReservation(ReservationEntity reservationEntity) {
        return Reservation.builder()
                .id(reservationEntity.getId())
                .userId(reservationEntity.getUserId())
                .reservationAt(reservationEntity.getReservationAt())
                .classes(ClassesMapper.toClasses(reservationEntity.getClasses()))
                .build();
    }

    // Domain -> Entity
    public static ReservationEntity toReservationEntity(Reservation reservation) {
        return ReservationEntity.builder()
                .id(reservation.getId())
                .userId(reservation.getUserId())
                .reservationAt(reservation.getReservationAt())
                .classes(ClassesMapper.toClassEntity(reservation.getClasses()))
                .build();
    }
}