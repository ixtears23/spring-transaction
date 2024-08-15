package junseok.snr.classes.adapter.out.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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

}
