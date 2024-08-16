package junseok.snr.classes.reservation.adapter.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int maxCapacity; // 수업 최대 정원

    @Column(nullable = false)
    private int currentCount; // 현재 예약된 인원수

    @OneToMany(mappedBy = "classes")
    private List<ReservationEntity> reservations;


}
