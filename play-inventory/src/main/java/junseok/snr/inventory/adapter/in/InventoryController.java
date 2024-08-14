package junseok.snr.inventory.adapter.in;

import junseok.snr.inventory.domain.Inventory;
import junseok.snr.inventory.application.port.in.GetInventoryUseCase;
import junseok.snr.inventory.application.port.in.ReduceInventoryUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {
    private final GetInventoryUseCase getInventoryUseCase;
    @Qualifier("inventoryProxyService")
    private final ReduceInventoryUserCase reduceInventoryUserCase;

    @GetMapping
    public ResponseEntity<Inventory> get(@RequestParam long inventoryId) {
        return ResponseEntity.ok(getInventoryUseCase.getInventory(inventoryId));
    }

    @PostMapping("/reduce")
    public void reduceStock(@RequestParam long inventoryId, @RequestParam int quantity) {
        reduceInventoryUserCase.reduceStock(inventoryId, quantity);
    }
}
