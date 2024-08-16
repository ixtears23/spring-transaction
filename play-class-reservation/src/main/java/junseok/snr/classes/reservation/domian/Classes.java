package junseok.snr.classes.reservation.domian;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    private Long classId;
    private String name;
    private int maxCapacity; // 수업 최대 정원
    private int currentCount; // 현재 예약된 인원수
    private List<Reservation> reservations;

    public boolean canReserve() {
        return maxCapacity > currentCount;
    }

    public void reserve(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
        currentCount++;
        reservations.add(reservation);
    }

}
