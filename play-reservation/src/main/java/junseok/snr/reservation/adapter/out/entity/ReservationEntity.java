package junseok.snr.reservation.adapter.out.entity;


import jakarta.persistence.*;

@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId; // 예약한 사용자 ID
    @Column(nullable = false)
    private long classId; // 예약된 수업 정보
    @Column(nullable = false)
    private Long reservationTimestamp; // 예약 시각 (타임스탬프)

}
