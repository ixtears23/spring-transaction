package junseok.snr.transaction.user.application;

import junseok.snr.core.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto creatUser(String name) {
        return null;
    }

    @Override
    public UserDto getUser(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return List.of();
    }
}