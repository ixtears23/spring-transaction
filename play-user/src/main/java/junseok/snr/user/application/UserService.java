package junseok.snr.user.application;

import java.util.List;

public interface UserService {
    UserDto creatUser(String name);
    UserDto getUser(Long id);
    List<UserDto> getUsers();
}
