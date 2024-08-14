package junseok.snr.classes.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private long classId; // Redis와 연동되는 고유한 수업 ID

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int maxCapacity; // 수업 최대 정원

    @Column(nullable = false)
    private int currentCount; // 현재 예약된 인원수

}
