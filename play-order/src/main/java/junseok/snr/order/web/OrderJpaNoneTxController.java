package junseok.snr.order.web;

import junseok.snr.core.order.dto.OrderDto;
import junseok.snr.order.application.OrderNoneTxService;
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
