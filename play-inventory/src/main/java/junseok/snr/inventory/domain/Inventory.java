package junseok.snr.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Inventory {
    private Long id;
    private int quantity;

    // 수량 차감
    public void decreaseQuantity(int quantity) {
        if (this.quantity == 0){
            throw new RuntimeException("Inventory is empty");
        }

        int quantityDeducted = this.quantity - quantity;

        if (quantityDeducted < 0) {
            throw new RuntimeException("0 보다 적게 차감시킬 수 없다.");
        }

        this.quantity = quantityDeducted;
    }
}
