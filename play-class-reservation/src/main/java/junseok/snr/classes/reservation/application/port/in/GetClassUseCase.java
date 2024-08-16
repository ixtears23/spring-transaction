package junseok.snr.classes.reservation.application.port.in;

import junseok.snr.classes.reservation.domian.Classes;

import java.util.List;

public interface GetClassUseCase {
    Classes getClass(long classId);
    List<Classes> getAllClass();

}
