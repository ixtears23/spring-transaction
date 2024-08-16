package junseok.snr.classes.reservation.application.port.out;

import junseok.snr.classes.reservation.domian.Classes;

public interface SaveClassPort {
    void saveAll(Iterable<Classes> classesIterable);
    void save(Classes classes);
    void update(Classes classes);
}
