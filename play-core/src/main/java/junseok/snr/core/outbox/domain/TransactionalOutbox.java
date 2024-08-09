package junseok.snr.core.outbox.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@AllArgsConstructor
public class TransactionalOutbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventType;
    private Status status;
    private Long domainId;
    private Long orders;
    private String payload;
    private LocalDateTime createdAt;
}
