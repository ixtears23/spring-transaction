package junseok.snr.classes.reservation.domian;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Reservation {
    private Long id;
    private long userId;
    private Classes classes;
    private LocalDateTime reservationAt;
}
