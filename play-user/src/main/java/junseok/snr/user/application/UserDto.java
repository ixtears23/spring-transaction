package junseok.snr.user.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDto {
    private long id;
    private String name;
}
