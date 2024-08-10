package junseok.snr.inventory;


import junseok.snr.core.inventory.entity.InventoryEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InventoryEntityTest {

    @Test
    void 수량_차감시_수량은_정상_차감된다() {
        InventoryEntity inventoryEntity = new InventoryEntity(1L, 100);

        inventoryEntity.decreaseQuantity(1);

        assertThat(inventoryEntity.getQuantity()).isEqualTo(99);
    }

    @Test
    void 수량이_0이면_차감시킬_수_없다() {
        InventoryEntity inventoryEntity = new InventoryEntity(1L, 0);

        assertThatThrownBy(
                () -> inventoryEntity.decreaseQuantity(1)
        ).isInstanceOf(RuntimeException.class);

    }

    @Test
    void 수량차감시_0보다_적게_차감시킬수_없다() {
        InventoryEntity inventoryEntity = new InventoryEntity(1L, 3);

        assertThatThrownBy(
                () -> inventoryEntity.decreaseQuantity(4)
        ).isInstanceOf(RuntimeException.class);
    }
}