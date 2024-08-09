package junseok.snr.transaction.user.application;

import junseok.snr.core.user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto creatUser(String name);
    UserDto getUser(Long id);
    List<UserDto> getUsers();
}
