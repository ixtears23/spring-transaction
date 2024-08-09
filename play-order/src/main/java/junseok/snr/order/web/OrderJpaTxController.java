package junseok.snr.order.web;

import junseok.snr.core.order.dto.OrderDto;
import junseok.snr.order.application.OrderTxService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders/jpa/tx")
public class OrderJpaTxController {
    private final OrderTxService orderTxService;
    private final ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<OrderDto> creatOrder(@RequestParam String description) {
        return new ResponseEntity<>(
                orderTxService.creatOrder(description),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/readonly")
    public ResponseEntity<OrderDto> creatOrderdReadOnly(@RequestParam String description) {
        return new ResponseEntity<>(
                orderTxService.creatOrderdReadOnly(description),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/none-readonly/{id}")
    public OrderDto getOrderNoneReadOnly(@PathVariable Long id) {
        return orderTxService.getOrderNoneReadOnly(id);
    }

    @GetMapping("/readonly/{id}")
    public OrderDto getOrderReadOnly(@PathVariable Long id) {
        return orderTxService.getOrderReadOnly(id);
    }

}
