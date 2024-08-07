package junseok.snr.transaction.module.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/reduce")
    public String reduceStock(@RequestParam String productId, @RequestParam int quantity) {
        try {
            inventoryService.reduceStock(productId, quantity);
            return "Stock reduced successfully";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }
}
