package junseok.snr.inventory;

import lombok.RequiredArgsConstructor;
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
}
