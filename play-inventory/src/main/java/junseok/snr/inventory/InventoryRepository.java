package junseok.snr.inventory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {
    @PersistenceContext
    private EntityManager em;

    public void createInventory(Inventory inventory) {
        final EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(inventory);

        em.detach(inventory);
        em.remove(inventory);

        em.merge(inventory);

        em.flush();


        transaction.commit();
    }
}
