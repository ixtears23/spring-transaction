package junseok.snr.classes.reservation.application.port.out;

import junseok.snr.classes.reservation.domian.Classes;

import java.util.List;

public interface GetClassPort {
    Classes findByClassId(long classId);
    List<Classes> findAll();
}
