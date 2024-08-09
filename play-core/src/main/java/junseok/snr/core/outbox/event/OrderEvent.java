package junseok.snr.core.outbox.event;

public record OrderEvent(long eventId,
                         String description) {
}
