package ru.mtsbank.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.entity.Provider;
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
