package junseok.snr.order.application.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {
    private final String message;
    private final ErrorCode errorCode;

    public OrderException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
