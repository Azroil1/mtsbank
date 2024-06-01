package ru.mtsbank.hw.mapperentitytodto;

import ru.mtsbank.hw.dto.UserDto;
import ru.mtsbank.hw.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),user.getName(),user.getPassword(),user.getRole());
    }
}
