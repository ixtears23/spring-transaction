package junseok.snr.transaction.core.outbox.event;

public record OrderEvent(long eventId,
                         String description) {
}
