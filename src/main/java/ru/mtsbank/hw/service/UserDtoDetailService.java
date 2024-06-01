package ru.mtsbank.hw.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mtsbank.hw.dto.UserDto;
import ru.mtsbank.hw.entity.User;
import ru.mtsbank.hw.mapperentitytodto.UserMapper;
import ru.mtsbank.hw.repository.UserRepository;

@Service
public class UserDtoDetailService implements UserDetailsService {
    private UserRepository repository;

    public UserDtoDetailService(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDto userDto = UserMapper.toUserDto(user);

        return org.springframework.security.core.userdetails.User
                .withUsername(userDto.getName())
                .password(userDto.getPassword())
                .roles(userDto.getRole())
                .build();
    }
}
