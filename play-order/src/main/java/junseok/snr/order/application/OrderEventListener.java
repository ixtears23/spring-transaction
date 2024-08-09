package junseok.snr.order.application;

import junseok.snr.core.outbox.adaptor.out.TransactionalOutboxRepository;
import junseok.snr.core.outbox.domain.Status;
import junseok.snr.core.outbox.domain.TransactionalOutbox;
import junseok.snr.core.outbox.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class OrderEventListener {
    private final TransactionalOutboxRepository transactionalOutboxRepository;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void listenOrder(OrderEvent orderEvent) {
        transactionalOutboxRepository.save(
                TransactionalOutbox.builder()
                        .eventType(orderEvent.getClass().getTypeName())
                        .status(Status.PENDING)
                        .domainId(orderEvent.eventId())
                        .payload(orderEvent.description())
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}
