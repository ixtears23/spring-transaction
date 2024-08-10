package junseok.snr.core.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
