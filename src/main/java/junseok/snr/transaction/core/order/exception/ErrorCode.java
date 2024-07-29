package junseok.snr.transaction.core.order.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    ALREADY_EXISTS_ORDER("이미 존재하는 주문 입니다.");

    private final String message;
}
