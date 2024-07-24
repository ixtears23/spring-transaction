package junseok.snr.transaction.module.order.web;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.module.order.application.OrderTxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders/jpa/tx")
public class OrderJpaTxController {
    private final OrderTxService orderTxService;

    @PostMapping
    public OrderDto creatOrder(@RequestParam String description) {
        return orderTxService.creatOrder(description);
    }

    @PostMapping("/readonly")
    public OrderDto creatOrderdReadOnly(@RequestParam String description) {
        return orderTxService.creatOrderdReadOnly(description);
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
