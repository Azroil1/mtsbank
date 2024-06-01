package ru.mtsbank.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtsbank.hw.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String username);
}
