package junseok.snr.transaction.module.order.web;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.module.order.application.OrderNoneTxService;
import junseok.snr.transaction.module.order.application.OrderTxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders/jpa/none-tx")
public class OrderJpaNoneTxController {
    private final OrderNoneTxService orderNoneTxService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrderJpa(@RequestParam String description) {
        return new ResponseEntity<>(
                orderNoneTxService.creatOrder(description),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public OrderDto getOrderJpa(@PathVariable Long id) {
        return orderNoneTxService.getOrder(id);
    }

}
