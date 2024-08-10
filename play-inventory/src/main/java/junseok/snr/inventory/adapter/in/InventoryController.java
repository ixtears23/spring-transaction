package junseok.snr.inventory.adapter.in;

import junseok.snr.core.inventory.domain.model.Inventory;
import junseok.snr.inventory.application.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Inventory> get(@RequestParam long inventoryId) {
        return ResponseEntity.ok(inventoryService.getInventory(inventoryId));
    }

    @PostMapping("/reduce")
    public void reduceStock(@RequestParam long inventoryId, @RequestParam int quantity) {
        inventoryService.reduceStock(inventoryId, quantity);
    }
}
