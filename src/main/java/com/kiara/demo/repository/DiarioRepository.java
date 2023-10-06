package com.kiara.demo.repository;

import com.kiara.demo.entity.Diario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiarioRepository extends JpaRepository<Diario, Long> {
}
