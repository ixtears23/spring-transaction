package junseok.snr.classes.reservation.adapter.out.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private long userId; // 예약한 사용자 ID
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classes; // 예약된 수업 정보
    @Column(nullable = false)
    private LocalDateTime reservationAt; // 예약 시각 (타임스탬프)

}
