package dev.repository;

import dev.entity.Polluant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolluantRepository extends JpaRepository<Polluant, Long> {
}
