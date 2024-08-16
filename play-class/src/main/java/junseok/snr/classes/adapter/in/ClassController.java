package junseok.snr.classes.adapter.in;

import junseok.snr.classes.adapter.out.entity.ClassEntity;
import junseok.snr.classes.application.port.ClassService;
import junseok.snr.classes.application.port.out.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassService classService;
    private final ClassRepository classRepository;

    @PostMapping
    public ResponseEntity<Void> create() {
        classService.create500Classes();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{classId}")
    public ResponseEntity<ClassEntity> getClassInfo(@PathVariable long classId) {
        ClassEntity classEntity = classRepository.findByClassId(classId);

        if (classEntity != null) {
            return ResponseEntity.ok(classEntity);
        }

        return ResponseEntity.notFound().build();
    }
}
