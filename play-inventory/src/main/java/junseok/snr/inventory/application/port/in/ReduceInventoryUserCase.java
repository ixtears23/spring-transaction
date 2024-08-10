package junseok.snr.inventory.application.port.in;

public interface ReduceInventoryUserCase {
    void reduceStock(long inventoryId, int quantity);
}
