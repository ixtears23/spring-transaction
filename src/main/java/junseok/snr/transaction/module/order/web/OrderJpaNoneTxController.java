package junseok.snr.transaction.module.order.web;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.module.order.application.OrderNoneTxService;
import junseok.snr.transaction.module.order.application.OrderTxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders/jpa/none-tx")
public class OrderJpaNoneTxController {
    private final OrderNoneTxService orderNoneTxService;

    @PostMapping
    public OrderDto createOrderJpa(@RequestParam String description) {
        return orderNoneTxService.creatOrder(description);
    }

    @GetMapping("/{id}")
    public OrderDto getOrderJpa(@PathVariable Long id) {
        return orderNoneTxService.getOrder(id);
    }

}
