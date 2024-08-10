package junseok.snr.inventory;

import junseok.snr.core.inventory.entity.InventoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/reduce")
    public void reduceStock(@RequestParam long inventoryId, @RequestParam int quantity) {
        inventoryService.reduceStock(inventoryId, quantity);
    }

    @GetMapping
    public ResponseEntity<InventoryEntity> get(@RequestParam long inventoryId) {
        return ResponseEntity.ok(inventoryService.getInventory(inventoryId));
    }
}
