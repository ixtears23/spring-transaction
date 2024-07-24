package junseok.snr.transaction.module.user.application;

import junseok.snr.transaction.core.user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto creatUser(String name);
    UserDto getUser(Long id);
    List<UserDto> getUsers();
}
