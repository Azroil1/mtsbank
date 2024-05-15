package ru.mtsbank.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtsbank.hw.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
